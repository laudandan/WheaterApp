package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }

    public void read_file(String path){
       try {
           File fileOrase=new File(path);
           Scanner myReader=new Scanner(fileOrase);
       }
       catch (FileNotFoundException e){
           System.out.println("Error at opening file");
           e.printStackTrace();
       }
    }

    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();

        try {
            loader.setLocation(this.getClass().getResource("/view/WeatherView.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
