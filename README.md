# Gestion de Stock — Java SE & MySQL

Application console de gestion de stock développée en **Java SE** avec **JDBC** et **MySQL**.

## Fonctionnalités

- Gestion des catégories : ajout, modification, suppression et affichage.
- Gestion des fournisseurs : ajout, modification, suppression et affichage.
- Gestion des produits : CRUD des produits.
- Mouvements de stock : entrées et sorties.
- Contrôle du stock disponible avant une sortie.
- Alertes de stock faible et détection des ruptures.
- Consultation de la quantité d'un produit.
- Calcul de la valeur totale du stock.

## Technologies

- Java SE 17
- JDBC
- MySQL
- MySQL Connector/J
- Eclipse IDE

## Organisation du projet

Le projet Java complet fourni est disponible dans l'archive `Gestion_stock.zip` à la racine du dépôt. Elle contient les packages DAO, DataBase, Main, Menu et Model, ainsi que le projet Eclipse original.

## Prérequis

- JDK 17
- MySQL Server
- MySQL Connector/J
- Eclipse IDE (ou un IDE Java compatible)

## Installation

1. Cloner ce dépôt.
2. Télécharger et installer MySQL Server.
3. Exécuter le script [database/gestion_stock.sql](database/gestion_stock.sql) dans MySQL ou phpMyAdmin.
4. Ajouter MySQL Connector/J au Build Path du projet.
5. Vérifier les paramètres de connexion dans `DataBaseConnection.java` :
   - URL : `jdbc:mysql://localhost:3306/gestion_stock`
   - utilisateur par défaut dans le code : `root`
   - mot de passe : chaîne vide (à adapter à votre configuration locale).
6. Importer le dossier du projet dans Eclipse et lancer `com.Gestion_Stock.Main.Main`.

> **Sécurité :** ne conservez pas les identifiants de base de données en dur dans une application destinée à la production. Configurez-les dans un fichier local non versionné ou via des variables d'environnement.

## Modèle de données

- `categorie` : catégories de produits.
- `fournisseur` : informations des fournisseurs.
- `produit` : produits, prix, quantités et seuils d'alerte.
- `mouvement_stock` : historique des entrées et sorties.

## Note

Ce dépôt présente un projet académique / portfolio. Le code a été publié à partir du projet fourni. Il n'a pas été validé ici par une exécution contre une instance MySQL réelle ; configurez la base et testez les opérations dans votre environnement.

## Auteur

Alae Lahlou — [GitHub](https://github.com/alaelahlou)
