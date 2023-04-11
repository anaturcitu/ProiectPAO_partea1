# ProiectPAO_partea1 - Aplicatie Biblioteca

CLASELE:

	package biblioteca:
		- Biblioteca : implementeaza BibliotecaService
		- Carte : abstracta
		- ExemplarCarte : mostenita din Carte; implementeaza Validare
		- UtilizatorBiblioteca : implementeaza Validare
		- FisaBibliotecaCarte : implementeaza Validare
		- FisaImprumutUtilizator : implementeaza Validare
		- Bibliotecar
		- BibliotecarSef : mostenita din Bibliotecar
	package exceptii:
		- OptiuneGresitaExceptie
		- IdInexistentExceptie
		- TitluInexistentExceptie
		- IdInvalidExceptie
	package utile:
		- Tuple
		- CitireCarte
		- CitireUtilizator
		- CitireBibliotecar
	package service:
		- BibliotecaService : interfata
		- Validare : interfata
	package constants:
		- Constants
	- Main

METODELE:

	in Main:
		- main : citesc optiunile si apelez functiile respective

	in Biblioteca:
   		- citireCarti()
		- afisareCarti()
		- citireUtilizatori()
		- afisareUtilizatori()
		- imprumutareCarte() : cand este imprumutata o carte, starea ei devine indisponibila si este adaugata in istoricul cartilor imprumutate ale utilizatorului citit
		- citireAdaugareCarteNoua() : este citita de la tastatura, apoi adaugata o carte noua

	in UtilizatorBiblioteca:
		- adaugareIdInCartiImprumutate() : functia care adauga cartea in istoric
		- validare() : din Validare

	in FisaBibliotecaCarte:
		- afiseazaFisa()
		- validare() : din Validare

	in ExemplareCarte:
		- validare() : din Validare

	in Tuple:
		- modificareStare() : modifica starea unei carti imprumutate din disponibil in indisponibil

	in CitireCarte:
		- citesteCartea()

	in CitireUtilizator:
		- citesteUtilizatorul()

	in Bibliotecar:
		- lucreazaInAceastaZi() : verifica daca bibliotecarul lucreaza in ziua respectiva
