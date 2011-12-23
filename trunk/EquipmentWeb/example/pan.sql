-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost:8517
-- Generation Time: Dec 23, 2011 at 03:31 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `dbeqp`
--

-- --------------------------------------------------------

--
-- Table structure for table `pan`
--

CREATE TABLE IF NOT EXISTS `pan` (
  `a` int(11) NOT NULL AUTO_INCREMENT,
  `b` int(11) NOT NULL,
  `c` int(11) NOT NULL,
  `d` int(11) NOT NULL,
  PRIMARY KEY (`a`),
  UNIQUE KEY `a` (`a`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `pan`
--

INSERT INTO `pan` (`a`, `b`, `c`, `d`) VALUES
(1, 2, 3, 4),
(2, 2, 2, 2);
