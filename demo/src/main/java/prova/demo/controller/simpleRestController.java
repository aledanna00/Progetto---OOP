package prova.demo.controller;



import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.jar.Attributes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prova.demo.service.DropboxFile;
import prova.demo.model.Filter_Date;
import prova.demo.model.Filter_Ext;
import prova.demo.model.Filter_Ext_and_Date;
import prova.demo.service.GetDataFromDropbox;
import prova.demo.model.StatisticsCreationDate;
import prova.demo.model.StatisticsMaxMinAvg;



@RestController
public class simpleRestController {    
    
    
    
    @GetMapping("/stats/minimo")
    public int metodoMinimo(@RequestParam(name="Estensione") String estensione){
        StatisticsMaxMinAvg stats = new StatisticsMaxMinAvg(estensione);
        return stats.risultatoMinimo();
    }
    @GetMapping("/stats/massimo")
    public int metodoMassimo(@RequestParam(name="Estensione") String estensione){
        StatisticsMaxMinAvg stats = new StatisticsMaxMinAvg(estensione);
        return stats.risultatoMassimo();
    }
    @GetMapping("/stats/media")
    public double metodoMedia(@RequestParam(name="Estensione") String estensione){
        StatisticsMaxMinAvg stats = new StatisticsMaxMinAvg(estensione);
        return stats.risultatoMedia();
    }
    
    @GetMapping("/filter/extention")
    public ArrayList metodoFilterExtention(@RequestParam(name="Estensione") String estensione){
        Filter_Ext filter = new Filter_Ext(estensione);
        return filter.FiltraLaLista();
    }
    
    @GetMapping("/filter/date")
    public ArrayList metodoFilterDate(@RequestParam(name="Data") String data){
        Filter_Date filter = new Filter_Date(data);
        return filter.FiltraLaLista();
    }
    
    @GetMapping("/filter/ext_and_date")
    public ArrayList metodoFilterExtDate(@RequestParam(name="Estensione") String estensione, @RequestParam(name="Data") String data){
        Filter_Ext_and_Date filter = new Filter_Ext_and_Date(estensione, data);
        return filter.FiltraLaLista();
    }  
    
    @GetMapping("/stats/creation")
    public String metodoStatsCreazione(){
        StatisticsCreationDate statsCreazione = new StatisticsCreationDate();
        return statsCreazione.StatisticaDataCreazione();
    }
}