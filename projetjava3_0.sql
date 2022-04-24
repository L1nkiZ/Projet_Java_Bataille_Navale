-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : jeu. 21 avr. 2022 à 15:17
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projetjava2_0`
--

-- --------------------------------------------------------

--
-- Structure de la table `bateaudispo`
--

CREATE TABLE `bateaudispo` (
  `idBateau` int(11) NOT NULL,
  `typeBateau` varchar(20) NOT NULL,
  `nombreDeCase` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bateaudispo`
--

INSERT INTO `bateaudispo` (`idBateau`, `typeBateau`, `nombreDeCase`) VALUES
(1, 'porteAvion', 5),
(2, 'croiseur', 4),
(3, 'contreTorpilleur', 3),
(4, 'sousMarin', 3),
(5, 'torpilleur', 2);

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE `joueur` (
  `idJoueur` int(11) NOT NULL,
  `nomJoueur` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `placementbateau`
--

CREATE TABLE `placementbateau` (
  `idBateau` int(11) NOT NULL,
  `XJoueurA` int(11) NOT NULL,
  `YJoueurA` varchar(1) NOT NULL,
  `XJoueurB` int(11) NOT NULL,
  `YJoueurB` varchar(1) NOT NULL,
  `horizontal` tinyint(1) NOT NULL,
  `bateauCoule` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tourdejeu`
--

CREATE TABLE `tourdejeu` (
  `idTable` int(11) NOT NULL,
  `joueurQuiAJoue` int(11) NOT NULL,
  `coordonneeX` int(11) NOT NULL,
  `coordonneeY` varchar(1) NOT NULL,
  `touche` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bateaudispo`
--
ALTER TABLE `bateaudispo`
  ADD PRIMARY KEY (`idBateau`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`idJoueur`);

--
-- Index pour la table `placementbateau`
--
ALTER TABLE `placementbateau`
  ADD PRIMARY KEY (`idBateau`);

--
-- Index pour la table `tourdejeu`
--
ALTER TABLE `tourdejeu`
  ADD PRIMARY KEY (`idTable`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bateaudispo`
--
ALTER TABLE `bateaudispo`
  MODIFY `idBateau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `joueur`
--
ALTER TABLE `joueur`
  MODIFY `idJoueur` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `placementbateau`
--
ALTER TABLE `placementbateau`
  MODIFY `idBateau` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tourdejeu`
--
ALTER TABLE `tourdejeu`
  MODIFY `idTable` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
