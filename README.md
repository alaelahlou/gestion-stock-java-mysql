# Gestion de Stock — Java SE & MySQL

Application console de gestion de stock développée en **Java SE 17**, avec **JDBC** et **MySQL**.

## Fonctionnalités

- Gestion des catégories : ajout, modification, suppression et affichage.
- Gestion des fournisseurs : ajout, modification, suppression et affichage.
- Gestion des produits : ajout, modification, suppression et affichage.
- Mouvements de stock : entrées et sorties.
- Vérification du stock disponible avant une sortie.
- Alertes de stock faible et détection des ruptures.
- Consultation de la quantité d'un produit.
- Calcul de la valeur totale du stock.

## Technologies

- Java SE 17
- JDBC
- MySQL
- MySQL Connector/J 9.4.0
- Maven

## Structure

```text
src/
└── com/Gestion_Stock/
    ├── DAO/        # Accès aux données et requêtes SQL
    ├── DataBase/   # Connexion MySQL
    ├── Main/       # Point d'entrée
    ├── Menu/       # Menus console
    └── Model/      # Classes métier
database/
└── gestion_stock.sql
pom.xml
```

## Prérequis

- JDK 17
- Maven
- MySQL Server

## Installation et lancement

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/alaelahlou/gestion-stock-java-mysql.git
   cd gestion-stock-java-mysql
   ```
2. Créez la base et les tables en exécutant [database/gestion_stock.sql](database/gestion_stock.sql) dans MySQL ou phpMyAdmin.
3. Vérifiez les paramètres de connexion dans `src/com/Gestion_Stock/DataBase/DataBaseConnection.java` et dans les classes DAO qui ouvrent directement une connexion :
   - URL : `jdbc:mysql://localhost:3306/gestion_stock`
   - utilisateur utilisé par défaut : `root`
   - mot de passe utilisé par défaut : chaîne vide.
   
   Adaptez ces paramètres à votre installation MySQL avant de lancer l'application.
4. Compilez et lancez l'application :
   ```bash
   mvn clean compile
   mvn exec:java
   ```

## Modèle de données

- `categorie` : catégories de produits.
- `fournisseur` : informations des fournisseurs.
- `produit` : produits, prix, quantités, seuils d'alerte et références.
- `mouvement_stock` : historique des entrées et sorties de stock.

## Points techniques

La gestion des entrées et sorties de stock utilise une transaction JDBC. Le produit est verrouillé avec `SELECT ... FOR UPDATE`, la quantité est contrôlée, le stock est modifié et le mouvement est enregistré avant le commit. En cas d'erreur, la transaction est annulée avec rollback.

## Remarque

Ce projet est un projet de portfolio / apprentissage. La publication du code ne signifie pas qu'il a été testé sur votre instance MySQL. Configurez votre base de données et testez les scénarios d'ajout, de modification, de suppression et de mouvement de stock dans votre environnement.

## Auteur

**Alae Lahlou** — [GitHub](https://github.com/alaelahlou)
