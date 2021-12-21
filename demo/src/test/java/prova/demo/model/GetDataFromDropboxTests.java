package prova.demo.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import prova.demo.model.DropboxFile;
import prova.demo.model.GetDataFromDropbox;
import prova.demo.exception.EmptyArrayExc;

public class GetDataFromDropboxTests {
	GetDataFromDropbox caricaDati = new GetDataFromDropbox();
	 ArrayList<DropboxFile> listaFile = caricaDati.getListaFile();
	 ArrayList<DropboxFolder> listaCartelle =caricaDati.getListaCartelle();
	 ArrayList <DropboxFile> listaProva = new ArrayList<>();
	 
	@BeforeEach
	void setUp() throws Exception {	
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	/**
	 * Test per verificare che l'ArrayList listaFile non sia vuoto
	 * @throws Exception 
	 */
	@Test
	@DisplayName("Test 1: Vettore dei file di Dropbox non è vuoto")
	void test1() throws EmptyArrayExc {
		if(listaFile.isEmpty()) throw new EmptyArrayExc();
		else {
			   assertNotNull(listaFile);
		}
	}
	/**
	 * Test per verificare che l'ArrayList listaCartelle di Dropbox non sia vuota
	 */
	@Test
	@DisplayName("Test 2: Vettore delle cartelle di Dropbox non è vuoto")
	void test2() throws EmptyArrayExc{
		if(listaCartelle.isEmpty()) throw new EmptyArrayExc();
		else {
			   assertNotNull(listaCartelle);
		}
	}
	
}
