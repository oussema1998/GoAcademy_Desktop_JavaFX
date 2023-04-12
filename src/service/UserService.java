/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DataSource;

/**
 *
 * @author Ousse
 */
public class UserService implements IService<User> {
    
    private Connection conn;

    public UserService() {
        conn = DataSource.getInstance().getCnx();
    }
    
    

     @Override
    public void insert(User o) {
        String requete="insert into user (nom,prenom,email,mdp,role,date_birth) values"
                + " (?,?,?,?,?,?)";
        
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(requete);
            pst.setString(1,o.getNom());
            pst.setString(2,o.getPrenom());
            pst.setString(3, o.getEmail());
            pst.setString(4, o.getMdp());
            pst.setString(5, o.getRole());
                pst.setDate(6, java.sql.Date.valueOf(o.getDate_birth()));
           // pst.setString(7, o.getImage());
            
            pst.executeUpdate();
            System.out.print("personne ajouté");
        
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    

    @Override
    public void delete(int id) {
         String requete="DELETE FROM user WHERE id ="+id;
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(requete);
            System.out.println("personne supprimé avec succées ");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }}

    

    @Override
   public ArrayList<User> readAll() {
String requete = "SELECT * FROM user";
ArrayList<User> list = new ArrayList<>();
try {
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(requete);
while (rs.next()) {
User u = new User(
rs.getInt("id"),
rs.getString("nom"),
rs.getString("prenom"),
rs.getString("email"),
rs.getString("mdp"),
rs.getString("role"),
rs.getDate("date_birth").toLocalDate(),
rs.getBoolean("is_blocked"),
rs.getString("image")
);
list.add(u);
}
} catch (SQLException ex) {
Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
}
return list;
}

    @Override
    public void update(User o) {
         String requete = "UPDATE user SET nom=?, prenom=?, email=?, mdp=?, role=?, date_birth=?,  image=? WHERE id=?";
    try {
        PreparedStatement pst = conn.prepareStatement(requete);
        pst = conn.prepareStatement(requete);
            pst.setString(1,o.getNom());
            pst.setString(2,o.getPrenom());
            pst.setString(3, o.getEmail());
            pst.setString(4, o.getMdp());
            pst.setString(5, o.getRole());
            pst.setDate(6, java.sql.Date.valueOf(o.getDate_birth()));
         //   if(o.isIs_blocked()){pst.setInt(7,1);}else{pst.setInt(7,0);}
            pst.setString(7, o.getImage());
            pst.setInt(8,o.getId());
        pst.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }}

    @Override
    public User readById(int id) {
       
            String requete = "SELECT * FROM user WHERE id=?";
            User u = null;
                try {
        PreparedStatement pst = conn.prepareStatement(requete);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
        u = new User(
        rs.getInt("id"),
        rs.getString("nom"),
        rs.getString("prenom"),
        rs.getString("email"),
        rs.getString("mdp"),
        rs.getString("role"),
        rs.getDate("date_birth").toLocalDate(),
        rs.getBoolean("is_blocked"),
        rs.getString("image")
        );
        }
        } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
        }
    
    public User readByMail(String email) {
       
            String requete = "SELECT * FROM user WHERE email=?";
            User u = null;
                try {
        PreparedStatement pst = conn.prepareStatement(requete);
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
        u = new User(
        rs.getInt("id"),
        rs.getString("nom"),
        rs.getString("prenom"),
        rs.getString("email"),
        rs.getString("mdp"),
        rs.getString("role"),
        rs.getDate("date_birth").toLocalDate(),
        rs.getBoolean("is_blocked"),
        rs.getString("image")
        );
        }
        } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
        }
    
}
