-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2022 at 07:57 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `buah`
--

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `no_pesanan` int(11) NOT NULL,
  `nama_buah` varchar(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `diskon` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`no_pesanan`, `nama_buah`, `harga`, `jumlah`, `diskon`, `subtotal`) VALUES
(1, 'mangga', 15000, 2, 3000, 27000),
(3, '1 kg mangga', 20000, 2, 4000, 36000),
(4, '1 kg mangga', 20000, 2, 4000, 36000),
(6, 'pir', 40000, 4, 32000, 128000),
(7, 'melon', 25000, 4, 15000, 85000),
(9, 'pir', 40000, 5, 40000, 160000),
(11, 'jeruk', 24000, 4, 14400, 81600),
(12, 'apel', 28000, 5, 28000, 112000),
(13, 'melon', 25000, 4, 15000, 85000),
(15, 'apel', 28000, 3, 12600, 71400),
(16, 'mangga', 20000, 6, 24000, 96000),
(18, 'mangga', 20000, 4, 12000, 68000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
