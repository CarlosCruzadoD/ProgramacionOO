
drop database TiendaMartita;
create database TiendaMartita;
use TiendaMartita;

create table Cliente(
	codigoCliente char(8) not null,
    c_nombre varchar(20) not null,
    c_apellido varchar(20) not null,
	c_dni char(8) unique,
    c_genero char(8),
    c_correo varchar(100),
    c_celular char(9),
    c_edad int,    
    constraint pk_cliente_codigoCliente primary key(codigoCliente)
);


create table Trabajador(
	codigoTrabajador char(8) not null primary key,
    t_nombre varchar(20) not null,
    t_apellido varchar(20) not null,
	t_dni char(8) not null unique,
    t_genero char(8) not null,
    t_correo varchar(100) not null,
    t_celular char(9) not null,
    t_edad int not null,
    t_usuario varchar(20) not null unique,
    t_contraseña varchar(64) not null,
    t_tipoTrabajador int not null,
    t_sueldo decimal(7,2) not null check(t_sueldo >= 1025)
);

INSERT INTO Trabajador (codigoTrabajador, t_nombre, t_apellido, t_dni, t_genero, t_correo, t_celular, t_edad, t_usuario, t_contraseña, t_tipoTrabajador, t_sueldo) VALUES
('Ven-32', 'Jorge', 'Ramírez', '11222544', 'M', 'jor1ge.ramirez@example.com', '912645678', 35, 'juan', 'pass1234', 1, 2500.00);
INSERT INTO Vendedor (codigoVendedor, v_comision) VALUES
('Ven-32', 500.00);

create table Vendedor(
	codigoVendedor char(8) not null,
    v_comision decimal(7,2) not null check(v_comision >= 0),
    constraint fk_Vendedor_codigoVendedor foreign key (codigoVendedor) 
    references Trabajador(codigoTrabajador) 
    on delete cascade
    on update cascade
);

create table Gerente(
	codigoGerente char(8) not null,
    g_area varchar(20) not null,
    constraint fk_Gerente_codigoGerente foreign key(codigoGerente) 
    references Trabajador(codigoTrabajador)
    on delete cascade
    on update cascade
);

create table DTSupervision(
	codigoVendedor char(8) not null,
    codigoGerente char(8) not null,
    constraint pk_DTSupervision_supervision primary key(codigoVendedor,codigoGerente), 
	constraint fk_DTSupervision_codigoVendedor foreign key(codigoVendedor) references Vendedor(codigoVendedor)
    on delete cascade
    on update cascade,
    constraint fk_DTSupervision_codigoGerente foreign key(codigoGerente) references Gerente(codigoGerente)
    on delete cascade
    on update cascade
);

create table JFAlmacen(
	codigoJFAlmacen char(8) not null primary key,
    jfa_area varchar(20) not null,
    constraint fk_JFAlmacen_codigoJFAlmacen foreign key(codigoJFAlmacen) references Trabajador(codigoTrabajador)
    on delete cascade
    on update cascade
);

create table Categoria(
	idCategoria int not null auto_increment,
    cate_categoria varchar(50) not null,
    cate_observaciones varchar(100),
    constraint pk_categoria_idCategoria primary	key(idCategoria)
);

create table Marca(
	idMarca int not null auto_increment primary	key,
    m_nombreMarca varchar(50) not null,
    m_observaciones varchar(100)
);

create table Proveedor(
	idProveedor int not null auto_increment primary key,
    pvd_nombre varchar(100) not null,
    pvd_observacion varchar(100)
);

create table Producto (
	codigoProducto char(8) not null,
    idMarca int not null,
    idCategoria int not null,
    idProveedor int not null,
    p_stock int not null check(p_stock >= 0),
    p_precio decimal(7,2) not null check(p_precio >= 0) ,
    p_talla char(8) not null,
    p_color varchar(20),
    constraint pk_producto_codigoProducto primary key(codigoProducto),
    constraint fk_producto_idMarca foreign key(idMarca) references Marca(idMarca)
    on delete cascade
    on update cascade,
    constraint fk_producto_idCategoria foreign key(idCategoria) references Categoria(idCategoria)
    on delete cascade
    on update cascade,
    constraint fk_producto_idProveedor foreign key(idProveedor) references Proveedor(idProveedor)
    on delete cascade
    on update cascade
);


create table Venta(
	nroVenta char(8) not null,
    codigoCliente char(8) not null,
    codigoVendedor char(8) not null,
    v_montoFinal decimal(7,2) not null check(v_montoFinal >= 0),
    v_descuentoTotal decimal(5,2) not null check(v_descuentoTotal >= 0),
    v_metodoPago varchar(100) not null,
    v_comprobantePago varchar(100) not null,
    v_fechaVenta datetime default NOW(),
    constraint pk_Venta_nroVenta primary key(nroVenta),
    constraint fk_Venta_codigoCliente foreign key(codigoCliente) references Cliente(codigoCliente)
    on delete cascade
    on update cascade,
    constraint fk_Venta_codigoVendedor foreign key(codigoVendedor) references Vendedor(codigoVendedor)    
    on update cascade
);

create table DTRealiza(
	codigoVendedor char(8) not null,
    nroVenta char(8) not null,
    constraint pk_DTRealiza_realiza primary key(codigoVendedor, nroVenta),
    constraint fk_DTRealiza_codigoVendedor foreign key(codigoVendedor) references Vendedor(codigoVendedor)
    on delete cascade
    on update cascade,
    constraint fk_DTRealiza_nroVenta foreign key(nroVenta) references Venta(nroVenta)
    on delete cascade
    on update cascade
);

create table DTVenta(
	nroVenta char(8) not null,
    codigoProducto char(8) not null,
    dtv_cantidad int not null check(dtv_cantidad >= 0),
    dtv_total decimal(8,2) not null check(dtv_total >= 0),
    dtv_descuento decimal(5,2) not null check(dtv_descuento >= 0),
    constraint pk_DTVenta_venta primary key(nroVenta, codigoProducto),
    constraint fk_DTVenta_codigoProducto foreign key(codigoProducto) references Producto(codigoProducto)
    on delete cascade
    on update cascade,
    constraint fk_DTVenta_nroVenta foreign key(nroVenta) references Venta(nroVenta)
    on delete cascade
    on update cascade
);

create table DTIngresa(
	codigoJFAlmacen char(8) not null,
    codigoProducto char(8) not null,
    dti_fechaIngresa datetime default NOW(),
	constraint pk_DTIngresa_ingresa primary key(codigoJFAlmacen, codigoProducto),
    constraint fk_DTIngresa_codigoProducto foreign key(codigoProducto) references Producto(codigoProducto)
    on delete cascade
    on update cascade,
    constraint fk_DTIngresa_codigoTrabajador foreign key(codigoJFAlmacen) references JFAlmacen(codigoJFAlmacen)
    on delete cascade
    on update cascade
);
