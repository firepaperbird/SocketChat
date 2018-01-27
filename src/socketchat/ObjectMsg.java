/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketchat;

/**
 *
 * @author paper
 */
public class ObjectMsg {
    private String name;
    private String contend;
    private String sender;
    private String reciver;

    public ObjectMsg(String name, String contend, String sender, String reciver) {
        this.name = name;
        this.contend = contend;
        this.sender = sender;
        this.reciver = reciver;
    }

    public String getName() {
        return name;
    }

    public String getContend() {
        return contend;
    }

    public void setContend(String contend) {
        this.contend = contend;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    @Override
    public String toString() {
        return name+","+contend+","+sender+","+reciver;
    }
       
    
}
