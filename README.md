# PBOD5

Project Mata Kuliah Pemrograman Berorientasi Objek UNUD 2023

migrations:
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
