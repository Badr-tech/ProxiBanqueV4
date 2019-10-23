****************************

	ProxiBanque v4

****************************


*****Description générale******

ProxiBanque v4 est une application de gestion des clients offrant une API basée sur spring. Les différents flux REST (JSON) sont destinés à être consommés par une application client (Angular).

ProxiBanqueV4 exploite l’architecture trois tiers :

Présentation des données sur une application client (angular)
Logique métier dans une couche de service
Persistance des données dans une base de données SQL (MySQL). L’application utilise le standard d’ORM JPA pour la communication avec la base de données.
Cette application fournit les fonctionnalités décrites ci-dessous. Se référer au diagramme cas d’utilisation fourni pour une vue générale (répertoire ./conception/diagrammes - cf. section livrables).

******Authentification*******
Aucune requête (sauf pages de login) n’est autorisée sans authentification (système de filtre). L’application fournit donc un système d’authentification permettant de vérifier si le couple login/password correspond à un utilisateur présent dans la base de données. Si oui, l’accès est autorisé et un token est généré pour ne pas s'authentifier une autres fois pour accéder aux autres fonctionnalitées.

******Gestion clients*******
1.Création d’un client 
2.Accès aux informations d’un client
3.Accès aux informations des clients de l’agence
4.Modification d’un client existant
5.Suppression d’un client et de ses comptes

******Gestion conseillers*******
1.Création d’un conseiller
2.Accès aux informations d’un conseiller
3.Accès aux informations des conseillers de l’agence
4.Modification d’un conseiller existant
5.Suppression d’un conseiller 

*******Opérations*********
1.Association automatique d’un compte courant (solde 20.00) à chaque création client
2.Association ultérieure d’un compte épargne à un client
3.Virements bancaires de compte à compte
4.Affectation d'un client à un conseiller 
5.Modifier des informations spécéfique comme : la commission sur virements, nombre maximum de clients par conseillers, nombre maximum de conseillers

******Livrables********
Le projet Eclipse ProxiBanqueV4, qui est constitué de :
-Un projet Spring
-Un dossier de documentation Javadoc qui contient la documentation du projet au format HTML
Présents dans le dossier ./conception/diagrammes, les exports graphiques :
d’un diagramme de classe
d’un diagramme de cas d’utilisation
d’un diagramme de déploiement
Des mockups d’une application mobile destinée à consommer les flux, réalisés à l’aide du logiciel Balsamiq, dans le répertoire ./conception/maquettes
Les URLs associées aux différents flux des WebServices, disponibles dans le présent README (section Flux).

*******Installation et exécution********
Dépendances
Apache Tomcat
Utiliser…

File > New > Other... Server
    
…afin d’associer le serveur Apache Tomcat à Eclipse. Attention, le serveur Tomcat devra utiliser le port 8080 !

Base de données MySQL (disponible et configurée avec le logiciel XAMPP). Veillez à ce que celle-ci soit disponible sur le port 3306.
Libraries :
Se référer au fichier pom.xml situé à la racine du projet pour visualiser les dépendances en terme de librairies. Celles-ci sont gérées automatiquement par Maven. Les grandes catégories sont :

SPRING DATA Core
SPRING DATA JPA
SPRING WEB
SPRING SECURITY
MySQL Connecter
JAVA JWT

*****Procédure*******
Importer le projet sous Eclipse puis Alt-F5 sur le projet afin de télécharger les dépendances Maven. En cas de difficultés :

mvn clean install
…dans une console.

Important : un gerant doit être présent dans la base de données ProxiBanqueV4 pour que l’authentification fonctionne, ansi que la création des trois profi. Pour cela, vous alles les créers manuellement dans la base de donnée.


L’application peut être lancée par la procédure suivante :

Dans eclipse, clique droit sur le fichier ProxiBanqueV4Application.java > Run As... > Run on java application
Authentification : admin, admin

Pour l’explotation des services REST:
1- Soit tiliser l'application front end (Angular) qui se trouve dans le répertoire ./Front-End.Pour lancer cette application consulter README qui se trouve dans le répertoire ./Front-End.
2- Soit utiliser une extension de type Advanced Rest Client(ARC) que vous pouvez ajouter facilement dans votre navigateur.


***********Flux**********

URL de base : http://localhost:8080

******************************
	Gestion des clients
*******************************

*********Ajout client***********
URL : http://localhost:8080/clients
Méthode : POST
Flux out : JSON Client à placer dans le body de la requête
Réponse : 200
Flux in : aucun

*********Afficher un client avec son id *************
URL : http://localhost:8080/clients/{idClient}
Méthode : GET
Flux out : aucun
Réponse : 200
Flux in : JSON correspondant à l’objet client

*********Afficher la liste des clients *************
URL : http://localhost:8080/clients
Méthode : GET
Flux out : aucun
Réponse : 200
Flux in : JSON correspondant à la liste des objets client

******Modifier un client******
URL : http://localhost:8080/clients
Méthode : PUT
Flux out : JSON du nouveau client à placer dans le body de la requete
Réponse : 200

******Supprimer un client************
URL : http://localhost:8080/clients/{idClient}
Méthode : DELETE
Flux out : aucun
Réponse : 200
Flux in : aucun

*********************************
	Gestion des conseillers
**********************************

*********Ajout conseiller ***********
URL : http://localhost:8080/conseillers
Méthode : POST
Flux out : JSON conseiller à placer dans le body de la requête
Réponse : 200
Flux in : aucun

*********Afficher un conseiller avec son id *************
URL : http://localhost:8080/conseillers/{idconseiller}
Méthode : GET
Flux out : aucun
Réponse : 200
Flux in : JSON correspondant à l’objet conseiller

*********Afficher la liste des conseillers *************
URL : http://localhost:8080/conseillers
Méthode : GET
Flux out : aucun
Réponse : 200
Flux in : JSON correspondant à la liste des objets conseiller

******Modifier un conseiller******
URL : http://localhost:8080/conseillers
Méthode : PUT
Flux out : JSON du nouveau conseiller à placer dans le body de la requete
Réponse : 200

******Supprimer un conseiller************
URL : http://localhost:8080/conseillers/{idconseiller}
Méthode : DELETE
Flux out : aucun
Réponse : 200
Flux in : aucun

***************************************************
	Modifer les informations spécéfiques
**************************************************

******Modifier les valeurs des paramètrages spécéfiques******
URL : http://localhost:8080/parametrage
Flux out : JSON du nouveau parametrage à placer dans le body de la requete
Réponse : 200


****************************************
	Virement compte à compte
****************************************
URL : http://localhost:8080/virement
Méthode : POST
Flux out : JSON d'un objet clé valeur (code1, code2, montant)
Réponse : 200
Flux in : aucun





*****************************************
	
	Limitation et bugs

****************************************
/!\ Cette version est hautement expérimentale et que quelques fonctionnalitées réstent à être finalisées /!\

Pas de possibilité de faire le virement, l'affectaion d'un client à un conseiller, générer le rapport sur les transaction depuis l'application front end. 
