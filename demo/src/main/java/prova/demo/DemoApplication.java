package prova.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import prova.demo.controller.*;
import prova.demo.service.GetDataFromDropbox;

@SpringBootApplication
public class DemoApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);   
        
    }
}
