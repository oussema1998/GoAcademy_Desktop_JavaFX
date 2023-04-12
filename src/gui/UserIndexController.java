/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author Ousse
 */
public class UserIndexController implements Initializable {

    @FXML
    private ListView<User> listUsers;
    @FXML
    private ChoiceBox<String> operations;

    /**
     * Initializes the controller class.
     */
    UserService us = new UserService();
    List<User> listu = us.readAll();
    @FXML
    private Button rfch;
    
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        
        
        //initialise operations     
        ObservableList<String> list = FXCollections.observableArrayList("Afficher", "Modifier","Supprimer");
        operations.setItems(list);
        
        //intialize List View
        List<User> listu = us.readAll();
        
        ObservableList<User> obs=
                FXCollections.observableArrayList(listu);
        listUsers.setItems(obs);
        
        // Ajout d'un gestionnaire d'événements pour le double-clic sur un élément de la liste
        listUsers.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 &&(operations.getValue()==null || operations.getValue()=="Afficher")) {
                User user = listUsers.getSelectionModel().getSelectedItem();
                if (user != null) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserAffich.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(loader.load()));
                        UserAffichController controller = loader.getController();
                        controller.setUser(user);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(UserIndexController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            if (event.getClickCount() == 2 &&( operations.getValue()=="Supprimer")) {
                User user = listUsers.getSelectionModel().getSelectedItem();
                if (user != null) {
                    us.delete(user.getId());
                    
                    List<User> newList = us.readAll();
        ObservableList<User> newObsList = FXCollections.observableArrayList(newList);
        listUsers.setItems(newObsList);
                    
                }
            }
            
            if (event.getClickCount() == 2 &&( operations.getValue()=="Modifier")) {
                User user = listUsers.getSelectionModel().getSelectedItem();
                if (user != null) {try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserModify.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(loader.load()));
                        UserModifyController controller = loader.getController();
                        controller.setUser(user);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(UserIndexController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });
    }    

    @FXML
    private void refreshList(ActionEvent event) {
         List<User> newList = us.readAll();
        ObservableList<User> newObsList = FXCollections.observableArrayList(newList);
        listUsers.setItems(newObsList);
    }
    
}
