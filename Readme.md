# Bienvenue dans notre Backend `Backend-modelsis-springboot-fullstack`

Le backend de notre application est une API web robuste conçue pour prendre en charge les opérations de gestion de produits et de types de produits. Il s'intègre parfaitement avec le frontend Angular pour fournir une expérience utilisateur fluide et transparente.

# Fonctionnalités clés :

    Gestion des Produits : L'API permet d'ajouter, de récupérer, de mettre à jour et de supprimer des produits. Elle assure la gestion complète du cycle de vie des produits.

    Gestion des Types de Produits : Elle prend également en charge la création de types de produits qui peuvent être associés aux produits.

    Relations OneToMany : Le backend gère efficacement la relation OneToMany entre les types de produits et les produits, permettant à un type de produit d'être associé à plusieurs produits.

    Validation des Données : L'API effectue une validation des données pour garantir que seules des données valides sont stockées dans la base de données.

Endpoints API :

    /products : Endpoint pour gérer les produits (GET, POST, PUT, DELETE).
    /productTypes : Endpoint pour gérer les types de produits (GET, POST, PUT, DELETE).

Sécurité :

Nous prenons la sécurité au sérieux. L'API met en œuvre des mécanismes d'authentification pour garantir que seuls les utilisateurs autorisés peuvent accéder et modifier les données.

Comment utiliser ce backend :

    Utilisez les endpoints API pour effectuer des opérations CRUD sur les produits et les types de produits.
    Assurez-vous de respecter les règles de validation des données pour garantir l'intégrité des données.
    Assurez-vous d'être authentifié pour accéder aux fonctionnalités de gestion.

Ce backend est conçu pour être extensible et évolutif, ce qui signifie que vous pouvez l'intégrer dans d'autres projets ou étendre ses fonctionnalités selon vos besoins.

# Stacks Utilisés
    Java 8 avec JDK 1.8
    SpringBoot 2.7.15
    