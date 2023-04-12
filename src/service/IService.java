/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;

/**
 *
 * @author Ousse
 */
public interface IService<T> {
    void insert(T o);
    void update(T o);
    void delete(int id);
    T readById(int id);
    ArrayList<T> readAll();
    
    
}
