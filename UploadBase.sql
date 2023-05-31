-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for curso
CREATE DATABASE IF NOT EXISTS `curso` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `curso`;

-- Dumping structure for table curso.categorias
CREATE TABLE IF NOT EXISTS `categorias` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table curso.categorias: ~17 rows (approximately)
INSERT INTO `categorias` (`id`, `nome`) VALUES
	(1, 'CELULARES'),
	(2, 'CELULARES'),
	(3, 'CELULARES'),
	(4, 'CELULARES'),
	(5, 'CELULARES'),
	(6, 'CELULARES'),
	(7, 'CELULARES'),
	(8, 'CELULARES'),
	(9, 'CELULARES'),
	(10, 'CELULARES'),
	(11, 'CELULARES'),
	(12, 'CELULARES'),
	(13, 'CELULARES'),
	(14, 'CELULARES'),
	(15, 'CELULARES'),
	(16, 'CELULARES'),
	(17, 'CELULARES'),
	(18, 'CELULARES'),
	(19, 'CELULARES'),
	(20, 'CELULARES'),
	(21, 'CELULARES'),
	(22, 'CELULARES'),
	(23, 'NOTEBOOKS'),
	(24, 'VIDEO GAMES'),
	(25, 'Carros'),
	(26, 'CELULARES'),
	(27, 'NOTEBOOKS'),
	(28, 'VIDEO GAMES'),
	(29, 'Carros'),
	(30, 'CELULARES'),
	(31, 'NOTEBOOKS'),
	(32, 'VIDEO GAMES'),
	(33, 'Carros'),
	(34, 'CELULARES'),
	(35, 'NOTEBOOKS'),
	(36, 'VIDEO GAMES'),
	(37, 'Carros');

-- Dumping structure for table curso.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table curso.clientes: ~16 rows (approximately)
INSERT INTO `clientes` (`id`, `cpf`, `nome`) VALUES
	(1, '123456', 'Rodrigo'),
	(2, '123456', 'Rodrigo'),
	(3, '123456', 'Rodrigo'),
	(4, '123456', 'Kaue de matos'),
	(5, '123456', 'Kaue de matos'),
	(6, '123456', 'Kaue de matos'),
	(7, '123456', 'Kaue de matos'),
	(8, '123456', 'Kaue de matos'),
	(9, '123456', 'Kaue de matos'),
	(10, '123456', 'Kaue de matos'),
	(11, '123456', 'Kaue de matos'),
	(12, '123456', 'Kaue de matos'),
	(13, '123456', 'Kaue de matos'),
	(14, '123456', 'Kaue de matos'),
	(15, '123456', 'Kaue de matos'),
	(16, '123456', 'Kaue de matos'),
	(17, '123456', 'Kaue de matos'),
	(18, '123456', 'Kaue de matos'),
	(19, '123456', 'Kaue de matos'),
	(20, '123456', 'Kaue de matos'),
	(21, '123456', 'Kaue de matos'),
	(22, '123456', 'Kaue de matos'),
	(23, '123456', 'Kaue de matos'),
	(24, '123456', 'Kaue de matos');

-- Dumping structure for table curso.itens_pedido
CREATE TABLE IF NOT EXISTS `itens_pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `preco_unitario` decimal(38,2) DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  `pedido_id` bigint(20) DEFAULT NULL,
  `produto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK42mycompce3b7yt3l6ukdwsxy` (`pedido_id`),
  KEY `FKxytdlekpdaobqphujy9bmuhl` (`produto_id`),
  CONSTRAINT `FK42mycompce3b7yt3l6ukdwsxy` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id`),
  CONSTRAINT `FKxytdlekpdaobqphujy9bmuhl` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table curso.itens_pedido: ~10 rows (approximately)
INSERT INTO `itens_pedido` (`id`, `preco_unitario`, `quantidade`, `pedido_id`, `produto_id`) VALUES
	(1, 800.00, 10, 1, 2),
	(2, 800.00, 10, 2, 2),
	(3, 800.00, 10, 3, 2),
	(4, 800.00, 10, 4, 2),
	(5, 800.00, 10, 5, 2),
	(9, 800.00, 10, 9, 2),
	(10, 800.00, 10, 10, 2),
	(11, 800.00, 10, 11, 2),
	(15, 800.00, 10, 15, 2),
	(16, 800.00, 10, 16, 2),
	(18, 800.00, 10, 18, 2),
	(19, 800.00, 10, 19, 2),
	(20, 800.00, 10, 20, 2),
	(21, 800.00, 10, 21, 2),
	(22, 800.00, 10, 22, 2),
	(23, 800.00, 10, 23, 2),
	(24, 800.00, 10, 24, 2);

-- Dumping structure for table curso.pedidos
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `valor_total` decimal(38,2) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg7202lk0hwxn04bmdl2thth5b` (`cliente_id`),
  CONSTRAINT `FKg7202lk0hwxn04bmdl2thth5b` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table curso.pedidos: ~10 rows (approximately)
INSERT INTO `pedidos` (`id`, `data`, `valor_total`, `cliente_id`) VALUES
	(1, '2023-05-29', NULL, 1),
	(2, '2023-05-29', NULL, 1),
	(3, '2023-05-29', NULL, 1),
	(4, '2023-05-29', NULL, 1),
	(5, '2023-05-29', NULL, 1),
	(9, '2023-05-29', 8000.00, 1),
	(10, '2023-05-30', 8000.00, 1),
	(11, '2023-05-30', 8000.00, 1),
	(15, '2023-05-30', 8000.00, 1),
	(16, '2023-05-30', 8000.00, 1),
	(18, '2023-05-30', 8000.00, 1),
	(19, '2023-05-30', 8000.00, 1),
	(20, '2023-05-30', 8000.00, 1),
	(21, '2023-05-30', 8000.00, 1),
	(22, '2023-05-30', 8000.00, 1),
	(23, '2023-05-30', 8000.00, 1),
	(24, '2023-05-30', 8000.00, 1);

-- Dumping structure for table curso.produtos
CREATE TABLE IF NOT EXISTS `produtos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataCadastro` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` decimal(38,2) DEFAULT NULL,
  `categoria_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8rqw0ljwdaom34jr2t46bjtrn` (`categoria_id`),
  CONSTRAINT `FK8rqw0ljwdaom34jr2t46bjtrn` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table curso.produtos: ~25 rows (approximately)
INSERT INTO `produtos` (`id`, `dataCadastro`, `descricao`, `nome`, `preco`, `categoria_id`) VALUES
	(1, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 1),
	(2, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 2),
	(3, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 3),
	(4, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 4),
	(5, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 5),
	(6, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 6),
	(7, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 7),
	(8, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 8),
	(9, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 9),
	(10, '2023-05-29', 'Muito legal', 'Xiaomi Redmi', 800.00, 10),
	(11, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 11),
	(12, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 12),
	(13, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 13),
	(14, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 14),
	(15, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 15),
	(16, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 16),
	(17, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 17),
	(18, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 18),
	(19, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 19),
	(20, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 20),
	(21, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 21),
	(22, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 22),
	(23, '2023-05-30', 'Otimo', 'Macbook', 1000.00, 23),
	(24, '2023-05-30', 'muito ruim', 'PS5', 5000.00, 24),
	(25, '2023-05-30', 'Otimo', 'Fusca de brinquedo', 10000000.00, 25),
	(26, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 26),
	(27, '2023-05-30', 'Otimo', 'Macbook', 1000.00, 27),
	(28, '2023-05-30', 'muito ruim', 'PS5', 5000.00, 28),
	(29, '2023-05-30', 'Otimo', 'Fusca de brinquedo', 10000000.00, 29),
	(30, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 30),
	(31, '2023-05-30', 'Otimo', 'Macbook', 1000.00, 31),
	(32, '2023-05-30', 'muito ruim', 'PS5', 5000.00, 32),
	(33, '2023-05-30', 'Otimo', 'Fusca de brinquedo', 10000000.00, 33),
	(34, '2023-05-30', 'Muito legal', 'Xiaomi Redmi', 800.00, 34),
	(35, '2023-05-30', 'Otimo', 'Macbook', 1000.00, 35),
	(36, '2023-05-30', 'muito ruim', 'PS5', 5000.00, 36),
	(37, '2023-05-30', 'Otimo', 'Fusca de brinquedo', 10000000.00, 37);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
