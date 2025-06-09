# Changelog

Toutes les modifications du projet sont documentées dans ce fichier.

Je me suis basé sur le format de [Keep a Changelog](https://keepachangelog.com/fr/1.0.0/) qui respecte [Semantic Versioning](https://semver.org/lang/fr/spec/v2.0.0.html).

## [0.3.0] - 2025-06-10

### Ajouté
- Nouvelle structure des projets
- CRUD de l'API fonctionnel
- Ajout de la collection Bruno (client API) dans le repository
- Gestion de l'erreur White label de Spring Boot

### Modifié
- Le projet Angular est désormais wrapper dans un module Maven avec une installation automatique des dépendances (Node et NPM)
- Modifications des tests unitaires

## [0.2.0] - 2025-06-04

### Ajouté
- Ajout de tests unitaires
- Ajout d'une classe permettant la sauvegarde en mémoire des tâches

### Modifié
- Réorganisation des packages
- Remplacement des annotations @Getter et @Setter en @Data, @AllArgsConstructor et @NoArgsConstructor. C'est plus succinct et complet pour la manipulation de l'objet ensuite.

## [0.1.0] - 2025-06-03

### Ajouté
- Initialisation de l'application backend de l'API Java
- Initialisation de l'application frontend Angular
- Initialisation des fichiers INSTALL.md, CHANGELOG.md et LICENSE.md
- Ajout d'un fichier ".gitattributes"

### Modifié
- Modification du fichier README.md
