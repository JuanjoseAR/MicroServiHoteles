package com.example.MicroserviVehiculos.service.Impl;

import com.example.MicroserviVehiculos.dao.ClientRepository;
import com.example.MicroserviVehiculos.dao.ReservationRepository;
import com.example.MicroserviVehiculos.dao.RoomRepository;
import com.example.MicroserviVehiculos.dto.ReservationDTO;
import com.example.MicroserviVehiculos.model.Reservation;
import com.example.MicroserviVehiculos.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepo;
    private final ClientRepository clientRepo;
    private final RoomRepository roomRepo;

    @Override
    public List<ReservationDTO> getByClientId(Long clientId) {
        return reservationRepo.findByClientId(clientId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO getById(Long id) {
        Reservation reservation = reservationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return mapToDTO(reservation);
    }

    @Override
    public ReservationDTO updateReservation(Long id, ReservationDTO dto) {
        Reservation reservation = reservationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        if (!reservation.getStatus().equalsIgnoreCase("Active") || reservation.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("This reservation cannot be modified");
        }

        reservation.setStartDate(dto.getStartDate());
        reservation.setEndDate(dto.getEndDate());
        reservation.setRoom(roomRepo.findById(dto.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found")));
        reservation.setTotal(dto.getTotal());

        return mapToDTO(reservationRepo.save(reservation));
    }

    @Override
    public void cancelReservation(Long id) {
        Reservation reservation = reservationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        if (!reservation.getStatus().equalsIgnoreCase("Active") || reservation.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot cancel a reservation that is in progress or finished");
        }

        reservation.setStatus("Cancelled");
        reservationRepo.save(reservation);
    }

    private ReservationDTO mapToDTO(Reservation r) {
        return ReservationDTO.builder()
                .id(r.getId())
                .clientId(r.getClient().getId())
                .roomId(r.getRoom().getId())
                .startDate(r.getStartDate())
                .endDate(r.getEndDate())
                .reservationDate(r.getReservationDate())
                .status(r.getStatus())
                .total(r.getTotal())
                .build();
    }

    @Override
    public ReservationDTO createReservation(ReservationDTO dto) {
        var client = clientRepo.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        var room = roomRepo.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // Validar disponibilidad (reservas que se solapan)
        boolean haySolapamiento = reservationRepo.existsByRoomIdAndStartDateLessThanAndEndDateGreaterThanAndStatus(
                dto.getRoomId(), dto.getEndDate(), dto.getStartDate(), "Active");

        if (haySolapamiento) {
            throw new RuntimeException("Room is already reserved in the selected dates.");
        }

        // Calcular noches
        long noches = dto.getEndDate().toEpochDay() - dto.getStartDate().toEpochDay();
        if (noches <= 0) throw new RuntimeException("Invalid date range");

        double precioNoche = room.getTipoHabitacion().getPrecioPorNoche();
        double total = noches * precioNoche;

        Reservation reservation = Reservation.builder()
                .client(client)
                .room(room)
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .reservationDate(LocalDateTime.now())
                .status("Active")
                .total(total)
                .build();

        return mapToDTO(reservationRepo.save(reservation));
    }

}
