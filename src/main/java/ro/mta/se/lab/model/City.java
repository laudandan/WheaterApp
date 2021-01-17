package ro.mta.se.lab.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Stocheaza datele oraselor din fisierul initial.
 * @author Laudan Daniel
 */
public class City {
    /**
     * @param id_oras stocheaza Id-ul unic global orasului.
     */
    String id_oras;
    /**
     * @param city_name stocheaza numele orasului.
     */
    String city_name;
    /**
     * @param country_code stocheaza codul tarii.
     */
    String country_code;


    /**
     * Setters
     */
    public void setId_oras(String id_oras) {
        this.id_oras = id_oras;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    /**
     *
     * Getters
     */
    public String getId_oras() {
        return id_oras;
    }

    public String getCity_name() {
        return city_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    /**
     * Constructor
     * @param id_oras
     * @param city_name
     * @param country_code
     */
    public City(String id_oras, String city_name, String country_code) {
        this.id_oras = id_oras;
        this.city_name = city_name;
        this.country_code = country_code;
    }
}
