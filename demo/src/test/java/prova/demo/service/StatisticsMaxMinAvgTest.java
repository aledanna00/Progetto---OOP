package prova.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import prova.demo.exception.NoFileExc;
import prova.demo.model.*;
import prova.demo.service.*;

public class StatisticsMaxMinAvgTest {
	
	GetDataFromDropbox caricaDati = new GetDataFromDropbox();
	 ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();
	 ArrayList<DropboxFolder> listaCartelle =caricaDati.getListaCartelle();
	 ArrayList <DropboxFile> listaProva = new ArrayList<>();
	 StatisticsMaxMinAvg esempio = new StatisticsMaxMinAvg();
	 @BeforeEach
		void setUp() throws Exception {		
		}
		
	 @AfterEach
		void tearDown() throws Exception {
		}
	 
	 @Test
	 @DisplayName("Test 1: Stampa del Massimo") 
	 void test1() throws NoFileExc{
			if(listaFile.isEmpty()) throw new NoFileExc();
			else {
				System.out.println(esempio.risultatoMassimo(".docx"));  
				  assertNotNull(listaFile);
			}
		}

}
