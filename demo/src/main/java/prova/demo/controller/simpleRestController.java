package prova.demo.controller;

import java.util.ArrayList;
import prova.demo.exception.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prova.demo.model.*;

@RestController
public class simpleRestController {
	 StatisticsMaxMinAvg stats = new StatisticsMaxMinAvg();
	 Filters filter = new Filters();
	 
	@GetMapping("/stats/minimo")
    public int metodoMinimo(@RequestParam(name="Estensione") String Estensione) throws NoFileExc{
        return stats.risultatoMinimo(Estensione);
    }
    
    @GetMapping("/stats/massimo")
    public int metodoMassimo(@RequestParam(name="Estensione") String Estensione)throws NoFileExc{
        return stats.risultatoMassimo(Estensione);
    }
    
    @GetMapping("/stats/media")
    public double metodoMedia(@RequestParam(name="Estensione") String Estensione)throws NoFileExc{
        return stats.risultatoMedia(Estensione);
    }
    
    @GetMapping("/filter/extention")
    public ArrayList metodoFilterExtention(@RequestParam(name="Estensione") String Estensione)throws NoExtExc{ 
        return filter.FiltraPerEstensione(Estensione);
    }
    
    @GetMapping("/filter/date")
    public ArrayList metodoFilterDate(@RequestParam(name="Data") String Data) throws NoExtExc{
        return filter.FiltraPerData(Data);
    }
    
    @GetMapping("/filter/ext_and_date")
    public ArrayList metodoFilterExtDate(@RequestParam(name="Estensione") String Estensione, @RequestParam(name="Data") String Data)throws NoExtExc{
        return filter.FiltraPerDataEstensione(Estensione,Data);
    }
}