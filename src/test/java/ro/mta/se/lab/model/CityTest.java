package ro.mta.se.lab.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.mta.se.lab.Main;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/** Verificare functionalitate clasa City
 * @author Laudan Daniel
 */
public class CityTest {

    Main main;
    City city;
    @Before
    public void setUp() throws Exception {
        main=new Main();
        main.read_file("src/main/resources/testReadFile.txt");
        city=mock(City.class);
        when(city.getId_oras()).thenReturn("524901");
        when(city.getCity_name()).thenReturn("Tarascon");
        System.out.println("Inainte de test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Dupa test");
    }

    @Test
    public void getId_oras() {
        assertEquals(city.getId_oras(),"524901");
    }

    @Test
    public void getCity_name() {
        assertEquals(city.getCity_name(),"Tarascon");
    }
}