package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import twitter4j.*;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Label label = new Label();
        root.getChildren().add(label);
        try{
            Twitter twitter = TwitterFactory.getSingleton();
            ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
            label.setText(homeTimeline.get(0).getText());
        }
        catch (TwitterException ex){
            //
        }
        stage.setScene(new Scene(root));
        stage.setTitle("Tweetalot");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}