### **README - Guide pour le Projet RESTful API avec Spring Boot**

---

#### **Table des Matières**
1. [Introduction](#introduction)
2. [Prérequis](#prérequis)
3. [Installation](#installation)
4. [Structure du Projet](#structure-du-projet)
5. [Fonctionnalités CRUD](#fonctionnalités-crud)
6. [Endpoints de l'API](#endpoints-de-lapi)
7. [Technologies Utilisées](#technologies-utilisées)
8. [Améliorations Futures](#améliorations-futures)
9. [Contributeurs](#contributeurs)

---

### **Introduction**
Ce projet est une API RESTful construite avec **Spring Boot**. L'objectif est de fournir un backend capable de gérer les utilisateurs (CRUD) en utilisant une base de données H2 en mémoire.

---

### **Prérequis**
Avant de commencer, assurez-vous d'avoir les outils suivants installés :
- **Java 17+**
- **Maven 3.8+**
- Un IDE (IntelliJ IDEA, Eclipse, etc.)
- Postman ou cURL pour tester l'API

---

### **Installation**

1. Clonez ce dépôt :
   ```bash
   git clone https://github.com/YNS-JNS/SpringBoot-Demo.git
   cd SpringBoot-Demo
   ```

2. Compilez et lancez le projet :
   ```bash
   mvn spring-boot:run
   ```

3. Accédez à la console H2 (optionnelle pour visualiser les données) :
    - URL : `http://localhost:8080/h2-console`
    - **JDBC URL** : `jdbc:h2:mem:testdb`
    - **Username** : `sa`
    - **Password** : (vide)

---

### **Structure du Projet**

```plaintext
src/main/java/ma/gov/mega
├── controller       # Contient les contrôleurs REST
│   └── UserController.java
├── entity           # Contient les entités JPA
│   └── UserEntity.java
├── repository       # Contient les repositories JPA
│   └── UserRepository.java
├── service          # Contient la logique métier
│   ├── UserService.java
│   └── UserServiceImp.java
└── Application.java # Point d'entrée de l'application
```

---

### **Fonctionnalités CRUD**

Cette API permet de :
1. Créer un utilisateur.
2. Lire un ou plusieurs utilisateurs.
3. Mettre à jour un utilisateur.
4. Supprimer un utilisateur.

---

### **Endpoints de l'API**

Voici les endpoints disponibles :

| Méthode | Endpoint        | Description                              | Corps (Exemple)                                         |
|---------|-----------------|------------------------------------------|-------------------------------------------------------|
| POST    | `/api/v1/users` | Crée un utilisateur                      | `{ "firstName": "John", "lastName": "Doe", "email": "john.doe@example.com", "password": "12345678" }` |
| GET     | `/api/v1/users` | Récupère tous les utilisateurs           | N/A                                                   |
| GET     | `/api/v1/users/{id}` | Récupère un utilisateur par ID         | N/A                                                   |
| PUT     | `/api/v1/users/{id}` | Met à jour un utilisateur par ID       | `{ "firstName": "Jane", "lastName": "Doe", "email": "jane.doe@example.com", "password": "87654321" }` |
| DELETE  | `/api/v1/users/{id}` | Supprime un utilisateur par ID         | N/A                                                   |

---

### **Technologies Utilisées**

1. **Spring Boot** : Framework principal pour créer l'API REST.
2. **Spring Data JPA** : Pour interagir avec la base de données.
3. **H2 Database** : Base de données en mémoire pour le développement et les tests.
4. **Lombok** : Réduction du code boilerplate.
5. **Jakarta Validation** : Validation des données d'entrée (email, mot de passe).

---

### **Améliorations Futures**

- Ajouter **Spring Security** pour sécuriser l'API avec JWT.
- Implémenter la pagination et le tri pour les listes d'utilisateurs.
- Ajouter une gestion centralisée des erreurs avec un `@ControllerAdvice`.
- Support pour d'autres bases de données (PostgreSQL, MySQL).
- Ajouter des tests unitaires et d'intégration avec **JUnit**.

---

### **Contributeurs**

- **Nom** : AIT M'BAREK Youness
- **GitHub** : [Votre Profil GitHub](https://github.com/yns-jns)

---

Vous pouvez maintenant tester votre API avec les outils comme Postman, ou intégrer cette API dans un projet frontend ! 🎉
