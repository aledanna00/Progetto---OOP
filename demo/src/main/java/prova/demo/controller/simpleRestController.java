package prova.demo.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import prova.demo.exception.NoExtExc;
import prova.demo.exception.NoFileExc;
import prova.demo.model.*;

/**
 * Classe Controller che gestisce le chiamate al server
 * 
 * @author Alessio Cruciani
 * @author Alessandra D'Anna
 * @version 1.0
 */
@RestController
public class simpleRestController {    
    /**
     * Creazione di un Oggetto di tipo Filters
     * @see Filters
     */
    Filters filter = new Filters();
    /**
     * Creazione di un Oggetto di tipo StatisticsMaxMinAvg
     * @see StatisticsMaxMinAvg
     */
    StatisticsMaxMinAvg stats = new StatisticsMaxMinAvg();
    /**
     * Creazione di un Oggetto di tipo StatisticsCreationDate
     * @see StatisticsTimePeriod
     */
    StatisticsTimePeriod statsCreazione = new StatisticsTimePeriod();
    
    /**
     * Rotta che permette di visualizzare la dimensione minima di file filtrati 
     * per estensione
     * 
     * @param estensione Indica l'estensione del file contenuto nel dropbox
     * @return Indica la dimensione Minima dei file, cercati per tipo di file
     * @throws NoFileExc 
     */
    @GetMapping("/stats/minimo")
    public int metodoMinimo(@RequestParam(name="Estensione") String estensione) throws NoFileExc{
        return stats.risultatoMinimo(estensione);
    }
    
    /**
     * Rotta che permette di visualizzare la dimensione massima di file filtrati 
     * per estensione
     * 
     * @param estensione Indica l'estensione del file contenuto nel dropbox
     * @return Indica la dimensione Massima dei file, cercati per tipo di file
     * @throws NoFileExc 
     */
    @GetMapping("/stats/massimo")
    public int metodoMassimo(@RequestParam(name="Estensione") String estensione) throws NoFileExc{
        return stats.risultatoMassimo(estensione);
    }
    
    /**
     * Rotta che permette di visualizzare la dimensione media di file filtrati 
     * per estensione
     * 
     * @param estensione Indica l'estensione del file contenuto nel dropbox
     * @return Indica la dimensione Media dei file, cercati per tipo di file
     * @throws NoFileExc 
     */
    @GetMapping("/stats/media")
    public double metodoMedia(@RequestParam(name="Estensione") String estensione) throws NoFileExc{
        return stats.risultatoMedia(estensione);
    }
    
    /**
     * Rotta che permette di visualizzare tutti i file all'interno del dropbox,
     * la cui estensione corrisponde a quella inserita nel filtro
     * 
     * @param estensione Indica l'estensione inserita dall'utente nella ricerca
     * @return Lista di Oggetti di DropboxFile filtrati per estensione
     * @throws NoExtExc 
     */
    @GetMapping("/filter/extention")
    public ArrayList metodoFilterExtention(@RequestParam(name="Estensione") String estensione) throws NoExtExc{
        return filter.FiltraPerEstensione(estensione);
    }
    
    /**
     * Rotta che permette di visualizzare tutti i file all'interno del dropbox,
     * la cui data corrisponde a quella inserita nel filtro
     * 
     * @param data Indica la data inserita dall'utente nella ricerca
     * @return Lista di Oggetti di DropboxFile filtrati per data di creazione
     * @throws NoExtExc 
     */
    @GetMapping("/filter/date")
    public ArrayList metodoFilterDate(@RequestParam(name="Data") String data) throws NoExtExc{
        return filter.FiltraPerData(data);
    }

    /**
     * Rotta che permette di visualizzare tutti i file all'interno del dropbox,
     * la cui data ed estensione corrisponde a quella inserita nel filtro
     *
     * @param estensione Indica l'estensione inserita dall'utente nella ricerca
     * @param data Indica la data inserita dall'utente nella ricerca
     * @return Lista di Oggetti di DropboxFile filtrati per data di creazione ed estensione
     * @throws NoExtExc 
     */
    @GetMapping("/filter/ext_and_date")
    public ArrayList metodoFilterExtDate(@RequestParam(name="Estensione") String estensione, @RequestParam(name="Data") String data) throws NoExtExc{
        return filter.FiltraPerDataEstensione(estensione, data);
    }  
    
    /**
     * Rotta che permette di visualizzare informazioni sul mese in cui sono 
     * stati creati il maggior numero di file
     * 
     * @return Una stringa contenente tutte le specifiche del Mese in cui è
     * stato inserito il maggior numero di file
     * @throws NoFileExc 
     */
    @GetMapping("/stats/creation")
    public String metodoStatsCreazione() throws NoFileExc{
        return statsCreazione.StatisticaDataCreazione();
    }
    
    /**
     * Rotta che permette di visualizzare informazioni sul mese in cui sono 
     * stati modificati il maggior numero di file
     * 
     * @return Una stringa contenente tutte le specifiche del Mese in cui è
     * stato modificato il maggior numero di file
     * @throws NoFileExc 
     */
    @GetMapping("/stats/modified")
    public String metodoStatsModifica() throws NoFileExc{
        return statsCreazione.StatisticaDataModifica();
    }
}
