-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-02-2021 a las 13:25:44
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `escolapinversores`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acciones`
--

CREATE TABLE `acciones` (
  `ID` int(11) NOT NULL,
  `N_acciones` int(11) DEFAULT NULL,
  `Nombre_Empresa` varchar(50) DEFAULT NULL,
  `Precio_compra` double DEFAULT NULL,
  `Precio_venta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `acciones`
--

INSERT INTO `acciones` (`ID`, `N_acciones`, `Nombre_Empresa`, `Precio_compra`, `Precio_venta`) VALUES
(1, 52551, 'Acciona', 9.9, 39.64),
(2, 51684, 'Acerinox', 40, 39.36),
(3, 93362, 'ACS', 37.03, 36.82),
(4, 59688, 'Aena', 24.08, 17.32),
(5, 92162, 'Almirall', 25.38, 13.39),
(6, 70795, 'Amadeus', 45.47, 36.44),
(7, 39656, 'Arcelormit', 35.24, 46.63),
(8, 78281, 'B.Santander', 10.96, 5),
(9, 85831, 'Ba.Sabadell', 19.13, 40.06),
(10, 30455, 'Bankia', 25.56, 10.62),
(11, 21090, 'Bankinter', 14.52, 6.95),
(12, 53638, 'BBVA', 8.89, 22.57);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acciones_en_propiedad`
--

CREATE TABLE `acciones_en_propiedad` (
  `ID_Cuenta` int(11) DEFAULT NULL,
  `ID_Accion` int(11) DEFAULT NULL,
  `Num_acciones` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `acciones_en_propiedad`
--

INSERT INTO `acciones_en_propiedad` (`ID_Cuenta`, `ID_Accion`, `Num_acciones`) VALUES
(24, 5, 300),
(24, 4, 200),
(24, 9, 300),
(24, 2, 100),
(24, 8, 50),
(24, 3, 10),
(24, 9, 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `DNI` varchar(9) DEFAULT NULL,
  `Cuenta_real` varchar(50) DEFAULT NULL,
  `Fecha_nacimiento` date DEFAULT NULL,
  `Domicilio` varchar(50) DEFAULT NULL,
  `Telefono` varchar(50) DEFAULT NULL,
  `Contraseña` varchar(50) NOT NULL,
  `Baja` int(11) NOT NULL DEFAULT 1,
  `Tipo_usuario` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`ID`, `Nombre`, `Apellido`, `DNI`, `Cuenta_real`, `Fecha_nacimiento`, `Domicilio`, `Telefono`, `Contraseña`, `Baja`, `Tipo_usuario`) VALUES
(100, 'Paco', 'Tonto', '999999999', '232545243', '1990-09-11', 'C/Falsa 123', '67467263', '9', 0, 2),
(101, 'Pablo', 'Ruiz', '888888888', '235234', '1995-09-30', 'C/Falsa 123', '654756756', '9', 0, 3),
(104, 'Raúl', 'Almorox', '111111111', '424565335', '2001-03-07', 'C/Falsa 123', '645654646', '1', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `ID` int(11) NOT NULL,
  `ID_Cliente` int(11) DEFAULT NULL,
  `Saldo` double DEFAULT 200,
  `Perdidas_Beneficios` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`ID`, `ID_Cliente`, `Saldo`, `Perdidas_Beneficios`) VALUES
(24, 104, 2386, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `ID` int(11) NOT NULL,
  `ID_Cuenta` int(11) DEFAULT NULL,
  `ID_Accion` int(11) DEFAULT NULL,
  `Compra_venta` enum('c','v') DEFAULT NULL,
  `Fecha_orden` date DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Fecha_validacion` date DEFAULT NULL,
  `Validacion` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`ID`, `ID_Cuenta`, `ID_Accion`, `Compra_venta`, `Fecha_orden`, `Cantidad`, `Precio`, `Fecha_validacion`, `Validacion`) VALUES
(141, 24, 5, 'c', '2021-02-25', 300, 7614, '2021-02-25', 1),
(143, 24, 12, 'v', '2021-02-25', 100, 889, NULL, 0),
(144, 24, 4, 'v', '2021-02-25', 500, 12040, NULL, 0),
(145, 24, 3, 'v', '2021-02-25', 100, 3703, NULL, 0),
(146, 24, 5, 'c', '2021-02-25', 200, 990, NULL, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acciones`
--
ALTER TABLE `acciones`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `acciones_en_propiedad`
--
ALTER TABLE `acciones_en_propiedad`
  ADD KEY `ID_Cuenta` (`ID_Cuenta`),
  ADD KEY `ID_Accion` (`ID_Accion`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Cliente` (`ID_Cliente`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Cuenta` (`ID_Cuenta`),
  ADD KEY `ID_Accion` (`ID_Accion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `acciones`
--
ALTER TABLE `acciones`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=147;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `acciones_en_propiedad`
--
ALTER TABLE `acciones_en_propiedad`
  ADD CONSTRAINT `acciones_en_propiedad_ibfk_1` FOREIGN KEY (`ID_Cuenta`) REFERENCES `cuenta` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `acciones_en_propiedad_ibfk_2` FOREIGN KEY (`ID_Accion`) REFERENCES `acciones` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `cuenta_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `clientes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`ID_Cuenta`) REFERENCES `cuenta` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `movimientos_ibfk_2` FOREIGN KEY (`ID_Accion`) REFERENCES `acciones` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
