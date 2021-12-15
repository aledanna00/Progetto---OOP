package prova.demo.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prova.demo.model.Filters;
import prova.demo.model.StatisticsCreationDate;
import prova.demo.model.StatisticsMaxMinAvg;

@RestController
public class simpleRestController {    
    Filters filter = new Filters();
    StatisticsMaxMinAvg stats = new StatisticsMaxMinAvg();
    @GetMapping("/stats/minimo")
    public int metodoMinimo(@RequestParam(name="Estensione") String estensione){
        return stats.risultatoMinimo(estensione);
    }
    @GetMapping("/stats/massimo")
    public int metodoMassimo(@RequestParam(name="Estensione") String estensione){
        return stats.risultatoMassimo(estensione);
    }
    @GetMapping("/stats/media")
    public double metodoMedia(@RequestParam(name="Estensione") String estensione){
        return stats.risultatoMedia(estensione);
    }
    @GetMapping("/filter/extention")
    public ArrayList metodoFilterExtention(@RequestParam(name="Estensione") String estensione){
        return filter.FiltraPerEstensione(estensione);
    }
    @GetMapping("/filter/date")
    public ArrayList metodoFilterDate(@RequestParam(name="Data") String data){
        return filter.FiltraPerData(data);
    }
    @GetMapping("/filter/ext_and_date")
    public ArrayList metodoFilterExtDate(@RequestParam(name="Estensione") String estensione, @RequestParam(name="Data") String data){
        return filter.FiltraPerDataEstensione(estensione, data);
    }  
    @GetMapping("/stats/creation")
    public String metodoStatsCreazione(){
        StatisticsCreationDate statsCreazione = new StatisticsCreationDate();
        return statsCreazione.StatisticaDataCreazione();
    }
}