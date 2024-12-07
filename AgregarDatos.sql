

drop table cliente;
drop table trabajador;
drop table gerente;
drop table vendedor;
drop table dtsupervision;
drop table jfalmacen;
DROP TABLE categoria;
drop table marca;
drop table producto;
drop table venta;
drop table dtrealiza;
drop table dtventa;
drop table ingresa;
drop table dtingresa;

create procedure SeleccionarProducto() SELECT * FROM Producto;
SELECT codigoProducto, idMarca, idCategoria, p_stock, p_precio, p_talla, p_color FROM Producto;

select * FROM Producto;
SELECT p_stock FROM Producto WHERE codigoProducto = 'PR00002';
select codigoProducto, idMarca, idCategoria, p_stock, p_precio, p_talla, p_color from Producto; 
SELECT * FROM Producto;
select 
	p.codigoProducto,
    m.m_nombreMarca,
    c.cate_categoria,
    ee.pvd_nombre,
    p.p_stock,
    p.p_precio,
    p.p_talla,
    p.p_color
 from Producto as p join Marca as m on m.idMarca = p.idMarca 
 join Categoria as c on c.idCategoria = p.idCategoria 
 join Proveedor as ee on ee.idProveedor = p.idProveedor
 where p.codigoProducto LIKE '%%' AND 
 m.m_nombreMarca LIKE '%%' AND 
 c.cate_categoria like '%%' and 
 ee.pvd_nombre like '%%';

select t_usuario, t_contraseña, t_tipoTrabajador from Trabajador;
select * from Vendedor Join Trabajador on Trabajador.codigoTrabajador = Vendedor.codigoVendedor
;  
select * from Venta;
select * from DTVenta;
select * from DTRealiza;
select * from JFAlmacen;
select * from marca;
select * from Trabajador;
select * from Gerente;
select * from Vendedor;
delete from Vendedor where codigoVendedor = 'T0000001';
select * from Cliente;

delete from trabajador where codigoTrabajador = 'PRUEBA';

INSERT INTO Trabajador (codigoTrabajador, t_nombre, t_apellido, t_dni, t_genero, t_correo, t_celular, t_edad, t_usuario, t_contraseña, t_tipoTrabajador, t_sueldo) VALUES
('PRUEBA', 'Jorge', 'Ramírez', '45613', 'M', 'jorge12ramirez@example.com', '91745678', 35, 'DASD', 'pass1234', 1, 2500.00);
INSERT INTO Vendedor (codigoVendedor, v_comision) VALUES ('PRUEBA', 500.00);

INSERT INTO Cliente (codigoCliente, c_nombre, c_apellido, c_dni, c_genero, c_correo, c_celular, c_edad) VALUES
('C0000001', 'Carlos', 'Pérez', '12345678', 'M', 'carlos.perez@example.com', '987654321', 30),
('C0000002', 'Ana', 'García', '23456789', 'F', 'ana.garcia@example.com', '987654322', 25),
('C0000003', 'Luis', 'Rodríguez', '34567890', 'M', 'luis.rodriguez@example.com', '987654323', 40),
('C0000004', 'María', 'López', '45678901', 'F', 'maria.lopez@example.com', '987654324', 35),
('C0000005', 'Juan', 'Martínez', '56789012', 'M', 'juan.martinez@example.com', '987654325', 28),
('C0000006', 'Laura', 'Fernández', '67890123', 'F', 'laura.fernandez@example.com', '987654326', 32),
('C0000007', 'Pedro', 'Sánchez', '78901234', 'M', 'pedro.sanchez@example.com', '987654327', 45),
('C0000008', 'Lucía', 'Gómez', '89012345', 'F', 'lucia.gomez@example.com', '987654328', 22),
('C0000009', 'Roberto', 'Díaz', '90123456', 'M', 'roberto.diaz@example.com', '987654329', 38),
('C0000010', 'Sofía', 'Morales', '01234567', 'F', 'sofia.morales@example.com', '987654330', 26);



-- Insertar datos en la tabla Trabajador
INSERT INTO Trabajador (codigoTrabajador, t_nombre, t_apellido, t_dni, t_genero, t_correo, t_celular, t_edad, t_usuario, t_contraseña, t_tipoTrabajador, t_sueldo) VALUES
('T0000001', 'Jorge', 'Ramírez', '11223344', 'M', 'jorge.ramirez@example.com', '912345678', 35, 'jramirez', 'pass1234', 1, 2500.00),
('T0000002', 'Elena', 'Hernández', '22334455', 'F', 'elena.hernandez@example.com', '923456789', 28, 'ehernandez', 'pass5678', 2, 1800.00),
('T0000003', 'Mario', 'Torres', '33445566', 'M', 'mario.torres@example.com', '934567890', 40, 'mtorres', 'pass91011', 1, 3200.00),
('T0000004', 'Lucía', 'Ramírez', '44556677', 'F', 'lucia.ramirez@example.com', '945678901', 30, 'lramirez', 'pass1213', 2, 2000.00),
('T0000005', 'Raúl', 'González', '55667788', 'M', 'raul.gonzalez@example.com', '956789012', 45, 'rgonzalez', 'pass1415', 3, 2800.00),
('T0000006', 'Sofía', 'López', '66778899', 'F', 'sofia.lopez@example.com', '967890123', 32, 'slopez', 'pass1617', 3, 3100.00),
('T0000007', 'Carlos', 'Martínez', '77889900', 'M', 'carlos.martinez@example.com', '978901234', 38, 'cmartinez', 'pass1819', 1, 2700.00),
('T0000008', 'María', 'Díaz', '88990011', 'F', 'maria.diaz@example.com', '989012345', 27, 'mdiaz', 'pass2021', 2, 2200.00),
('T0000009', 'Fernando', 'Castro', '99001122', 'M', 'fernando.castro@example.com', '990123456', 42, 'fcastro', 'pass2223', 3, 2900.00),
('T0000010', 'Ana', 'Morales', '10111223', 'F', 'ana.morales@example.com', '901234567', 29, 'amorales', 'pass2425', 1, 2600.00);

-- Insertar datos en la tabla Vendedor
INSERT INTO Vendedor (codigoVendedor, v_comision) VALUES
('T0000001', 500.00),
('T0000003', 600.00),
('T0000007', 550.00),
('T0000010', 700.00);

-- Insertar datos en la tabla Gerente
INSERT INTO Gerente (codigoGerente, g_area) VALUES
('T0000002', 'Ventas'),
('T0000004', 'Marketing'),
('T0000008', 'Recursos Humanos');

-- Insertar datos en la tabla DTSupervision
INSERT INTO DTSupervision (codigoVendedor, codigoGerente) VALUES
('T0000001', 'T0000002'),
('T0000003', 'T0000002'),
('T0000007', 'T0000004'),
('T0000010', 'T0000008');

-- Insertar datos en la tabla JFAlmacen
INSERT INTO JFAlmacen (codigoJFAlmacen, jfa_area) VALUES
('T0000005', 'Almacen Central'),
('T0000006', 'Almacen Secundario'),
('T0000009', 'Almacen Principal');

INSERT INTO Categoria(cate_categoria, cate_observaciones) VALUES
('Pantalon', ''),
('Medias', ''),
('Polo', ''),
('Camisa', ''),
('Zapatos', ''),
('Accesorios', '');

-- Insertar datos en la tabla Marca
INSERT INTO Marca (m_nombreMarca, m_observaciones) VALUES
('Nike', ''),
('Adidas', ''),
('Levi', ''),
('Gucci', ''),
('Puma', ''),
('Under Armour', '');


INSERT INTO Proveedor (pvd_nombre, pvd_observacion) VALUES
('Textilera Los Andes', 'Proveedor de telas y tejidos de alta calidad'),
('Distribuidora Moda S.A.', 'Proveedor de ropa casual y formal'),
('Fashion Importers', 'Importador de ropa de marca internacional'),
('Calzado Global', 'Proveedor de calzado deportivo y casual'),
('Accesorios Chic', 'Proveedor de accesorios de moda y complementos'),
('Ropa Deportiva Elite', 'Proveedor especializado en ropa deportiva');


INSERT INTO Producto (codigoProducto, idMarca, idCategoria, idProveedor, p_stock, p_precio, p_talla, p_color) VALUES
('PR00001', 1, 1, 1, 100, 49.99, 'M', 'Azul'),
('PR00002', 2, 1, 2, 80, 59.99, 'L', 'Negro'),
('PR00003', 3, 2, 3, 120, 39.99, '32', 'Gris'),
('PR00004', 4, 3, 1, 50, 129.99, '39', 'Blanco'),
('PR00005', 5, 4, 4, 200, 19.99, 'Única', 'Rojo'),
('PR00006', 6, 5, 5, 150, 89.99, '7.5', 'Negro');


INSERT INTO Producto (codigoProducto, idMarca, idCategoria, idProveedor, p_stock, p_precio, p_talla, p_color) VALUES
('PR00011', 1, 1, 1, 100, 49.99, 'M', 'Azul'),
('PR00012', 2, 1, 2, 100, 49.99, 'M', 'Rojo'),
('PR00013', 3, 1, 1, 100, 49.99, 'M', 'Blanco'),
('PR00021', 2, 2, 2, 80, 59.99, 'L', 'Negro'),
('PR00022', 3, 2, 1, 120, 39.99, '32', 'Gris'),
('PR00023', 3, 2, 2, 120, 39.99, '32', 'Blanco'),
('PR00031', 3, 3, 1, 120, 39.99, '32', 'Rojo'),
('PR00032', 3, 3, 2, 120, 39.99, '32', 'Blanco'),
('PR00033', 3, 3, 1, 200, 19.99, 'Única', 'Rojo'),
('PR00041', 6, 5, 1, 150, 89.99, '7.5', 'Negro');

INSERT INTO Venta (nroVenta, codigoCliente, codigoVendedor, v_montoFinal, v_descuentoTotal, v_metodoPago, v_comprobantePago)
VALUES
('V0000001', 'C0000001', 'T0000001', 250.00, 0.00, 'Tarjeta', 'TC2024001'),
('V0000002', 'C0000003', 'T0000001', 320.00, 15.00, 'Efectivo', 'FV2024002'),
('V0000003', 'C0000005', 'T0000003', 180.00, 0.00, 'Transferencia', 'TB2024003'),
('V0000004', 'C0000007', 'T0000007', 200.00, 10.00, 'Tarjeta', 'TD2024004'),
('V0000005', 'C0000009', 'T0000003', 290.00, 20.00, 'Efectivo', 'FV2024005');


INSERT INTO DTVenta (nroVenta, codigoProducto, dtv_cantidad, dtv_total, dtv_descuento)
VALUES
('V0000001', 'PR00001', 2, 90.00, 5.00),
('V0000001', 'PR00003', 1, 39.99, 0.00),
('V0000002', 'PR00002', 1, 59.99, 10.00),
('V0000003', 'PR00004', 3, 389.97, 20.00),
('V0000003', 'PR00005', 2, 39.98, 0.00),
('V0000004', 'PR00001', 1, 45.00, 0.00),
('V0000004', 'PR00006', 2, 179.98, 10.00),
('V0000005', 'PR00003', 2, 79.98, 15.00);


INSERT INTO DTRealiza (codigoVendedor, nroVenta)
VALUES
('T0000001', 'V0000001'),
('T0000001', 'V0000002'),
('T0000007', 'V0000003'),
('T0000003', 'V0000004'),
('T0000003', 'V0000005');

INSERT INTO DTIngresa (codigoJFAlmacen, codigoProducto)
VALUES
('T0000005', 'PR00001'),
('T0000005', 'PR00002'),
('T0000006', 'PR00003'),
('T0000006', 'PR00001');


#Select * from Trabajador join Vendedor on Vendedor.codigoVendedor = Trabajador.codigoTrabajador; 
