-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2022 at 05:59 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bolnica`
--

-- --------------------------------------------------------

--
-- Table structure for table `doktor`
--

CREATE TABLE `doktor` (
  `id` int(11) NOT NULL,
  `ime_doktora` varchar(50) NOT NULL,
  `prezime_doktora` varchar(50) NOT NULL,
  `email` text NOT NULL,
  `struka` varchar(255) NOT NULL,
  `sifra` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doktor`
--

INSERT INTO `doktor` (`id`, `ime_doktora`, `prezime_doktora`, `email`, `struka`, `sifra`) VALUES
(3, 'Marko', 'Markovic', 'marko@gmail.com', 'PSIHIJATAR', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL,
  `ime_korisnika` varchar(50) NOT NULL,
  `prezime_korisnika` varchar(50) NOT NULL,
  `email` text NOT NULL,
  `sifra` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `ime_korisnika`, `prezime_korisnika`, `email`, `sifra`) VALUES
(3, 'Pera', 'Peric', 'djoka@gmail.com', 'mare'),
(5, 'Jovan', 'Jovic', 'jovan@gmail.com', 'jovica123');

-- --------------------------------------------------------

--
-- Table structure for table `pregled`
--

CREATE TABLE `pregled` (
  `id` int(11) NOT NULL,
  `id_doktora` int(11) NOT NULL,
  `id_pacijenta` int(11) NOT NULL,
  `opis_problema` text NOT NULL,
  `odobren` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pregled`
--

INSERT INTO `pregled` (`id`, `id_doktora`, `id_pacijenta`, `opis_problema`, `odobren`) VALUES
(3, 3, 5, '', 1),
(4, 3, 3, 'sadasdasd', 1),
(5, 3, 3, 'Nije mi dobro dokroe!', 0),
(6, 3, 3, 'asdsadsadsa', 0),
(7, 3, 3, 'sdasdsada', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doktor`
--
ALTER TABLE `doktor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pregled`
--
ALTER TABLE `pregled`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_doktora` (`id_doktora`),
  ADD KEY `id_pacijenta` (`id_pacijenta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doktor`
--
ALTER TABLE `doktor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `pregled`
--
ALTER TABLE `pregled`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pregled`
--
ALTER TABLE `pregled`
  ADD CONSTRAINT `pregled_ibfk_1` FOREIGN KEY (`id_doktora`) REFERENCES `doktor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pregled_ibfk_2` FOREIGN KEY (`id_pacijenta`) REFERENCES `korisnik` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
