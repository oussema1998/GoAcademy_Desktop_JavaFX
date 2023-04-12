/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author Ousse
 */
public class User {
    int id;
    String nom,prenom,email,mdp,role;
    LocalDate date_birth;
    boolean is_blocked;
    String image,reset_token;

    public User() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(LocalDate date_birth) {
        this.date_birth = date_birth;
    }

    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReset_token() {
        return reset_token;
    }

    public void setReset_token(String reset_token) {
        this.reset_token = reset_token;
    }

    public User(String nom, String prenom, String email, String mdp, String role, LocalDate date_birth, boolean is_blocked, String image, String reset_token) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
        this.date_birth = date_birth;
        this.is_blocked = is_blocked;
        this.image = image;
        this.reset_token = reset_token;
    }

    public User(String nom, String prenom, String email, String mdp, String role, LocalDate date_birth, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
        this.date_birth = date_birth;
        this.image = image;
    }

    public User( String nom, String prenom, String email, String mdp, String role, LocalDate date_birth) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
        this.date_birth = date_birth;
    }

    public User(int id, String nom, String prenom, String email, String mdp, String role, LocalDate date_birth, boolean is_blocked, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
        this.date_birth = date_birth;
        this.is_blocked = is_blocked;
        this.image = image;
    }

    public User(int id, String nom, String prenom, String email, String mdp, String role, LocalDate date_birth, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
        this.date_birth = date_birth;
        this.image = image;
    }
    
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", role=" + role + ", date_birth=" + date_birth + ", is_blocked=" + is_blocked + ", image=" + image + ", reset_token=" + reset_token + '}';
    }
    
    
    
    
    
}
