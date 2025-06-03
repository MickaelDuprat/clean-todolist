# Guide d'installation pour Clean-todolist

Ce guide vous accompagne pour installer la todolist sur votre environnement local.

## Prérequis

Avant de commencer, assurez-vous d'avoir les logiciels suivants installés :

- **Java Development Kit (JDK) 21** : Nécessaire pour exécuter le backend Spring Boot.
- **Maven** : Utilisé pour construire et gérer le projet Spring Boot (dans le cadre du projet, il est wrapper).
- **Node.js et NPM** : Node.js est nécessaire pour exécuter le frontend Angular, et NPM (Node Package Manager) est utilisé pour installer les dépendances JavaScript.

### Installation des Prérequis

#### Java Development Kit (JDK) 21

Téléchargez le JDK 21 depuis le [site officiel d'Oracle](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) ou utilisez un OpenJDK.

#### Installation de NPM (gestionnaire de paquet)

1. **Télécharger Node.js** :
    - Rendez-vous sur le [site officiel de Node.js](https://nodejs.org/).
    - Téléchargez l'installateur pour votre système d'exploitation (Windows, macOS, ou Linux), la version utilisée sur le projet est la v20.16.0 LTS et pour NPM la v10.8.1

3. **Vérifier l'installation** :
    - Ouvrez un terminal ou une invite de commande.
    - Vérifiez que Node.js et NPM sont correctement installés en exécutant les commandes suivantes :
      ```bash
      node -v
      npm -v
      ```
      
### Installation des dépendances du projet

Une fois Node.js et NPM installés, vous pouvez installer les dépendances du projet Angular :

1. **Naviguer vers le répertoire du projet "app"** :
    - Utilisez le terminal pour naviguer jusqu'au répertoire où se trouve le projet Angular.
      ```bash
      cd clean-todolist/app
      ```

2. **Installer les dépendances** :
    - Exécutez la commande suivante pour installer les dépendances listées dans le fichier `package.json` :
      ```bash
      npm install
      ```

3. **Démarrer le projet Angular** :
    - Une fois les dépendances installées, vous pouvez démarrer le projet Angular en exécutant :
      ```bash
      ng serve
      ```
    - Par défaut, l'application sera accessible à l'adresse `http://localhost:4200`.

En suivant ces étapes, vous devriez avoir tous les outils nécessaires pour exécuter à la fois le backend Spring Boot et le frontend Angular de votre application Clean-todolist.
