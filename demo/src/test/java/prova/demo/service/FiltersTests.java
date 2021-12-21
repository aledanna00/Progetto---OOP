/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.demo.service;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    
    @Test
    @DisplayName("Test 1: Il vettore dei File di dropbox con estensione inserita non è null")
    void test1() {
        Filters f = new Filters();
        f.FiltraPerEstensione(".docx");
        Assertions.assertNotNull(listaFileFiltrata);
    }
    
    @Test
    @DisplayName("Test 2: Il vettore dei File di dropbox con data inserita non è null")
    void test2(){
        Filters f = new Filters();
        f.FiltraPerData("2021-12-08");
        Assertions.assertNotNull(listaFileFiltrata);
    }
    
    @Test
    @DisplayName("Test 3: Il vettore dei File di dropbox con data ed estensioni inserite non è null")
    void test3(){
        Filters f = new Filters();
        f.FiltraPerDataEstensione(".docx", "2021-12-08");
        Assertions.assertNotNull(listaFileFiltrata);
    }
    
}
