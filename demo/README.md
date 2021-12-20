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
  Per poter utilizzare il PHP è necessario effettuare il download e l'istallazione di [XAMPP](https://www.apachefriends.org/it/index.html). Dopo aver fatto ciò si deve importare   il progetto in un qualsiasi ambiente di sviluppo. 
  Aprire il precedentemente installato XAMPP che si presenterà cosi:  
  
  ![HomePageXAMPP](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/XAMPP%20control%20panel.PNG)  
  
  Arrivati a questo punto, si deve cliccare il primo bottone **START** a partire dall'alto, cioè quello che fa riferimento ad Apache.  
  Il risultato che otterremo sarà questo:  
  
  ![ApacheStart](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/ApacheStart.PNG)  
  
  Una volta completati tutti questi passaggi, siamo pronti per eseguire i progetti. Ovviamente prima di mandare in esecuzione il PHP è indispensabile attendere che Springboot ci  dica su quale porta è in ascolto (**default: 8080**).  
  Ora si è pronti per eseguire il PHP che si presenta così:  
  
  ![IndexDropboxPHP](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/IndexDropboxPHP.PNG)  
  
  Navigando attraverso i button si può accedere a tutte le funzioni. Nonostate il procedimento possa sembrare più contorto, giunti a questo punto l'utente è decisamente facilitato nella ricerca di file e statistiche che soddisfano le sue richieste.

### ENG
The SpingBoot app has the goal of analyzing and monitoring files and folders included in a Dropbox archive. The archive data are obtained through the use of a [Dropbox](https://www.dropbox.com/developers/documentation/http/documentation) REST API.

The project is a Web Service that allows the interaction between a Client and Dropbox to achieve:

✅ Maximum, minimum and average size of the files based off of their extension (for example .docx)  
✅ Time periods statistics  
✅ Extension and creation date filters

Having used [SpringBoot](https://spring.io/) framework we can launch the program from a normal developer suite

The User, in order to access all the features of the app, has at its disposal two options:
*  To use a Client, like [Postman](https://www.postman.com/), that exploits the Web Service [Tomcat](http://tomcat.apache.org/), which is already incorporated in the Spring Boot Framework.
*  Use the Php project, developed as an add-on to allow anyone who is not familiar with  Postman to access all features . In order to use it the download and the installation of XAMPP is mandatory. After doing so you need to import the project in any developer suite, and open the XAMPP that will appear like this :
   ![HomePageXAMPP](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/XAMPP%20control%20panel.PNG) 
   
  At this point you have to click on the first  **START** button  from the top, the one that refers to Apache . The obtained result will be :  
  
  
   ![ApacheStart](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/ApacheStart.PNG)
   
  Once completed all this steps , we are now ready to run  the projects.
  Obviously before running the PHP it’s essential to wait for Springboot to tell us which port is listening (**default :8080** ).
  The PHP will look like this:


    ![IndexDropboxPHP](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/IndexDropboxPHP.PNG) 
    
  Browsing through the buttons we can easily access all the features . Although the process may appear confusing , at this point the user is facilitated in the searching of files and statistics that satisfy his requests 
   

## **Rotte Applicazione**
TIPO | ROTTA | DESCRIZIONE
---- | ---- | ----
GET | /stats/minimo | Restituisce la dimensione minima dei file, filtrati per tipo (esempio .docx)
GET | /stats/massimo | Restituisce la dimensione massima dei file, filtrati per tipo (esempio .docx)
GET | /stats/media | Restituisce la dimensione minima dei file, filtrati per tipo (esempio .docx)
GET | /stats/creation | Restituisce una stringa che indica il mese in cui è stato creato il maggior numero di file 
GET | /stats/modified | Restituisce una stringa che indica il mese in cui è stato modificato il maggior numero di file 
GET | /filter/extention | Restituisce una lista composta dai file, la cui estensione equivale a quella inserita dall'utente (esempio .docx)
GET | /filter/date | Restituisce una lista composta dai file, la cui data equivale a quella inserita dall'utente (esempio 2021-12-08)
GET | /filter/ext_and_date | Restituisce una lista composta dai file, la cui estensione e data equivale a quella inserita dall'utente (esempio .docx e 2021-12-08)

## **Parametri**
In ogni rotta viene richiesto l'inserimento di uno o più parametri.  
I parametri sono di tipo **Estensione** e **Data**. E' importante ricordare che questi parametri, qualora non venissero inseriti, **NON** assumeranno alcun tipo di valore e quindi i valori restituiti saranno sicuramente pari a 0 (per le rotte /stats/...) e un JsonArray vuoto (per le rotte /filter/...).  
E' fondamentale, per il corretto funzionamento, che il formato dell'estensione e della data debbano essere rispettati:
* Per l'estensione si deve inserire un punto (**.**) seguito dall'estensione desiderata (**txt || docx || jpg**)
* Per la data si devono inserire in ordine **Anno, Mese e Giorno** separati da un **-** (**YYYY-MM-DD**)

## GET /stats/minimo   GET /stats/massimo   GET /stats/media
### Modello
```json
  number
```
Nel JSON sopra riportato, al posto di `number` comparirà il numero corrispondente al tipo di statistica scelto tra *minimo, massimo e media* corrispondente all'estensione inserita dall'utente.

### Risultato di chiamata su Postman di /stats/massimo

![StatsMassimo](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/StatsMassimo.PNG)

Per le statistiche **/stats/minimo**, **/stats/massimo** e **/stats/media** la chiamata su Postman produce risultati del modello riportato sopra, rispettando i parametri inseriti dall'utente.

## GET /stats/creation   GET /stats/modified
### Modello
```json
  Il mese in cui sono stati creati il numero maggiore di file è: month Nel quale sono stati creati number file
```
Nel JSON sopra riportato, al posto di `month` comparirà il nome del mese corrispondente a quello in cui sono state effettuate più modifiche o creazioni, mentre al posto di `number` comparirà il numero dei file che sono stati creati o modificati in quel mese.

### Risultato di chiamata su Postman di /stats/creation

![StatsCreation](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/StatsCreation.PNG)

Per le statistiche **/stats/creation** e **/stats/modified** la chiamata su Postman produce risultati del modello riportato sopra.

## GET /filter/...
### Modello
```json
{
    "tag": "file",
    "name": "Document.docx",
    "path_lower": "/document.docx",
    "path_display": "/Document.docx",
    "id": "id:WOl-BtauXDQAAAAAAAAACQ",
    "estensione": ".docx",
    "client_modified": "2021-12-06T10:06:06Z",
    "server_modified": "2021-12-06T10:06:06Z",
    "rev": "5d27767b65c6b89089b41",
    "size": 11070,
    "is_downloadable": "true",
    "content_hash": "ac950068f9e21f84db628d28208d4ba20ad5b482ac384b68343c9b34243053a2"
}
```
 Il JSON sopra riportato indica la rappresentazione utilizzata per indicare un **File di Dropbox**. 
 I campi rappresentano:
 1) **tag** = Indica il tipo di elemento (File o Cartella).
 2) **name** = Nome del file.
 3) **path_lower** = Percorso in cui si trova il file o la cartella scritto tutto in minuscolo.
 4) **path_display** = Percorso in cui si trova il file o la cartella rispettando le maiuscole.
 5) **id** = Codice univoco per identificare l'elemento.
 6) **estensione** = Indica l'estensione del file (**.docx**).
 7) **client_modified** = Indica la data dell'ultima modifica dell'utente.
 8) **server_modified** = Indica la data di crezione.
 9) **rev** = Identificatore univoco utile per rilevare modifiche recenti e conflitti.
 10) **size** = Indica la dimensione del file (**espressa in kb**).
 11) **is_downloadable** = Indica se il file è scaricabile oppure no.
 12) **conten_hash** = Codice alfanumerico utile per verificare l'integrità di un file.

### Risultato di chiamata su Postman di /filter/Extention

![FilterExtention](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/filterExtention.PNG)

Il programma restituisce i file di Dropbox sotto forma di un JSONArray.  

Per i filtri **/filter/extention**, **/filter/date** e **/filter/ext_and_date** la chiamata su Postman produce risultati del modello riportato sopra, rispettando i parametri inseriti dall'utente.
 
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
## UML

Il diagramma che esplica in maniera generale le suddivisoni del progetto è il seguente:  
![Untitled](https://github.com/aledanna00/Progetto---OOP/blob/main/DropboxPHP/ImgREADME/Untitled.png)


# Autori

Nome | LinkedIn | Contributo
---- | ---- | ----
[Alessio Cruciani](https://github.com/AlessioCruciani) | [Link](https://www.linkedin.com/in/alessio-cruciani-54b028222/) | 50%
[Alessandra D'Anna](https://github.com/aledanna00) | [Link]() | 50%
