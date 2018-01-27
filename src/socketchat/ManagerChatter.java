/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketchat;

import data.theUser;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ngocnt
 */
public class ManagerChatter extends javax.swing.JFrame implements Runnable{
    ArrayList<theUser> userList = new ArrayList<>();
    ServerSocket srvSocket = null;
    BufferedReader br = null;
    Thread t, lthread; //Thread for exploring connections from staffs
    DataOutputStream os = null;
    String strList;
    ChatPanel p;
            
    public ManagerChatter() {
        initComponents();
        lthread = new Thread(new Runnable() {
            @Override
            public void run() {
                int tmp;
                String[] ll;
//                System.out.println("00");//
                while(true){                    
                    try {
//                        System.out.println("11");//
                        if(br!=null){
//                            System.out.println("22");//
                            tmp = p.getID();
                            if(tmp>=0){
//                                Socket p1 = userList.get(tmp).getUserSocket();
//                                os.writeBytes("/@sk:"+p1.getInetAddress()+"@p@"+p1.getPort());
//                                os.write(13); os.write(10);
//                                os.flush();
                                
                            }
                        }
                        Thread.sleep(200);
                    } catch (Exception e) {
                        System.out.println(e);
                        System.exit(0);
                    }
                }
            }
        });  
        lthread.start();
//        jButton1ActionPerformed(null);
    }

    public void createConnectP2P(int id){
        try {
            if (userList.get(id)!= null) {
                Socket p1 = userList.get(id).getUserSocket();
                BufferedReader bf = new BufferedReader(new InputStreamReader(p1.getInputStream()));
                String ss = bf.readLine();
                DataOutputStream oss = new DataOutputStream(p1.getOutputStream());
                oss.writeBytes("p1: "+ userList.get(id).getName());
                oss.write(13); oss.write(10);
                oss.flush();                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Manager is not running!");
            System.exit(0);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lblMamagerPort = new javax.swing.JLabel();
        txtServerPort = new javax.swing.JTextField();
        txtIP = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lbList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaList = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblMamagerPort.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMamagerPort.setText("Manager Port: ");

        txtServerPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtServerPort.setText("1111");
        txtServerPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerPortActionPerformed(evt);
            }
        });

        txtIP.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMamagerPort, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMamagerPort)
                    .addComponent(txtIP)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbList.setText("conected user");
        jPanel2.add(lbList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, -1, -1));

        txaList.setColumns(15);
        txaList.setRows(5);
        txaList.setToolTipText("");
        txaList.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txaList.setEnabled(false);
        txaList.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        jScrollPane1.setViewportView(txaList);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 30, 140, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtServerPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServerPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServerPortActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int serverPort = Integer.parseInt(txtServerPort.getText().trim());
        try {
            srvSocket = new ServerSocket(serverPort);
            InetAddress myIP = InetAddress.getLocalHost();
            txtIP.setText(""+myIP.getHostAddress());
            this.lblMamagerPort.setText("Mng. Server is running at the port");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Server IP or port are aready used");
        }
        t = new Thread(this);
        t.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerChatter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbList;
    private javax.swing.JLabel lblMamagerPort;
    private javax.swing.JTextArea txaList;
    private javax.swing.JLabel txtIP;
    private javax.swing.JTextField txtServerPort;
    // End of variables declaration//GEN-END:variables

    public void updateUser(String user,Socket userSocket){
        userList.add(new theUser(user, userSocket));
        String lis = "";
        for (theUser x : userList) {
            lis+=x.toString().toUpperCase()+"\n";
        }
        txaList.setText(lis);
    }
    
    @Override
    public void run() {
        int i;
        while(true){
            try {
                Socket aStaffSocket = srvSocket.accept();
                if (aStaffSocket != null) { //if there is a connection
                 
                 //get staffname
                 //When a staff inits a connetion, he/she sends his/her name first
                 br = new BufferedReader(new InputStreamReader(aStaffSocket.getInputStream()));
                 String s = br.readLine();
                 int pos = s.indexOf(":"); //Fortmat: Staff:Hoa
                 String staffName = s.substring(pos + 1);
                 //Create a tab for this connection
                 p = new ChatPanel (aStaffSocket, "Manager", staffName);
                 jTabbedPane1.add(staffName, p);
                 p.getTxtMessages().append(staffName + " connected\n");
                 p.updateUI();
                 updateUser(userList.size()+"-"+staffName,aStaffSocket);
                 
                //send user list/////////////////////
                    for (theUser a : userList) {
                        os = new DataOutputStream(a.getUserSocket().getOutputStream());
                        strList="";
                        for(theUser x : userList){
                            strList+=x.toString()+"@@";
                        }
                        os.writeBytes("/@lis"+strList);
                        os.write(13); os.write(10);
                        os.flush();
                    }
                    
                ////////////////////////////////////
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "2" + e);
                System.exit(0);
            }
        }
    }
}