# Template de projet pour le TP JPA 2019 UniR

# Objectif
L'objectif de ce TP est de nous emmener dabord à modeliser à un problème à l'aide de diagrammes de classe 
et ensuite de le representer sous forme d'objets relationnels avec JPA en java et enfin de créer une petite application web qui utilise.

## Modelisation
A l'aide des diagrammes d'UML plus précisement des diagrammes de classe nous avons pu faire une modelisation du problème qui 
consistait à developper une application type doodle.

## JPA
Ensuite nous avons utilisés JPA qui nous permet de representer nos différentes classes des classes java qui avec des
annotations nous permet de spécifier si nous voulons que ces classes se transforment en table dans notre base de donnée et quelles sont les rellations qui existes en ces differentes tables. Ainsi avec des annotations tel que # @OneToMany, @ManyToOne, @OneToOne ou @ManyToMany
nous pouvons avoir une base de donnée relationnels sans avoir à créer toutes les tables manuellement.

## Servlet

### Le port de mysql pour notre TP est 3308 et le nom de la base de donneée est testesir1
 Nous avons implementer le servlet sous forme de controlleur pour le tp
### les 2 fichiers JPG contiennent une modelisation de notre base de donnée 

# Architecture du projet 
Nous avons :
      - un package dans lequel se trouve toutes nos entités
      - un package DAO où se trouve nos service pour accéder aux éléments de notre base de donnée
      - un package service dans lequel se trouve une servlet du nom de Uservlet qui se comporte comme un contrôleur. cette classe peut être optimiser en plusieur sous classe.
      - Une classe qui nous permet de gerer les routes avec JaRX 

# Problèmes rencontrés

Nous avons rencontrer plein de problèmes lors de ce TP mais la volonté de reussir le TP nous a emmener à faire des recherches pour resoudre des problèmes comme les relations qui ne sont pas charger automatiquement, accès refusé lors de la requête POST, GET ou autres, les boucles infinis de chargement d'netités lors de la recuperation d'enetité sous forme de JSON

Au delà de tous ces difficultés nous avons appris beaucoup de choses qui pourrons nous aider dans notre future carrière. Nous avons même fait la decouverte de Spring( framework) qui est beaucoup plus faciles à implementer, et facilite le developpemnt des api et evite les problèmes sus mentionnés. 

Comme il est dit "le cerveau se nourit d'obstacle". 
