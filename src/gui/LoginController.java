/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author Ousse
 */
public class LoginController implements Initializable {

    @FXML
    private Button registerBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private TextField email;
    @FXML
    private TextField pwd;
    @FXML
    private Label error;
    @FXML
    private Label lblsucc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Connect(ActionEvent event) throws IOException {
        UserService us= new UserService();
       User gg = us.readByMail(email.getText());
       
       if(gg==null){
       error.setText("User n'existe pas");
       return;
       }else if (gg.getMdp().equals(pwd.getText())){error.setText("mdp correct");
       error.setTextFill(Color.GREEN);
       //_____ passation session vers Acceuil
       
       FXMLLoader loader= new FXMLLoader(getClass().getResource("Acceuil.fxml"));
        Parent root=loader.load();
        
        AcceuilController cc = loader.getController();
        cc.succesRegister(email.getText());
        

    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
       
       //_____
       }else{
       error.setText("mdp incorrect!");
       }
       
      
    }

    @FXML
    private void goRegister(ActionEvent event) throws IOException {
        
        //roles initial
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Register.fxml"));
        
        //datepicker: dateb initial
        
        
        
        
        Parent root=loader.load();

Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }
    
    public void succesRegister(String mail){
    this.email.setText(mail);
    this.lblsucc.setTextFill(Color.GREEN);
    this.lblsucc.setText("compte crée avec succées !");
    }
    
}
