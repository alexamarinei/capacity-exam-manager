-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2020 at 10:24 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `examencapacitate`
--

-- --------------------------------------------------------

--
-- Table structure for table `corector`
--

CREATE TABLE `corector` (
  `nr_c` int(10) NOT NULL,
  `nume_c` varchar(50) NOT NULL,
  `prenume_c` varchar(50) NOT NULL,
  `disciplina` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `corector`
--

INSERT INTO `corector` (`nr_c`, `nume_c`, `prenume_c`, `disciplina`) VALUES
(3, 'Jalba', 'Diana', 'Romana'),
(4, 'Marin', 'Ion', 'Matematica'),
(5, 'Dumitriu', 'Georgiana', 'Matematica'),
(8, 'Andrei', 'Ioan', 'Romana');

-- --------------------------------------------------------

--
-- Table structure for table `elev`
--

CREATE TABLE `elev` (
  `nr_e` int(10) NOT NULL,
  `nume_e` varchar(50) NOT NULL,
  `prenume_e` varchar(50) NOT NULL,
  `init_t` varchar(5) NOT NULL,
  `nr_sc` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `elev`
--

INSERT INTO `elev` (`nr_e`, `nume_e`, `prenume_e`, `init_t`, `nr_sc`) VALUES
(1, 'Mircia', 'Alexandra', 'I', 29),
(2, 'Dorobantu', 'Laurentiu', 'F', 2),
(3, 'Radu', 'Marian', 'D', 2),
(5, 'Balan', 'Dorina', 'G', 29),
(6, 'Balanescu', 'George', 'L', 3),
(7, 'Geamanu', 'Larisa', 'I', 3),
(8, 'Dionisie', 'Gina', 'M', 31),
(9, 'Cristian', 'Laura', 'G', 31);

-- --------------------------------------------------------

--
-- Table structure for table `examen`
--

CREATE TABLE `examen` (
  `nr_e` varchar(10) NOT NULL,
  `nume_e` varchar(100) NOT NULL,
  `init_t` varchar(5) NOT NULL,
  `prenume_e` varchar(100) NOT NULL,
  `nota_romana` float NOT NULL,
  `nota_matematica` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `examen`
--

INSERT INTO `examen` (`nr_e`, `nume_e`, `init_t`, `prenume_e`, `nota_romana`, `nota_matematica`) VALUES
('5', 'Balan', 'G', 'Dorina', 5, 6.25);

-- --------------------------------------------------------

--
-- Table structure for table `lucrare`
--

CREATE TABLE `lucrare` (
  `nr_l` int(10) NOT NULL,
  `disciplina` varchar(50) NOT NULL,
  `data` text NOT NULL,
  `nota` float NOT NULL,
  `nr_e` int(10) NOT NULL,
  `nr_c` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lucrare`
--

INSERT INTO `lucrare` (`nr_l`, `disciplina`, `data`, `nota`, `nr_e`, `nr_c`) VALUES
(2556, 'Romana', '22.03.2020', 5, 3, 4),
(2557, 'Matematica', '24.03.2020', 7, 3, 3),
(2558, 'Romana', '22.03.2020', 5, 1, 4),
(2559, 'Matematica', '24.03.2020', 5, 1, 3),
(2560, 'Romana', '22.04.2020', 8, 2, 8),
(2561, 'Romana', '22.04.2020', 5, 5, 8),
(2563, 'Romana', '22.04.2020', 9.55, 7, 3),
(2564, 'Romana', '22.04.2020', 7.43, 8, 8),
(2565, 'Romana', '22.04.2020', 9.33, 9, 8),
(2566, 'Matematica', '24.04.2020', 9.33, 2, 4),
(2567, 'Matematica', '24.04.2020', 6.25, 5, 4),
(2568, 'Matematica', '24.04.2020', 8.5, 6, 4),
(2569, 'Matematica', '24.04.2020', 10, 7, 5),
(2570, 'Matematica', '24.04.2020', 8, 8, 5),
(2571, 'Matematica', '24.04.2020', 7.23, 9, 5);

-- --------------------------------------------------------

--
-- Table structure for table `scoala`
--

CREATE TABLE `scoala` (
  `nr_sc` int(10) NOT NULL,
  `nume_sc` varchar(100) NOT NULL,
  `judet` text NOT NULL,
  `oras` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `scoala`
--

INSERT INTO `scoala` (`nr_sc`, `nume_sc`, `judet`, `oras`) VALUES
(2, 'Elena Doamna', 'Galati', 'Galati'),
(3, 'Sfantul Andrei', 'Braila', 'Braila'),
(29, 'Sfanta Ana', 'Galati', 'Galati'),
(31, 'Grigore Antipa', 'Galati', 'Tecuci');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `corector`
--
ALTER TABLE `corector`
  ADD PRIMARY KEY (`nr_c`);

--
-- Indexes for table `elev`
--
ALTER TABLE `elev`
  ADD PRIMARY KEY (`nr_e`),
  ADD KEY `FOREIGN` (`nr_sc`);

--
-- Indexes for table `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`nr_e`);

--
-- Indexes for table `lucrare`
--
ALTER TABLE `lucrare`
  ADD PRIMARY KEY (`nr_l`),
  ADD KEY `FOREIGNKEY` (`nr_e`),
  ADD KEY `FOREIGNK` (`nr_c`);

--
-- Indexes for table `scoala`
--
ALTER TABLE `scoala`
  ADD PRIMARY KEY (`nr_sc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `corector`
--
ALTER TABLE `corector`
  MODIFY `nr_c` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `elev`
--
ALTER TABLE `elev`
  MODIFY `nr_e` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `lucrare`
--
ALTER TABLE `lucrare`
  MODIFY `nr_l` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2572;

--
-- AUTO_INCREMENT for table `scoala`
--
ALTER TABLE `scoala`
  MODIFY `nr_sc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `elev`
--
ALTER TABLE `elev`
  ADD CONSTRAINT `FOREIGN` FOREIGN KEY (`nr_sc`) REFERENCES `scoala` (`nr_sc`);

--
-- Constraints for table `lucrare`
--
ALTER TABLE `lucrare`
  ADD CONSTRAINT `FOREIGNK` FOREIGN KEY (`nr_c`) REFERENCES `corector` (`nr_c`),
  ADD CONSTRAINT `FOREIGNKEY` FOREIGN KEY (`nr_e`) REFERENCES `elev` (`nr_e`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
