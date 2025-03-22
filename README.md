# Système de Gestion des Évaluations des Enseignants
 
## Description
Ce projet est un système de gestion des évaluations des enseignants développé en Java avec une base de données SQL. Il permet de gérer les enseignants, les étudiants et les évaluations faites par les étudiants concernant les enseignants.
## Objectifs
- Améliorer la qualité de l'enseignement en permettant aux étudiants de donner leur feedback
- Faciliter la prise de décision pour les responsables académiques grâce aux données quantitatives et qualitatives
- Centraliser les données des enseignants, étudiants et évaluations dans un système unifié
- Permettre des analyses statistiques avec des outils comme les graphiques
- Assurer la confidentialité des données et l'intégrité du processus
## Conception des diagrammes
### Digramme d'utilisation:
![image](https://github.com/user-attachments/assets/b983284c-f845-4b8d-8efc-e6b293e6b79c)

### Digramme de classe:
![image](https://github.com/user-attachments/assets/5643f547-868f-4ae4-b564-4687bc4098bb)



## Structure de la Base de Données

### Requêtes SQL pour créer les tables:
```sql
CREATE TABLE `enseignant` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `nom` VARCHAR(50) NOT NULL,
    `prenom` VARCHAR(50) NOT NULL,
    `matiere` VARCHAR(100) NOT NULL
);

CREATE TABLE `etudiant` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `nom` VARCHAR(50) NOT NULL,
    `prenom` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE `evaluation` (
    `enseignant_id` INT NOT NULL,
    `etudiant_id` INT NOT NULL,
    `note` DOUBLE NOT NULL,
    `commentaire` VARCHAR(255),
    PRIMARY KEY (enseignant_id, etudiant_id),
    FOREIGN KEY (enseignant_id) REFERENCES Enseignant(id),
    FOREIGN KEY (etudiant_id) REFERENCES Etudiant(id)
);
CREATE TABLE `user` (
    `login` VARCHAR(50) NOT NULL ,
   `password` VARCHAR(50) NOT NULL
);
```
## Structure du code Java
---
### Beans (Modèles)

- Enseignant.java : Classe représentant un enseignant
- Etudiant.java : Classe représentant un étudiant
- Evaluation.java : Classe représentant une évaluation
- User.java : Classe représentant un utilisateur

### Services

- EnseignantService.java : Gestion des opérations CRUD pour les enseignants
- EtudiantService.java : Gestion des opérations CRUD pour les étudiants
- EvaluationService.java : Gestion des opérations CRUD pour les évaluations
- UserService.java : Gestion des opérations CRUD pour les utilisateurs

### Connexion à la base de données
- Connexion.java : Classe singleton gérant la connexion à la base de données
### Interface DAO
- IDao.java : Interface définissant les opérations CRUD génériques
- IUserDao.java :  Interface définissant les opérations CRUD génériques du utilisateur
### Test 
- Test.java : Classe pour test le code.
### Architecture
L'application est basée sur une architecture client-serveur :
- Client : Une application Java développée avec NetBeans.
- Serveur : Une base de données MySQL pour stocker et récupérer les données.
- Interface Utilisateur : Développée avec SWING pour offrir une expérience utilisateur intuitive et facile à utiliser.
  
![image](https://github.com/user-attachments/assets/6924aced-fd89-4784-ace7-44190f6ffad6)

### Technologies Utilisées:

- NetBeans (Java) : Pour le développement de l’application.
- MySQL : Pour la gestion de la base de données.
- SWING : Pour l'interface graphique et rendre l’application facile à utiliser.
## Demo :
- Lien drive : https://drive.google.com/drive/folders/1-2gMBZG_OaxIlqP6I7Bcmhxr0av5d2D5
