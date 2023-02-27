
package proj3;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.Scanner;
import java.io.PrintWriter;
import static java.lang.Character.toLowerCase;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;


public class FavoriteMovieFXMLController implements Initializable {

    @FXML
    private TextField movieTextbox;
    @FXML
    private ListView<String> moviesList;
    
    ObservableList<String> addMovie;
    
    public FavoriteMovieFXMLController() {
        addMovie = FXCollections.observableArrayList(movie);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    
   
    String movie;
    @FXML
    private void onClickAdd(ActionEvent event) {
        String movie = movieTextbox.getText();
        addMovie.add(movie);
        movieTextbox.clear();
        String toLowerCase = movie.toLowerCase();
        moviesList.setItems((ObservableList<String>) addMovie);
        
        
  
    }

    @FXML
    private void onClickRemove(ActionEvent event) {
      try{ 
        moviesList.getItems().removeAll(movie);
        moviesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        moviesList.getSelectionModel().clearSelection();
        movieTextbox.clear();
      }
      catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No movie selected to be removed.");
      }
    }

    @FXML
    private void onClickLoad(ActionEvent event) {
        String movieString = "movies.txt";
        Scanner movieScanner;
        moviesList = new ListView<>();
        try {
        movieScanner = new Scanner(new File("movies.txt"));
        
        while(movieScanner.hasNext()){
            movieString = movieScanner.nextLine();
            System.out.println(movieString);
            //System.out.println(addMovie);
        }
        
        movieScanner.close();
    }
        catch(FileNotFoundException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Error Opening File.");
        }
    } // end of onLoad Button
    

    @FXML
    private void onClickSave(ActionEvent event) {
         PrintWriter pw; 
            
            try{
                pw = new PrintWriter("movies.txt");
                
                pw.println(addMovie);
                
                pw.close();
            }
            catch(FileNotFoundException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Cannot Find File.");
            }
            System.out.println("Done!");
        } //end onSave bbutton
    
    
} // end controller
