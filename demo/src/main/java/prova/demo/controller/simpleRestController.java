package prova.demo.controller;



import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prova.demo.model.DropboxFile;
import prova.demo.model.Filter_Ext_and_Date;
import prova.demo.model.GetDataFromDropbox;
import prova.demo.model.StatisticsMaxMinAvg;



@RestController
public class simpleRestController {
    
    @GetMapping("/stats/minimo")
    public int metodoMinimo(@RequestParam(name="Estensione") String Estensione){
        StatisticsMaxMinAvg Stats = new StatisticsMaxMinAvg(Estensione);
        return Stats.risultatoMinimo();
    }
    @GetMapping("/stats/massimo")
    public int metodoMassimo(@RequestParam(name="Estensione") String Estensione){
        StatisticsMaxMinAvg Stats = new StatisticsMaxMinAvg(Estensione);
        return Stats.risultatoMassimo();
    }
    @GetMapping("/stats/media")
    public double metodoMedia(@RequestParam(name="Estensione") String Estensione){
        StatisticsMaxMinAvg Stats = new StatisticsMaxMinAvg(Estensione);
        return Stats.risultatoMedia();
    }
    
    @GetMapping("/filter/extention")
    public ArrayList metodoFilterExtention(@RequestParam(name="Estensione") String Estensione){
        
        Filter_Ext_and_Date Filter = new Filter_Ext_and_Date(Estensione);
        
        return Filter.FiltraLaLista();
    }
}
