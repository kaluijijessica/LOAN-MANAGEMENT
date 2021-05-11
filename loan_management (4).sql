-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2021 at 06:28 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loan_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_name`, `password`) VALUES
(7133, 'jessica', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `cid` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `loan_type` varchar(30) NOT NULL,
  `amount` int(15) NOT NULL,
  `bank_account` varchar(60) NOT NULL,
  `EMI` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`cid`, `name`, `loan_type`, `amount`, `bank_account`, `EMI`) VALUES
(1, 'peter', 'medium term loan', 18200, '12134', 0),
(2, 'Annick', 'long-term loan', 34000, '12122', 0),
(3, 'Henny Mada', 'long-term loan', 32000, '3452', 0),
(4, 'Jessie J', 'short term loan', 1050, '7122', 0),
(5, 'pato', 'medium term loan', 7150, '5555', 230.71038843593868),
(6, 'lili', 'short term loan', 1260, '1452', 107.86542705346899);

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `no` int(11) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `customer_name` varchar(20) NOT NULL,
  `loan_type_name` varchar(17) NOT NULL,
  `amount` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`no`, `date`, `customer_name`, `loan_type_name`, `amount`) VALUES
(1, '2021-04-08', 'peter', 'medium term loan', 18200),
(2, '2021-04-13', 'Annick', 'long-term loan', 34000),
(3, '2021-04-30', 'Henny Mada', 'long-term loan', 32000),
(4, '2021-04-30', 'Jessie J', 'short term loan', 1050),
(5, '2021-04-30', 'pato', 'medium term loan', 7150),
(6, '2021-04-30', 'lili', 'short term loan', 1260);

-- --------------------------------------------------------

--
-- Table structure for table `loan_type`
--

CREATE TABLE `loan_type` (
  `no` int(11) NOT NULL,
  `amount_interval` varchar(30) NOT NULL,
  `interest_rate` int(11) NOT NULL,
  `loan_type_name` varchar(40) NOT NULL,
  `period` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loan_type`
--

INSERT INTO `loan_type` (`no`, `amount_interval`, `interest_rate`, `loan_type_name`, `period`) VALUES
(1, '   0 - 5000 ', 5, 'short term loan', 1),
(2, '5001 - 15000 ', 10, 'medium term loan', 3),
(3, '15001 - ', 20, 'long-term loan', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`no`);

--
-- Indexes for table `loan_type`
--
ALTER TABLE `loan_type`
  ADD UNIQUE KEY `no` (`no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `loan`
--
ALTER TABLE `loan`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
