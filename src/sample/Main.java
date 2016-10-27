package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;
import sample.*;

import javax.security.auth.callback.ChoiceCallback;

import static com.apple.eio.FileManager.getResource;

public class Main extends Application {

    private  double sceneHeight = 500;
    private double sceneWidth = 500;


    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane border = new BorderPane();
        Gridplane gridplane = new Gridplane();
        border.setTop(addHBox());
        border.setCenter(gridplane.addGridPane());
        Scene scene = new Scene(border, sceneWidth, sceneHeight);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setTitle("A* Class Pathfinder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    private HBox addHBox(){
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getStyleClass().add("hbox");
        Label from = new Label ("Where from?");
        ChoiceBox wherefrom = new ChoiceBox(FXCollections.observableArrayList("Katzen",
                "MGC", "Batelle", "Kogod", "SIS", "Ward", "Library",
                "Kay", "Hurst", "Anderson", "Letts", "McKinley", "Leonard", "Cassell"));
        Label to = new Label ("Where to?");
        ChoiceBox whereto = new ChoiceBox(FXCollections.observableArrayList("Katzen",
                "MGC", "Batelle", "Kogod", "SIS", "Ward", "Library",
                "Kay", "Hurst", "Anderson", "Letts", "McKinley", "Leonard", "Cassell"));
        Button runIt = new Button("LETS GOOOOO");
        runIt.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Remap remap = new Remap();
                List<Integer[]> returned = remap.test(0, 40, 10, 38); //katzen to sis
                //List<Integer[]> returned = remap.test(20, 20, 40, 38); //battle to gray
                //List<Integer[]> returned = remap.test(10, 38, 5, 5); //ward to cassell
                Gridplane gridplane = new Gridplane();
                gridplane.redraw(returned);
                
            }
        });
        to.getStyleClass().add("goclass");
        from.getStyleClass().add("goclass");
        hbox.getChildren().add(from);
        hbox.getChildren().add(wherefrom);
        hbox.getChildren().add(to);
        hbox.getChildren().add(whereto);
        hbox.getChildren().add(runIt);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }






    public static void main(String[] args) {
        launch(args);
    }

}

