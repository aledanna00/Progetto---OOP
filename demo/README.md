# SprigBoot REST API Dropbox :package: :card_index_dividers:

### ITA
L'applicazione Springboot si pone come obiettivo l'analisi e il monitoraggio di file e cartelle presenti all'interno di un archivio DropBox. 
I dati relativi all'archivio li otteniamo tramite l'utilizzo di una REST API di [Dropbox](https://www.dropbox.com/developers/documentation/http/documentation).

Il progetto è un Web Service che permette ad un client di interagire con Dropbox per ottenere:  
:bangbang: Statistiche sulle dimensioni minima, massima e media dei file ricercati per tipo (ad esempio .docx)  
:bangbang: Statistiche sui periodi temporali  
:bangbang: Filtri per estensione e data di creazione  

Avendo utilizzato il framework di [SpringBoot](https://spring.io/) è possibile avviare il programma da un normale ambiente di sviluppo.

L'utente, per accedere a tutte le funzionalità dell'applicazione ha a disposizione due modi:
* Utilizzando un Client, come [Postman](https://www.postman.com/), che sfrutta il Web Service [Tomcat](http://tomcat.apache.org/), il quale è già integrato nel Framework di SpringBoot.
* 

### ENG