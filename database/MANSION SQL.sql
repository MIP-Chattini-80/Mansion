-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.4.3 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando datos para la tabla mansion.evento: ~0 rows (aproximadamente)

-- Volcando datos para la tabla mansion.eventos: ~0 rows (aproximadamente)

-- Volcando datos para la tabla mansion.habitacion: ~6 rows (aproximadamente)
INSERT INTO `habitacion` (`es_zona_segura`, `id_habitacion`, `descripcion`, `nombre`) VALUES
	(b'1', 1, 'La entrada principal de la mansion.', 'Vestibulo Principal'),
	(b'0', 2, 'Los libros flotan en el techo.', 'Biblioteca Invertida'),
	(b'0', 3, 'La maquina dimensional esta aqui.', 'Sala de Maquinas'),
	(b'1', 4, 'Todo esta limpio, demasiado limpio.', 'Cocina Vacia'),
	(b'0', 5, 'Las luces parpadean constantemente.', 'Pasillo del Eclipse'),
	(b'0', 6, 'La puerta esta bloqueada.', 'Observatorio Sellado');

-- Volcando datos para la tabla mansion.jugador: ~0 rows (aproximadamente)

-- Volcando datos para la tabla mansion.objeto: ~0 rows (aproximadamente)
INSERT INTO `objeto` (`valor_base`, `id_objeto`, `descripcion`, `nombre`, `tipo_objeto`) VALUES
	(500, 1, 'Un reloj roto que altera el tiempo.', 'Reloj Fragmentado', 'Temporal'),
	(300, 2, 'Parecen reaccionar al peligro.', 'Dados Marcados', 'Herramienta'),
	(250, 3, 'Ilumina zonas oscuras.', 'Linterna Azul', 'Exploracion'),
	(700, 4, 'Sirve para reparar tecnologia.', 'Destornillador Dimensional', 'Herramienta'),
	(900, 5, 'Fuente de energia antigua.', 'Nucleo de Energia', 'Energia'),
	(600, 6, 'Abre puertas selladas.', 'Llave Negra', 'Llave'),
	(100, 7, 'Una foto parcialmente quemada.', 'Fotografia Rasgada', 'Historia'),
	(400, 8, 'No apunta al norte.', 'Brujula Extrana', 'Exploracion'),
	(500, 9, 'Herramienta resistente.', 'Llave Inglesa Reforzada', 'Herramienta'),
	(1000, 10, 'Pieza inestable de la maquina.', 'Regulador de Especia', 'Especial');

-- Volcando datos para la tabla mansion.objetos: ~0 rows (aproximadamente)
INSERT INTO `objetos` (`cantidad`, `id_habitacion`, `id_instancia`, `id_objeto`, `estado`) VALUES
	(1, 2, 1, 1, 'Activo'),
	(1, 5, 2, 2, 'Activo'),
	(1, 1, 3, 3, 'Activo'),
	(1, 3, 4, 4, 'Activo'),
	(1, 3, 5, 5, 'Activo'),
	(1, 6, 6, 6, 'Bloqueado'),
	(1, 4, 7, 7, 'Activo'),
	(1, 5, 8, 8, 'Activo'),
	(1, 1, 9, 9, 'Activo'),
	(1, 3, 10, 10, 'Inestable');

-- Volcando datos para la tabla mansion.personaje: ~10 rows (aproximadamente)
INSERT INTO `personaje` (`id_personaje`, `id_personajes`, `nombre`, `serie_procedencia`, `id_habitacion`) VALUES
    (1, 1, 'Ouro Kronii', 'Hololive', 1), 
    (2, 1, 'Raora Panthera', 'Hololive', 1),  
    (3, 2, 'Yelan', 'Genshin Impact', 3), 
    (4, 2, 'Severus Snape', 'Harry Potter', 2), 
    (5, 2, 'Maes Hughes', 'FullMetal Alchemist', 3), 
    (6, 3, 'Beep', 'Kenshi', 4),        
    (7, 4, 'Heinz Doofenshmirtz', 'Phineas and Ferb', 3), 
    (8, 4, 'Jack Sparrow', 'Piratas del Caribe', 6),
    (9, 4, 'Dominic Toretto', 'Rapidos y Furiosos', 4),
    (10, 4, 'Paul Atreides', 'DUNE', 5); 

-- Volcando datos para la tabla mansion.personajes: ~4 rows (aproximadamente)
INSERT INTO `personajes` (`id_personajes`, `categoria_origen`) VALUES
	(1, 'Vtuber'),
	(2, 'Anime'),
	(3, 'Videojuego'),
	(4, 'Pelicula');

-- Volcando datos para la tabla mansion.progreso: ~0 rows (aproximadamente)

-- Volcando datos para la tabla mansion.puerta: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
