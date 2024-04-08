# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme : 
- BALA Na'ilah
- MAGASSA Fatoumata

## Exercice 1
Le patron de conception utilisé dans l'exemple est Composite, qui permet d'implémenter une structure arborescente d’objets. 

Dans ce contexte : 
- MobileObject correspond au composant.
-  Vehicle correspond au composite. En effet, un Vehicle est de type MobileObject, et comprend une liste de composants, qui sont également de ce type.
On observe donc bien la hiérarchie ensemble/élément entre le composite et ses composants.
Par la suite, le vélo parental TagAlongBike représente notre composite, qui admet un nouveau composant (en plus des roues) : le vélo d'enfant, de type SimpleBike. On crée donc la classe TagAlongBike, qui hérite de SimpleBike.
En observant la conception donnée, on constate que SimpleBike hérite indirectement de Vehicle. C'est donc également le cas de TagAlongBike, ce qui signifie que notre nouvelle classe
hérite des méthodes de Vehicle, notamment getMass() et getVelocity(). Il n'est pas nécessaire de les réécrire, car le code de ces deux méthodes calcule la masse et la vélocité par itération sur les composants. Dans notre cas, elles vont donc inclure la masse et la vélocité du vélo enfant au calcul, sans que l'on ait besoin de les réécrire. Cela constitue un avantage du pattern Composite.

## Exercice 2

## Exercice 3

## Exercice 4

## Exercice 5

## Exercice 6

## Exercice 7

## Exercice 8

## Exercice 9


