/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Usuario;

/**
 *
 * @author Aluno
 */
public class DataSingleton {
    private Usuario user;
    private static DataSingleton instance;
    
    private DataSingleton() {
        
    }
    
    public static DataSingleton getInstance() {
        if (instance==null) instance = new DataSingleton();
        return instance;
    }
    
    public int getUser() {
        return user.getSenha();
    }
    
    public void setUser(Usuario u) {
        this.user = u;
    }
}
