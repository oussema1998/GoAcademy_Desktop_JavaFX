/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author Ousse
 */
public class AcceuilController implements Initializable {

    @FXML
    private Label sess;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        UserService us = new UserService();
        User conus = us.readByMail(sess.getText());
        // TODO
    }    
    
     public void succesRegister(String mail){
    this.sess.setText(mail);
    }
    
}
