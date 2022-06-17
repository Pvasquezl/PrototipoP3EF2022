-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2022 a las 23:06:28
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_asientos`
--

CREATE TABLE `tbl_asientos` (
  `id_asiento` int(11) NOT NULL,
  `id_sala` int(11) DEFAULT NULL,
  `fila` int(11) DEFAULT NULL,
  `columna` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cine`
--

CREATE TABLE `tbl_cine` (
  `id_cine` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_clientes`
--

CREATE TABLE `tbl_clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nit` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_peliculas`
--

CREATE TABLE `tbl_peliculas` (
  `id_pelicula` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `clasificacion` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `subtitulado` varchar(45) DEFAULT NULL,
  `idioma` varchar(45) DEFAULT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_salas`
--

CREATE TABLE `tbl_salas` (
  `id_sala` int(11) NOT NULL,
  `id_cine` int(11) DEFAULT NULL,
  `descipcion` varchar(100) DEFAULT NULL,
  `formato` varchar(45) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  `precio_sala` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`id_usuario`, `nombre`, `correo`, `contraseña`, `cargo`) VALUES
(1, 'pablo01', 'pablo01@gmail.com', 'quesoverde99', 'cajero');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_asientos`
--
ALTER TABLE `tbl_asientos`
  ADD PRIMARY KEY (`id_asiento`);

--
-- Indices de la tabla `tbl_cine`
--
ALTER TABLE `tbl_cine`
  ADD PRIMARY KEY (`id_cine`);

--
-- Indices de la tabla `tbl_clientes`
--
ALTER TABLE `tbl_clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `tbl_peliculas`
--
ALTER TABLE `tbl_peliculas`
  ADD PRIMARY KEY (`id_pelicula`);

--
-- Indices de la tabla `tbl_salas`
--
ALTER TABLE `tbl_salas`
  ADD PRIMARY KEY (`id_sala`);

--
-- Indices de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_asientos`
--
ALTER TABLE `tbl_asientos`
  MODIFY `id_asiento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_cine`
--
ALTER TABLE `tbl_cine`
  MODIFY `id_cine` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_clientes`
--
ALTER TABLE `tbl_clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_peliculas`
--
ALTER TABLE `tbl_peliculas`
  MODIFY `id_pelicula` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_salas`
--
ALTER TABLE `tbl_salas`
  MODIFY `id_sala` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
