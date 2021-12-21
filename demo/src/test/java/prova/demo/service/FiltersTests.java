package prova.demo.service;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import prova.demo.exception.NoExtExc;
import prova.demo.model.DropboxFile;
import prova.demo.model.GetDataFromDropbox;

public class FiltersTests {
    ArrayList<DropboxFile> listaFile = new ArrayList<>();
    ArrayList<DropboxFile> listaFileFiltrata = new ArrayList<>();
    
    @BeforeEach
    void setUp() throws Exception {
        GetDataFromDropbox getData = new GetDataFromDropbox();
        getData.getData();
    }

    @AfterEach
    void tearDown() throws Exception {
    }
    /**
     * test che verifica che il vettore dei file di Dropbox venga riempito con i file dell'estensione desiderata
     * @throws NoExtExc
     */
    @Test
    @DisplayName("Test 1: Il vettore dei File di dropbox con estensione inserita non è null")
    void test1() throws NoExtExc {
        Filters f = new Filters();
        f.FiltraPerEstensione(".docx");
        Assertions.assertNotNull(listaFileFiltrata);
    }
    /**
     * test che verifica che il vettore dei file di Dropbox venga riempito con i file creati o modificati
     * @throws NoExtExc
     */
    @Test
    @DisplayName("Test 2: Il vettore dei File di dropbox con data inserita non è null")
    void test2() throws NoExtExc{
        Filters f = new Filters();
        f.FiltraPerData("2021-12-08");
        Assertions.assertNotNull(listaFileFiltrata);
    }
    
    @Test
    @DisplayName("Test 3: Il vettore dei File di dropbox con data ed estensioni inserite non è null")
    void test3() throws NoExtExc{
        Filters f = new Filters();
        f.FiltraPerDataEstensione(".docx", "2021-12-08");
        Assertions.assertNotNull(listaFileFiltrata);
    }
    
}
