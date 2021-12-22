package prova.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import prova.demo.exception.NoFileExc;
import prova.demo.model.*;
import prova.demo.service.*;

public class StatisticsMaxMinAvgTests { 
	 StatisticsMaxMinAvg esempio = new StatisticsMaxMinAvg();
	 @BeforeEach
		void setUp() throws Exception {		
		}
		
	 @AfterEach
		void tearDown() throws Exception {
		}
	 
	 @Test
	 @DisplayName("Test 1: Stampa del Minimo") 
	 void test1() throws NoFileExc{
		  int expected = 11059;
		  Assertions.assertEquals(expected, esempio.risultatoMinimo(".docx"));
		}
	 @Test
	 @DisplayName("Test 2: Stampa del Massimo") 
	 void test2() throws NoFileExc{
		  int expected = 11070;
		  Assertions.assertEquals(expected, esempio.risultatoMassimo(".docx"));
		}
	 @Test
	 @DisplayName("Test 3: Stampa della Media") 
	 void test3() throws NoFileExc{
		  int expected = 11062;
		  Assertions.assertEquals(expected, esempio.risultatoMedia(".docx"));
		}

}
