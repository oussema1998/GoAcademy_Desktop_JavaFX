/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entity.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author Ousse
 */
public class UserModifyController implements Initializable {
    private File selectedFile;
    
    
private User user;
    @FXML
    private ImageView image;
    @FXML
    private Label id;
    @FXML
    private Label birth;
    @FXML
    private Button chooseImg;
    @FXML
    private ChoiceBox<String> role;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtemail;
    @FXML
    private Label crole;
    @FXML
    private Button btnSave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ObservableList<String> list = FXCollections.observableArrayList("joueur", "coach","admin","agent_magasin");
        role.setItems(list);
        // TODO
    }
private String photo;    
    public void setUser(User user) {
        this.user = user;
        id.setText(Integer.toString(user.getId()));
        crole.setText(user.getRole());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        birth.setText(formatter.format(user.getDate_birth()));
        txtprenom.setText(user.getPrenom());
        txtnom.setText(user.getNom());
        txtemail.setText(user.getEmail());
    }

    @FXML
    private void chooseImage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choose an image file");
    fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
    selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
        photo = selectedFile.getName();
        Image images = new Image(selectedFile.toURI().toString());
        image.setImage(images);
        System.out.println(photo);
    }
    }

    @FXML
    private void onClickSave(ActionEvent event) throws IOException {
        if (selectedFile != null) {
            Path sourcePath = selectedFile.toPath();
            
            System.out.println(sourcePath.toString());
            Path targetPath = Paths.get("src/image/" + selectedFile.getName());
            Files.copy(sourcePath, targetPath);
    }
        if(role.getValue()==null){role.setValue(user.getRole());}
        User nn = new User(user.getId(),txtnom.getText(),txtprenom.getText(),txtemail.getText(),user.getMdp(),role.getValue(),user.getDate_birth(),"gg");
    UserService us = new UserService();
    us.update(nn);
    Stage stage = (Stage) btnSave.getScene().getWindow();
            stage.close();
    }
}
