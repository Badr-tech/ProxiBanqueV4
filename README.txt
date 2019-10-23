****************************

	ProxiBanque v4

****************************


*****Description g�n�rale******

ProxiBanque v4 est une application de gestion des clients offrant une API bas�e sur spring. Les diff�rents flux REST (JSON) sont destin�s � �tre consomm�s par une application client (Angular).

ProxiBanqueV4 exploite l�architecture trois tiers :

Pr�sentation des donn�es sur une application client (angular)
Logique m�tier dans une couche de service
Persistance des donn�es dans une base de donn�es SQL (MySQL). L�application utilise le standard d�ORM JPA pour la communication avec la base de donn�es.
Cette application fournit les fonctionnalit�s d�crites ci-dessous. Se r�f�rer au diagramme cas d�utilisation fourni pour une vue g�n�rale (r�pertoire ./conception/diagrammes - cf. section livrables).

******Authentification*******
Aucune requ�te (sauf pages de login) n�est autoris�e sans authentification (syst�me de filtre). L�application fournit donc un syst�me d�authentification permettant de v�rifier si le couple login/password correspond � un utilisateur pr�sent dans la base de donn�es. Si oui, l�acc�s est autoris� et un token est g�n�r� pour ne pas s'authentifier une autres fois pour acc�der aux autres fonctionnalit�es.

******Gestion clients*******
1.Cr�ation d�un client 
2.Acc�s aux informations d�un client
3.Acc�s aux informations des clients de l�agence
4.Modification d�un client existant
5.Suppression d�un client et de ses comptes

******Gestion conseillers*******
1.Cr�ation d�un conseiller
2.Acc�s aux informations d�un conseiller
3.Acc�s aux informations des conseillers de l�agence
4.Modification d�un conseiller existant
5.Suppression d�un conseiller 

*******Op�rations*********
1.Association automatique d�un compte courant (solde 20.00) � chaque cr�ation client
2.Association ult�rieure d�un compte �pargne � un client
3.Virements bancaires de compte � compte
4.Affectation d'un client � un conseiller 
5.Modifier des informations sp�c�fique comme : la commission sur virements, nombre maximum de clients par conseillers, nombre maximum de conseillers

******Livrables********
Le projet Eclipse ProxiBanqueV4, qui est constitu� de :
-Un projet Spring
-Un dossier de documentation Javadoc qui contient la documentation du projet au format HTML
Pr�sents dans le dossier ./conception/diagrammes, les exports graphiques :
d�un diagramme de classe
d�un diagramme de cas d�utilisation
d�un diagramme de d�ploiement
Des mockups d�une application mobile destin�e � consommer les flux, r�alis�s � l�aide du logiciel Balsamiq, dans le r�pertoire ./conception/maquettes
Les URLs associ�es aux diff�rents flux des WebServices, disponibles dans le pr�sent README (section Flux).

*******Installation et ex�cution********
D�pendances
Apache Tomcat
Utiliser�

File > New > Other... Server
    
�afin d�associer le serveur Apache Tomcat � Eclipse. Attention, le serveur Tomcat devra utiliser le port 8080 !

Base de donn�es MySQL (disponible et configur�e avec le logiciel XAMPP). Veillez � ce que celle-ci soit disponible sur le port 3306.
Libraries :
Se r�f�rer au fichier pom.xml situ� � la racine du projet pour visualiser les d�pendances en terme de librairies. Celles-ci sont g�r�es automatiquement par Maven. Les grandes cat�gories sont :

SPRING DATA Core
SPRING DATA JPA
SPRING WEB
SPRING SECURITY
MySQL Connecter
JAVA JWT

*****Proc�dure*******
Importer le projet sous Eclipse puis Alt-F5 sur le projet afin de t�l�charger les d�pendances Maven. En cas de difficult�s :

mvn clean install
�dans une console.

Important : un gerant doit �tre pr�sent dans la base de donn�es ProxiBanqueV4 pour que l�authentification fonctionne, ansi que la cr�ation des trois profi. Pour cela, vous alles les cr�ers manuellement dans la base de donn�e.


L�application peut �tre lanc�e par la proc�dure suivante :

Dans eclipse, clique droit sur le fichier ProxiBanqueV4Application.java > Run As... > Run on java application
Authentification : admin, admin

Pour l�explotation des services REST:
1- Soit tiliser l'application front end (Angular) qui se trouve dans le r�pertoire ./Front-End.Pour lancer cette application consulter README qui se trouve dans le r�pertoire ./Front-End.
2- Soit utiliser une extension de type Advanced Rest Client(ARC) que vous pouvez ajouter facilement dans votre navigateur.


***********Flux**********

URL de base : http://localhost:8080

******************************
	Gestion des clients
*******************************

*********Ajout client***********
URL : http://localhost:8080/clients
M�thode : POST
Flux out : JSON Client � placer dans le body de la requ�te
R�ponse : 200
Flux in : aucun

*********Afficher un client avec son id *************
URL : http://localhost:8080/clients/{idClient}
M�thode : GET
Flux out : aucun
R�ponse : 200
Flux in : JSON correspondant � l�objet client

*********Afficher la liste des clients *************
URL : http://localhost:8080/clients
M�thode : GET
Flux out : aucun
R�ponse : 200
Flux in : JSON correspondant � la liste des objets client

******Modifier un client******
URL : http://localhost:8080/clients
M�thode : PUT
Flux out : JSON du nouveau client � placer dans le body de la requete
R�ponse : 200

******Supprimer un client************
URL : http://localhost:8080/clients/{idClient}
M�thode : DELETE
Flux out : aucun
R�ponse : 200
Flux in : aucun

*********************************
	Gestion des conseillers
**********************************

*********Ajout conseiller ***********
URL : http://localhost:8080/conseillers
M�thode : POST
Flux out : JSON conseiller � placer dans le body de la requ�te
R�ponse : 200
Flux in : aucun

*********Afficher un conseiller avec son id *************
URL : http://localhost:8080/conseillers/{idconseiller}
M�thode : GET
Flux out : aucun
R�ponse : 200
Flux in : JSON correspondant � l�objet conseiller

*********Afficher la liste des conseillers *************
URL : http://localhost:8080/conseillers
M�thode : GET
Flux out : aucun
R�ponse : 200
Flux in : JSON correspondant � la liste des objets conseiller

******Modifier un conseiller******
URL : http://localhost:8080/conseillers
M�thode : PUT
Flux out : JSON du nouveau conseiller � placer dans le body de la requete
R�ponse : 200

******Supprimer un conseiller************
URL : http://localhost:8080/conseillers/{idconseiller}
M�thode : DELETE
Flux out : aucun
R�ponse : 200
Flux in : aucun

***************************************************
	Modifer les informations sp�c�fiques
**************************************************

******Modifier les valeurs des param�trages sp�c�fiques******
URL : http://localhost:8080/parametrage
Flux out : JSON du nouveau parametrage � placer dans le body de la requete
R�ponse : 200


****************************************
	Virement compte � compte
****************************************
URL : http://localhost:8080/virement
M�thode : POST
Flux out : JSON d'un objet cl� valeur (code1, code2, montant)
R�ponse : 200
Flux in : aucun





*****************************************
	
	Limitation et bugs

****************************************
/!\ Cette version est hautement exp�rimentale et que quelques fonctionnalit�es r�stent � �tre finalis�es /!\

Pas de possibilit� de faire le virement, l'affectaion d'un client � un conseiller, g�n�rer le rapport sur les transaction depuis l'application front end. 
