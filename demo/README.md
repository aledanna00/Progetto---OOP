# SprigBoot REST API Dropbox :package: :card_index_dividers:

### ITA
L'applicazione Springboot si pone come obiettivo l'analisi e il monitoraggio di file e cartelle presenti all'interno di un archivio DropBox. 
I dati relativi all'archivio li otteniamo tramite l'utilizzo di una REST API di [Dropbox](https://www.dropbox.com/developers/documentation/http/documentation).

Il progetto è un Web Service che permette ad un client di interagire con Dropbox per ottenere:  
✅ Statistiche sulle dimensioni minima, massima e media dei file ricercati per tipo (ad esempio .docx)  
✅ Statistiche sui periodi temporali  
✅ Filtri per estensione e data di creazione  

Avendo utilizzato il framework di [SpringBoot](https://spring.io/) è possibile avviare il programma da un normale ambiente di sviluppo.

L'utente, per accedere a tutte le funzionalità dell'applicazione ha a disposizione due modi:
* Usare un Client, come [Postman](https://www.postman.com/), che sfrutta il Web Service [Tomcat](http://tomcat.apache.org/), il quale è già integrato nel Framework di SpringBoot.
* Utilizzare il progetto in PHP sviluppato come contenuto aggiuntivo per permettere a chiunque non sappia usare Postman di poter accedere a tutte le funzionalità.
  Per poter utilizzare il PHP è necessario effettuare il download e l'istallazione di [XAMPP](https://www.apachefriends.org/it/index.html). Dopo aver fatto ciò si deve importare il progetto in un qualsiasi ambiente di sviluppo. 
  Aprire il precedentemente installato XAMPP che si presenterà cosi:  
  
  ![HomePageXAMPP](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/XAMPP%20control%20panel.PNG)  
  
  Arrivati a questo punto, si deve cliccare il primo bottone **START** a partire dall'alto, cioè quello che fa riferimento ad Apache.  
  Il risultato che otterremo sarà questo:  
  
  ![ApacheStart](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/ApacheStart.PNG)  
  
  Una volta completati tutti questi passaggi, siamo pronti per eseguire i progetti. Ovviamente prima di mandare in esecuzione il PHP è indispensabile attendere che Springboot ci  dica su quale porta è in ascolto (**default: 8080**).  
  Ora si è pronti per eseguire il PHP che si presenta così:  
  
  

### ENG
The SpingBoot app has the goal of analyzing and monitoring files and folders included in a Dropbox archive. The archive data are obtained through the use of a [Dropbox](https://www.dropbox.com/developers/documentation/http/documentation) REST API.

The project is a Web Service that allows the interaction between a Client and Dropbox to achieve:

✅ Maximum, minimum and average size of the files based off of their extension (for example .docx)  
✅ Time periods statistics

✅ Extension and creation date filters

Having used [SpringBoot](https://spring.io/) framework we can launch the program from a normal developer suite

The User, in order to access all the features of the app has at its disposal two options:
*  To use a Client, like [Postman](https://www.postman.com/), that exploits the Web Service [Tomcat](http://tomcat.apache.org/), which is already incorporated in the Spring Boot Framework.

## **Rotte Applicazione**
TIPO | ROTTA | DESCRIZIONE
---- | ---- | ----
GET | /stats/minimo | Restituisce la dimensione minima dei file, filtrati per tipo (esempio .docx)
GET | /stats/massimo | Restituisce la dimensione massima dei file, filtrati per tipo (esempio .docx)
GET | /stats/media | Restituisce la dimensione minima dei file, filtrati per tipo (esempio .docx)
GET | /filter/extention | Restituisce una lista composta dai file, la cui estensione equivale a quella inserita dall'utente (esempio .docx)
GET | /filter/date | Restituisce una lista composta dai file, la cui data equivale a quella inserita dall'utente (esempio 2021-12-08)
GET | /filter/ext_and_date | Restituisce una lista composta dai file, la cui estensione e data equivale a quella inserita dall'utente (esempio .docx e 2021-12-08)

## **Parametri**
In ogni rotta viene richiesto l'inserimento di uno o più parametri.  
I parametri sono di tipo **Estensione** e **Data**. E' importante ricordare che questi parametri, qualora non venissero inseriti, **NON** assumeranno alcun tipo di valore e quindi i valori restituiti saranno sicuramente pari a 0 (per le rotte /stats/...) e un JsonArray vuoto (per le rotte /filter/...).  
E' fondamentale, per il corretto funzionamento, che il formato dell'estensione e della data debbano essere rispettati:
* Per l'estensione si deve inserire un punto (**.**) seguito dall'estensione desiderata (**txt || docx || jpg**)
* Per la data si devono inserire in ordine **Anno, Mese e Giorno** separati da un **-** (**YYYY-MM-DD**)

## **Eccezioni** 
Il programma è in grando di lanciare eccezioni sia standard che personalizzate

**Personalizzate**
 - **NoExtExc** tale eccezione si verifica quando come parametro viene passata un estensione che non trova riscontro all’interno del dropbox. Ritorna il messaggio di errore:
     ```
     ATTENZIONE: IL PROGRAMMA NON HA ALCUN DATO DA ELEBORARE
     ```
 - **NoFileExc** tale eccezione viene lanciata quando l’ArrayList contenente i file presenti nel DropBox è vuoto. ritorna il messaggio di errore:
     ```
     ERRORE: NESSUN FILE PRESENTE
     ```

