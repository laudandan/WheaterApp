package ro.mta.se.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import ro.mta.se.lab.model.City;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ResourceBundle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Contime metodele necesare conectarii cu fisierul fxml si conectarea cu API-ul OpenWeatherMap
 * @author Laudan Daniel
 */
public class WeatherController implements Initializable {

    private ObservableList<City> cityList;
    private ObservableList<String> country= FXCollections.observableArrayList();
    private ObservableList<String> id_country= FXCollections.observableArrayList();

    private String currentId=null;
    String testMock;

    public final void setCurrentId(String currentId) {
        this.currentId = currentId;
    }


    /**
     *
     * @param cityList contine lista de orase initializata in Main.
     */
    public WeatherController(ObservableList<City> cityList) {
        super();
        this.cityList = cityList;
    }


    @FXML
    public ComboBox<String> cityC;
    @FXML
    public TextArea textArea;

    /**
     * functia changeLocation are rolul de a schimba variabila currentId in functie de ce este selectat in ComboBox.
     */
    @FXML
    public void changeLocation(){
        for(City i:cityList)
            if((i.getCity_name()+", "+i.getCountry_code()).equals(cityC.getValue()))
                currentId=i.getId_oras();
    }


    /**
     * showWeather apeleaza functia de obtinere a vremii daca este selectat ceva in ComboBox.
     */
    @FXML
    public void showWeather(){
        if(currentId!=null)
            getWeather();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(City i:cityList)
        {
            id_country.add(i.getId_oras());
            country.add(i.getCity_name()+", "+i.getCountry_code());
        }
        cityC.setItems(country);
    }

    public String getTestMock() {
        return testMock;
    }

    /**
     * getWeather foloseste API-ul OpenWeatherMap pentru a obtine un Buffer formatat JSON.
     * Obiectele sunt preluate din JSON si afisate in TextArea.
     */
    public void getWeather(){
        try {
            JSONParser jsonParser = new JSONParser();
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id=" + currentId + "&appid=eab58bc6540509fc568a68f9007dfe31");
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JSONObject jsonObject = (JSONObject) jsonParser.parse(bufferedReader);

            JSONArray jsonArray = (JSONArray) jsonObject.get("weather");
            JSONObject weather = (JSONObject) jsonArray.get(0);

            JSONObject wind = (JSONObject) jsonObject.get("wind");
            JSONObject main=(JSONObject) jsonObject.get("main");
            JSONObject sys=(JSONObject) jsonObject.get("sys");

            String vreme = (String) weather.get("main");
            String description=(String)weather.get("description");
            String oras = (String) jsonObject.get("name");
            Object speed=wind.get("speed");
            Object humidity=main.get("humidity");
            Object pressure=main.get("pressure");
            Object co=sys.get("country");
            testMock=co.toString();
            if (oras != null) {
                textArea.setText(oras+", "+co.toString()+"\n"+vreme+", "+description+"\n"+"Humidity: "+humidity.toString()+"%\n"+"Wind: "+speed.toString()+" km/h\n" +
                        "Pressure: "+pressure.toString()+" mmHg\n");
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
