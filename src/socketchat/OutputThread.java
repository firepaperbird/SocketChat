/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketchat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author paper
 */
public class OutputThread extends Thread{
    Socket socket;
    JTextArea txt;
    BufferedReader bf;
    String sender, receiver;
    ObjectInputStream ob;
//    ObjectMsg msg;

    public OutputThread(Socket s, JTextArea txt, String sender, String receiver) {
        super();
        this.socket = s;
        this.txt = txt;
        this.sender = sender;
        this.receiver = receiver;
        try {
            bf= new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            msg = (ObjectMsg) ob.readObject();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Network error!");
            System.exit(0);
        }
    }
    
    public void run(){
        while (true) {            
            try {
                if (socket!=null) {
                    String msg = "";
                    msg = bf.readLine();
                    if(msg!=null && msg.length()>0)
//                        if(!msg.contains("/@lis"))
                            txt.append("\n"+ receiver + ": "+ msg);
                }
                sleep(1000);
            } catch (Exception e) {
            }
        }
    }
    
}
