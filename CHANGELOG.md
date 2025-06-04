# Changelog

Toutes les modifications du projet sont documentées dans ce fichier.

Je me suis basé sur le format de [Keep a Changelog](https://keepachangelog.com/fr/1.0.0/) qui respecte [Semantic Versioning](https://semver.org/lang/fr/spec/v2.0.0.html).

## [0.1.0] - 2025-06-03

### Ajouté
- Initialisation de l'application backend de l'API Java
- Initialisation de l'application frontend Angular
- Initialisation des fichiers INSTALL.md, CHANGELOG.md et LICENSE.md
- Ajout d'un fichier ".gitattributes"

### Modifié
- Modification du fichier README.md

## [0.2.0] - 2025-06-04

### Ajouté
- Ajout de tests unitaires
- Ajout d'une classe permettant la sauvegarde en mémoire des tâches

### Modifié
- Réorganisation des packages
- Remplacement des annotations @Getter et @Setter en @Data, @AllArgsConstructor et @NoArgsConstructor. C'est plus succinct et complet pour la manipulation de l'objet ensuite.