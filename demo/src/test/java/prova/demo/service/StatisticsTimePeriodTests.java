package prova.demo.service;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTimePeriodTests {
    
    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }
    
    @Test
    @DisplayName("Controlla che l'output sia giusto")
    void test1(){
        StatisticsTimePeriod sp = new StatisticsTimePeriod();
        String expected = "Il mese in cui sono stati creati il numero maggiore di file è: DECEMBER Nel quale sono stati creati 4 file";
        Assertions.assertEquals(expected, sp.StatisticaDataCreazione());
    }
    
    @Test
    @DisplayName("Controlla che l'output sia giusto")
    void test2(){
        StatisticsTimePeriod sp = new StatisticsTimePeriod();
        String expected = "Il mese in cui sono stati creati il numero maggiore di file è: DECEMBER Nel quale sono stati creati 4 file";
        Assertions.assertEquals(expected, sp.StatisticaDataModifica());
    }
}
