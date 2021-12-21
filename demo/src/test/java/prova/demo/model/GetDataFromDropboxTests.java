package prova.demo.model;

import prova.demo.model.DropboxFile;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prova.demo.model.GetDataFromDropbox;

public class GetDataFromDropboxTests {
    
    ArrayList<DropboxFile> listaFile = new ArrayList<>();
    ArrayList<DropboxFile> listaCartelle = new ArrayList<>();

    @BeforeEach
    void setUp() throws Exception {
        GetDataFromDropbox getData = new GetDataFromDropbox();
        getData.getData();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    @DisplayName("Test 1: Il vettore dei File di dropbox non è null")
    void test1() {
        Assertions.assertNotNull(listaFile);
    }
    
    @Test
    @DisplayName("Test 2: Il vettore delle Cartelle non è null")
    void test2(){
        Assertions.assertNotNull(listaCartelle);
    }
}
