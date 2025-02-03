CREATE DATABASE IF NOT EXISTS `develop`;

CREATE TABLE `BRANCH_OFFICE` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FRANCHISE` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `BRANCH_OFFICE_PRODUCT` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `branch_office_id` bigint NOT NULL,
  `product_id` varchar(100) NOT NULL,
  `stock` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `BRANCH_OFFICE_PRODUCT_UN` (`branch_office_id`,`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FRANCHISE_BRANCH_OFFICE` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `franchise_id` bigint NOT NULL,
  `branch_office_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FRANCHISE_BRANCH_OFFICE_UN` (`franchise_id`,`branch_office_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;