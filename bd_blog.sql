-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-05-2024 a las 23:04:29
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_blog`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `contenido` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `posts`
--

INSERT INTO `posts` (`id`, `fecha`, `titulo`, `contenido`) VALUES
(3, '2024-05-14', 'Las Tendencias Tecnologicas del 2024: Lo que Necesitas Saber', 'En 2024, el panorama tecnolÃÂ³gico estÃÂ¡ mÃÂ¡s vibrante que nunca. Desde avances en inteligencia artificial hasta innovaciones en realidad aumentada, este aÃÂ±o promete cambios que transformarÃÂ¡n nuestra forma de vivir y trabajar. Las empresas estÃÂ¡n invirtiendo en tecnologÃÂ­as verdes y sostenibles, mientras que la ciberseguridad se ha convertido en una prioridad mÃÂ¡xima debido al aumento de las amenazas digitales. AcompÃÂ¡ÃÂ±anos mientras exploramos las tendencias mÃÂ¡s significativas y cÃÂ³mo impactarÃÂ¡n en diferentes industrias.'),
(4, '2024-05-01', 'CÃ³mo la MeditaciÃ³n Puede Mejorar tu Salud Mental', 'La meditaciÃ³n ha demostrado ser una herramienta poderosa para mejorar la salud mental y el bienestar general. Estudios recientes han encontrado que practicar la meditaciÃ³n regularmente puede reducir los niveles de estrÃ©s, ansiedad y depresiÃ³n. AdemÃ¡s, mejora la concentraciÃ³n y la claridad mental. En este artÃ­culo, exploraremos diferentes tÃ©cnicas de meditaciÃ³n, cÃ³mo empezar y cÃ³mo integrar esta prÃ¡ctica en tu rutina diaria para obtener los mÃ¡ximos beneficios.');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
