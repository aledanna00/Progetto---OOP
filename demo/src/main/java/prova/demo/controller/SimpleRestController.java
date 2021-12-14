package prova.demo.controller;

import java.util.ArrayList;
import prova.demo.exception.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prova.demo.model.*;

@RestController
public class SimpleRestController {
    
    @GetMapping("/stats/minimo")
    public int metodoMinimo(@RequestParam(name="Estensione") String Estensione) throws NoFileExc{
        StatisticsMaxMinAvg Stats = new StatisticsMaxMinAvg(Estensione);
        return Stats.risultatoMinimo();
    }
    @GetMapping("/stats/massimo")
    public int metodoMassimo(@RequestParam(name="Estensione") String Estensione)throws NoFileExc{
        StatisticsMaxMinAvg Stats = new StatisticsMaxMinAvg(Estensione);
        return Stats.risultatoMassimo();
    }
    @GetMapping("/stats/media")
    public double metodoMedia(@RequestParam(name="Estensione") String Estensione)throws NoFileExc{
        StatisticsMaxMinAvg Stats = new StatisticsMaxMinAvg(Estensione);
        return Stats.risultatoMedia();
    }
    
    @GetMapping("/filter/extention")
    public ArrayList metodoFilterExtention(@RequestParam(name="Estensione") String Estensione)throws NoFileExc{
        
        Filter_Ext Filter = new Filter_Ext(Estensione);
        
        return Filter.FiltraLaLista();
    }
    
    @GetMapping("/filter/date")
    public ArrayList metodoFilterDate(@RequestParam(name="Data") String Data){
        
        Filter_Date Filter = new Filter_Date(Data);
        
        return Filter.FiltraLaLista();
    }
    
    @GetMapping("/filter/ext_and_date")
    public ArrayList metodoFilterExtDate(@RequestParam(name="Estensione") String Estensione, @RequestParam(name="Data") String Data)throws NoFileExc{
        
        Filter_Ext_and_Date Filter = new Filter_Ext_and_Date(Estensione, Data);
        
        return Filter.FiltraLaLista();
    }
}