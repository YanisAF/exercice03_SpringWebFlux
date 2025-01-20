# exercice03_SpringWebFlux

#### **Objectif :**
Créer un contrôleur avec deux endpoints pour gérer les erreurs:
1. Utiliser `onErrorResume` pour fournir des valeurs de remplacement.
2. Utiliser `onErrorContinue` pour ignorer les erreurs et continuer le traitement.

#### **Énoncé :**
1. Créez un contrôleur nommé `ErrorHandlingController`.
2. Implémentez deux endpoints:
    - **GET `/api/error-resume` :** Retourne un `Flux<String>`:
        - Simule une erreur après `"C"`.
        - Fournit des valeurs par défaut `"Default1"` et `"Default2"`.
    - **GET `/api/error-continue` :** Retourne un `Flux<Integer>`:
        - Génère un flux de nombres de 1 à 5.
        - Simule une erreur pour le nombre `2`.
        - Ignore l’erreur et continue avec les autres valeurs.
