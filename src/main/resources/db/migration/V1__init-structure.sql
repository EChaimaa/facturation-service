-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 15 nov. 2021 à 11:29
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `facturation-service`
--

-- --------------------------------------------------------

--
-- Structure de la table `facture_entity`
--

CREATE TABLE `facture_entity` (
  `id` bigint(20) NOT NULL,
  `client_ref` varchar(255) DEFAULT NULL,
  `date_facture` datetime DEFAULT NULL,
  `project_ref` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `paiement_entity`
--

CREATE TABLE `paiement_entity` (
  `id` bigint(20) NOT NULL,
  `montant` double NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `facture_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `facture_entity`
--
ALTER TABLE `facture_entity`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `paiement_entity`
--
ALTER TABLE `paiement_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb34srltavix4es256ghllo1ev` (`facture_id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `paiement_entity`
--
ALTER TABLE `paiement_entity`
  ADD CONSTRAINT `FKb34srltavix4es256ghllo1ev` FOREIGN KEY (`facture_id`) REFERENCES `facture_entity` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
