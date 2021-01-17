package ro.mta.se.lab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clasa MainTest verifica functionalitatea optima a metodei read_file din Main.
 * @author Laudan Daniel
 */

public class MainTest {

    Main main;
    @Before
    public void setUp() throws Exception {
        System.out.println("Inainte de test\n");
        main=new Main();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Dupa test");
    }

    @Test
    public void read_file() {
        main.read_file("src/main/resources/testReadFile.txt");
        assertNotNull(main.getMyList());
        assertEquals(main.getMyList().get(0).getId_oras(),"819827");
    }
}