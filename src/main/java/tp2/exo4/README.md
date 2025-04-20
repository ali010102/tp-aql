# TP2 - Exercice 4 : Jeu de dés ("jeu du 7")

## 1. Objets à mocker

Les objets à mocker dans les tests unitaires de la méthode `jouer` sont :

- **Joueur** : pour contrôler les mises et simuler les exceptions lors du débit.
- **Banque** : pour simuler la solvabilité, les crédits et débits.
- **De** : pour contrôler le résultat du lancer et forcer certains résultats (par ex., total = 7).

Tous ces objets doivent être mockés pour isoler la logique de la méthode `jouer`.

---

## 2. Scénarios à tester (classes d'équivalence)

1. **Jeu fermé** : le joueur ne peut pas jouer → `JeuFermeException`
2. **Joueur insolvable (DebitImpossibleException)** : le joueur ne peut pas être débité → rien d'autre ne se passe.
3. **Lancer ≠ 7** : le joueur perd sa mise, la banque encaisse, rien d'autre.
4. **Lancer = 7, banque solvable** : joueur reçoit le double de sa mise, banque débite, jeu reste ouvert.
5. **Lancer = 7, banque insolvable après gain** : gain donné, mais jeu fermé après.

---

## 4. Test le plus simple : Jeu fermé

C’est un **test d’état**, car on teste la valeur de retour et l’état du jeu (`ouvert=false`) sans vérifier d’interaction.

---

## 5. Joueur insolvable

On force une exception lors du `joueur.debiter(mise)`.

Pour s'assurer que les dés ne sont pas lancés, on utilise **Mockito.verify(de1, never()).lancer()**.

C’est un **test des interactions**, car on vérifie que certains appels (lancer les dés) **n'ont pas eu lieu**.

---

## 7. Implémentation concrète de la Banque

Voir fichier `BanqueConcrete.java`. En l’utilisant dans un test, on passe d’un test unitaire à un **test d’intégration**, car on ne simule plus la banque.

