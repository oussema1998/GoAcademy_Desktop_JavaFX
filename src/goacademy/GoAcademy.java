/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package goacademy;

import entity.User;
import java.time.LocalDate;
import service.UserService;

/**
 *
 * @author Ousse
 */
public class GoAcademy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1999, 7, 5);

        // TODO code application logic here
       // User u = new User("sami","fehri","sami@gmail.com","pass#23","Admin",date);
        User u1 = new User("sami","fehri","samifehri@gmail.com","qB/Gs#52","Admin",date);
        
        UserService us = new UserService();
        
        User u2 = new User(1,"balha","oussemaa","balha@gmail.com","123456","Admin",date,"image");
        //us.insert(u1);
        us.update(u2);
        //System.out.println(us.readById(1));
        
        System.out.println(us.readByMail("balha@gmail.com").getNom()+"existeee");
        
        for (User user : us.readAll()) {
    System.out.println(user.getNom() + " " + user.getPrenom());
}
        
        
    }
    
}
