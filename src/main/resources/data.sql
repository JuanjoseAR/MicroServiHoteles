-- ===============================
-- CIUDADES
-- ===============================
INSERT INTO ciudad (nombre) VALUES
                                ('Bogotá'),
                                ('Medellín'),
                                ('Cartagena');

-- ===============================
-- HOTELES
-- ===============================
INSERT INTO hoteles (nombre, id_ciudad, telefono, email, estrellas, descripcion) VALUES
                                                                                     ('Hotel Andes', 1, '6011234567', 'info@andeshotel.com', 4, 'Hotel ubicado en el centro de Bogotá.'),
                                                                                     ('Hotel Mar Azul', 3, '6057891234', 'reservas@marazul.com', 5, 'Frente al mar en Cartagena.'),
                                                                                     ('Hotel Colinas', 2, '6044567890', 'contacto@colinas.com', 3, 'Ubicado en las montañas de Medellín.');

-- ===============================
-- TIPOS DE HABITACIONES
-- ===============================
INSERT INTO tipo_de_habitaciones (nombre, precio_por_noche, capacidad, descripcion) VALUES
                                                                                        ('Estándar', 150000, 2, 'Habitación estándar con cama doble.'),
                                                                                        ('Familiar', 250000, 4, 'Habitación familiar con dos camas dobles.'),
                                                                                        ('Suite', 400000, 2, 'Suite con vista al mar y jacuzzi.');

-- ===============================
-- HABITACIONES
-- ===============================
INSERT INTO habitaciones (id_hotel, numero, tipo_habitacion, disponible) VALUES
                                                                             (1, 101, 1, true),
                                                                             (1, 102, 2, true),
                                                                             (2, 201, 3, true),
                                                                             (2, 202, 1, true),
                                                                             (3, 301, 2, true);

-- ===============================
-- CLIENTES
-- ===============================
INSERT INTO clientes (nombre, apellidos, email, telefono, licencia_conducir, direccion, fecha_registro) VALUES
                                                                                                            ('Juan', 'Pérez', 'juan.perez@example.com', '3001112233', '12345678', 'Calle 123', CURRENT_DATE),
                                                                                                            ('María', 'López', 'maria.lopez@example.com', '3002223344', '87654321', 'Avenida 456', CURRENT_DATE);

-- ===============================
-- RESERVAS (opcional)
-- ===============================
-- Este ejemplo está desactivado. Puedes activarlo más adelante.
-- INSERT INTO reservas (id_cliente, id_habitacion, fecha_inicio, fecha_fin, fecha_reserva, estado, total) VALUES
-- (1, 101, '2025-06-10', '2025-06-12', CURRENT_TIMESTAMP, 'Active', 300000);
