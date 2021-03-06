package ro.mta.se.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.WeatherController;
import ro.mta.se.lab.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Clasa Main are functionalitatea de a porni programul si de a citi
 * din fisier orasele cu Id-ul acestora.
 * @author Laudan Daniel
 */
public class Main extends Application {

    private ObservableList<City> myList= FXCollections.observableArrayList();


    public static void main(String[] args)
    {
        launch(args);
    }

    public ObservableList<City> getMyList() {
        return myList;
    }

    /**
     * read_file citeste tot fisierul de initializare si adauga in lista de orase toate orasele.
     * @param path calea definita catre fisierul de configurare al oraselor.
     */
    public void read_file(String path){
       try {
           File fileOrase=new File(path);
           Scanner reader=new Scanner(fileOrase);
           String date=reader.nextLine();
           while(reader.hasNextLine()){
               String data=reader.nextLine();
               String []newdata;
               newdata=data.split(" ");
               City city=new City(newdata[0],newdata[1],newdata[2]);

               myList.add(city);
           }
       }
       catch (FileNotFoundException e){
           System.out.println("Error at opening file");
           e.printStackTrace();
       }
    }

    /**
     *
     * @param primaryStage definieste un container top level ce contine toate obiectele necesare interfetei
     *                     grafice
     */
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();

        try {
            read_file("src/main/resources/orase.txt");
            loader.setLocation(this.getClass().getResource("/view/WeatherView.fxml"));
            loader.setController(new WeatherController(myList));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
