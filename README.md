# PBOD5

Project Mata Kuliah Pemrograman Berorientasi Objek UNUD 2023

Create .env:
```
DB_USER=root
DB_PASS=YOUR_DB_PASS
```

table migrations:
```
CREATE TABLE `medicines` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `pharma` varchar(45) NOT NULL,
  `production_date` date NOT NULL,
  `price` int NOT NULL,
  `stock` int NOT NULL,
  `category` varchar(45) NOT NULL,
  `expired_date` date NOT NULL,
  `side_effect` varchar(45) NOT NULL,
  `dose` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `inventory_managers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `telephone_number` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `medical_equipments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `pharma` varchar(45) NOT NULL,
  `production_date` varchar(45) NOT NULL,
  `price` int NOT NULL,
  `stock` int NOT NULL,
  `category` varchar(45) NOT NULL,
  `weight` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `supplements` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `pharma` varchar(45) NOT NULL,
  `production_date` varchar(45) NOT NULL,
  `price` int NOT NULL,
  `stock` int NOT NULL,
  `expired_date` varchar(45) NOT NULL,
  `dose` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `nutrition` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cosmetic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `pharma` varchar(45) NOT NULL,
  `production_date` date NOT NULL,
  `price` int NOT NULL,
  `stock` int NOT NULL,
  `expired_date` date NOT NULL,
  `cosmetic_type` varchar(45) NOT NULL,
  `weight` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `telephone_number` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `carts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_qty` int NOT NULL,
  `total_price` int NOT NULL,
  `desktop` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cart_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cartId` varchar(45) NOT NULL,
  `productId` varchar(45) NOT NULL,
  `qty` varchar(45) NOT NULL,
  `product_code` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
