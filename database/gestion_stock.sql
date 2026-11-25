CREATE DATABASE IF NOT EXISTS gestion_stock
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE gestion_stock;

CREATE TABLE IF NOT EXISTS categorie (
    id_categorie INT AUTO_INCREMENT PRIMARY KEY,
    nom_categorie VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS fournisseur (
    id_fournisseur INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    telephone VARCHAR(20),
    email VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS produit (
    id_produit INT AUTO_INCREMENT PRIMARY KEY,
    nom_produit VARCHAR(100) NOT NULL,
    prix DECIMAL(10,2) NOT NULL,
    quantite INT NOT NULL,
    seuil_alerte INT NOT NULL,
    id_categorie INT,
    id_fournisseur INT,
    CONSTRAINT fk_produit_categorie
        FOREIGN KEY (id_categorie) REFERENCES categorie(id_categorie),
    CONSTRAINT fk_produit_fournisseur
        FOREIGN KEY (id_fournisseur) REFERENCES fournisseur(id_fournisseur)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS mouvement_stock (
    id_mouvement INT AUTO_INCREMENT PRIMARY KEY,
    type_mouvement VARCHAR(20) NOT NULL,
    quantite INT NOT NULL,
    date_mouvement DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_produit INT NOT NULL,
    CONSTRAINT fk_mouvement_produit
        FOREIGN KEY (id_produit) REFERENCES produit(id_produit)
) ENGINE=InnoDB;
