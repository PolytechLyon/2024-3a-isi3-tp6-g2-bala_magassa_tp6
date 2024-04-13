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

La getVelocity() utilise le patron de conception Iterateur, permettant de parcourir les composants d'un véhicule. L'avantage de ce patron de conception est que le client peut parcourir notre collection d'objects  sans connaitre l'implémentation de cette dernière. De plus, l'encapsulation de l'itérateur protège le client des éventuelles variations de l'implémentation de la collection.

Après avoir modifié la structure de donnée utilisée pour stocker les composants d'un véhicule de Set à List, il n'est pas nécessaire de modifier la réalisation de la méthode getVelocity() puisque le patron de 
conception itérateur protège justement le client des éventuelles variations de l'implémentation de la collection. Le client peut ainsi itérer librement sur la collection sans être perturbé par notre changement de type de List à Set. 

## Exercice 3
Afin d'implémenter le patron Singleton dans le code, nous apportons les modifications suivantes à la classe Clock : 
- L'ajout d'une instance de Clock en tant qu'attribut statique de la classe Clock. Cet attribut, que nous initialisons, constituera l'unique instance possible.
- L'ajout d'un constructeur privé dans Clock, afin d'empêcher l'utilisateur de créer de nouvelles instances via "new".
- L'ajout de la méthode getInstance(), qui renvoie l'instance de clock.
Par la suite, dans la classe Wheel, qui jusqu'ici instanciait systématiquement Clock, nous modifions l'attribut "clock" afin de faire appel à Clock.getInstance().

Nous écrivons un code de test dans la classe Application.java, qui permet de constater que grâce au pattern singleton, tous les objets Wheel se partagent une unique instance de Clock, ce qui résoud notre problème de synchronisation en uniformisant la vélocité des roues. En voici une illustration :

Avant la mise en place du pattern :

![image](https://github.com/PolytechLyon/2024-3a-isi3-tp6-g2-bala_magassa_tp6/assets/160489283/13d7085f-17d3-4be9-a987-c491d369cef2)

Après la mise en place du pattern, toutes les roues ont la même vélocité :

![image](https://github.com/PolytechLyon/2024-3a-isi3-tp6-g2-bala_magassa_tp6/assets/145548135/0fdb1b40-55e3-4c90-8c98-97ea6f334903)



## Exercice 4

Les classes Bike et Wheel n'appartiennent pas au même paquetage. En effet, la classe Bike est située dans le paquetage "cycling" tandis que la classe Wheel se trouve dans le paquetage "transport".
En observant, le diagramme de classe fourni, on constate que le type de dépendance entre ces 2 classes est circulaire. Effectivement, Bike est une sous-classe de Vehicule qui implémente l'interface MobileObject. D'autre part, la classe Wheel implémente également cette interface et possède une donnée membre privée de type Bike.
Cette dépendance cyclique ne respecte pas les bonnes pratiques de conception, car toute modification apportée à l'un des paquetages est susceptible d'avoir un impact inattendu sur l'autre. Par conséquent, il est recommandé de regrouper les classes Bike et Wheel dans le même paquetage afin d'éviter ce problème.

La fonctionnalité de la classe Bike, utilisée par la classe Wheel, est la fonction getPush(). La classe abstraite Vehicle est une abstraction existante de la classe Bike qui isole cette fonctionnalité. Cette abstraction se trouve dans le paquetage "transport", tout comme la classe Wheel. 

Afin de rompre la dépendance cyclique entre les classes Bike et Wheel, nous avons modifié le type de la donnée membre "drive" de la classe Wheel pour qu'elle soit de type Vehicle plutôt que Bike. De plus, nous avons supprimé l'import de la classe Bike dans la classe Wheel.

## Exercice 5

On constate que les méthodes log() sont constituées de trois étapes :
1. La création de la variable "entry" à partir du format
2. La fabrication du message final à partir de nom du journal, du format et des arguments du message
3. L'écriture du message, dans la console ou dans un fichier en fonction du type de Logger (ConsoleLogger ou FileLogger)

Les deux premières étapes étant communes à ConsoleLogger et FileLogger, nous les incluons dans le templateMethod (qui dans notre cas est la méthode log)
La dernière étape varie selon le type de Logger. Nous créeons donc une méthode abstraite operationLog(String message), qui est appelée par la méthode log() après 
la méthode log(), et dont l'implémentation dépend donc de la classe fille qui exécute log().

## Exercice 6

Conformément au patron de conception Méthode de Fabrique, nous créons une classe LoggerCreator, qui correspond à notre usine à Logger.

Cette classe admet donc une méthode factoryMethod, qui renvoie un "produit" de type Logger. En déclarant cette méthode comme statique, nous décidons d'adopter la variante statique du design pattern Factory. De plus, factoryMethod renvoie par défaut un objet de type FileLogger. De cette manière, le choix du type de logger est centralisé dans un seul et unique fichier : celui de la classe LoggerCreator. Les classes BikeSimulator, Bike et Vehicle peuvent créer leur logger via "LoggerCreator.factoryMethod(this.getClass().toString())". En voici un exemple : 

![image](https://github.com/PolytechLyon/2024-3a-isi3-tp6-g2-bala_magassa_tp6/assets/145548135/8e3f8c16-ff55-4adf-b80b-351662ad83b7)

Par la suite, nous modifions la visibilité des classes de loggers (ConsoleLogger, FileLogger...) afin qu'elles soient accessible uniquement au sein de leurs packages respectifs. De ce fait, nous interdisons à l'utlisateur de créer des instances de logger d'un autre type que FileLogger, et par un autre intermédiaire que notre méthode de fabrique.

La différence entre cette conception et le patron Singleton réside dans le fait que Singleton garantit une unique instance, tandis que notre méthode de fabrique, bien qu'elle soit statique, permet de créer autant d'instances que le nombre de fois où elle est appelée dans le code.

## Exercice 7
Nous utilisons le design pattern Decorateur en créant une classe LoggerDecorator, qui hérite de Logger (et ainsi de la méthode log), mais possède également un attribut de type Logger, qui correspond au composant. Ce composant est décoré par TimestampedLoggerDecorator, décorateur concret qui ajoute la date et l'heure au message. Nous modifions la classe wheel afin qu'elle utilise ce dernier. Voici le résultat obtenu dans le fichier logs.txt pour Wheel :

![image](https://github.com/PolytechLyon/2024-3a-isi3-tp6-g2-bala_magassa_tp6/assets/145548135/5ed79224-f66b-4274-8a73-c2bbeb1dea22)

En implémentant le design pattern avec le type Logger, à savoir le plus haut niveau d'abstraction, nous garantissons la possibilité de pouvoir écrire dans n'importe quel type de journaux (fichiers, console...).

## Exercice 8

En proposant une interface simplifiée de ServiceLoader avec un ensemble restreint de ses fonctionnalités, la classe Context suit le patron de conception Facade. En effet, elle constitue un point d'entrée unique et simplifié vers un système plus complexe (ServiceLoader), dans le but de suivre le principe "make simple tasks simple, complex tasks possible". Ainsi, grâce à la classe Context, on peut utiliser les fonctionnalités de ServiceLoader dont on a besoin, de facon simple et transparente.

Au lieu d'instancier un objet Bike via new, on utilise la classe Context afin d'effectuer une injection de dépendance permettant d'instancier un objet de type Bike. Après avoir modifié le fichier `META-INF/services/fr.polytech.sim.cycling.Bike` comme convenu, on constate dans notre fichiers de logs que la simulation a bien été effectuée avec une instance de TagAlongBike (les lignes intermédiaires correspondent aux logs effectués par les autres classes de l'application, telles que Wheel par exemple) :

![image](https://github.com/PolytechLyon/2024-3a-isi3-tp6-g2-bala_magassa_tp6/assets/145548135/3b29f393-4b26-4f40-9229-44a4d75f1085)

![image](https://github.com/PolytechLyon/2024-3a-isi3-tp6-g2-bala_magassa_tp6/assets/145548135/57eea4bb-4cad-4d16-9a87-22c21a56a1ea)

Il est tout à fait possible de mettre plusieurs lignes au fr.polytech.sim.cycling.Bike, qui correspondent aux différentes implémentations de Bike que l'on souhaite injecter à travers le contexte applicatif. La classe Context utilise alors la méthode iterator() du ServiceLoader pour obtenir un itérateur sur toutes les classes spécifiées dans le fichier.

## Exercice 9

Tout d'abord, le type de retour de la méthode injectAll() est un itérateur sur toutes les instances de la classe spécifiée en pramètre.

Le patron de conception proposé par cette méthode pour parcourir tous les objets d'un type donné disponibles dans le contexte applicatif est le patron de conception Service Locator. Le Service Locator est un patron de conception qui permet de centraliser la recherche et la récupération des services ou des instances d'objets. Il possède une classe qui contient des méthodes pour récupérer différentes instances de services. En l'occurence, cette classe est la classe Context qui fournit des méthodes pour récupérer des instances de classes spécifiques (inject(Class<T> klass) et injectAll(Class<T> klass)) et qui utilise un mécanisme de recherche de services pour trouver et fournir des instances des classes demandées (ServiceLoader.load(klass)).

En vue de modifier la simulation de vélo pour utiliser cette même méthode afin de simuler tous les types de vélo presénts dans la configuration, nous avons premièrement modifier la classe TagAlongBike pour qu'elle hérite de la classe Bike, tout comme SimpleBike. 
Dans un second temps, dans le fichier META-INF.services/fr.polytech.sim.cycling.bike, nous avons ajouté la classe SimpleBike afin d'indiquer qu'elle est une implémentation de la classe abstraite Bike. Cette action indique au mécanisme de service de Java que SimpleBike est une implémentation de la classe abstraite Bike. Cette configuration permet à la méthode injectAll(Class<T> klass) de la classe Context d'utiliser ServiceLoader.load(klass) pour charger toutes les implémentations de la classe abstraite Bike, c'est-à-dire les instances des classes SimpleBike et TagAlongBike.
Ensuite, après avoir complété de le code de la fonction injectAll() de la classe Context, nous avons modifié la méthode run() présente dans la classe BikeSimulator. En effet, nous avons fait usage de la fonction injectAll() afin d'itérer sur toutes les instances de la classe Bike. Cela nous a permis de simuler chaque type de vélo disponible dans la configuration.
