
package proj3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Proj3 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FavoriteMovieFXML.fxml"));
        Scene scene = new Scene(root);
        
        
        stage.setTitle("Favorite Movies Application");
        stage.setScene(scene);
        stage.show();
    }// end start
    
    //-----------------------Main
    
    public static void main(String[] args) {
        launch(args);
    } //end main

    
    
}
