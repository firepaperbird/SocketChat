/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.net.Socket;

/**
 *
 * @author paper
 */
public class theUser {
    private String name;
    private Socket userSocket;

    public theUser(String name, Socket userSocket) {
        this.name = name;
        this.userSocket = userSocket;
    }

    public String getName() {
        return name;
    }

    public Socket getUserSocket() {
        return userSocket;
    }

    @Override
    public String toString() {
        return  name;
    }
    
}
