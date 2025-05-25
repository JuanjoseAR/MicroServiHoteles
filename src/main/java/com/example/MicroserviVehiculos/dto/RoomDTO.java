package com.example.MicroserviVehiculos.dto;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {
    private Long id;
    private Long hotelId;
    private int number;
    private Long roomTypeId;
    private boolean available;
}
