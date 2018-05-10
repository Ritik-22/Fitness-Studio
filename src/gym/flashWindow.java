/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class flashWindow extends javax.swing.JFrame {

    public flashWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        forgotpass = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel4.setText("Password :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 120, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel2.setText("User ID    :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 120, 40));

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userKeyTyped(evt);
            }
        });
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 220, 40));

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 220, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FITNESS STUDIO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 340, 50));

        forgotpass.setBackground(new java.awt.Color(255, 255, 255));
        forgotpass.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        forgotpass.setText("Forgot password");
        forgotpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotpassActionPerformed(evt);
            }
        });
        getContentPane().add(forgotpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 690, 200, -1));

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 690, 130, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FitnessStudio1.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 800));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-340, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void forgotpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotpassActionPerformed
        // TODO add your handling code here:
        ForgotPasswordForm fpf = new ForgotPasswordForm();
        fpf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_forgotpassActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        String userid =user.getText();
        String password = new String(pass.getPassword());
        String user1="";
        String pass1="";
        try
           {
 
               Class.forName("com.mysql.jdbc.Driver");
 
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_database", "root", "root");
 
               PreparedStatement st=con.prepareStatement("select * from trainer where idtrainer=? && password = ?");
               
                st.setString(1,userid);
                st.setString(2,password);
                ResultSet rs=st.executeQuery();
                if(rs.next()) {
                    JOptionPane.showMessageDialog(rootPane,"Welcome");
                    HomePage hp = new HomePage();
               
                    hp.setVisible(true);
                    this.setVisible(false);
                    
                }
       else{
          JOptionPane.showMessageDialog(rootPane,"Only Trainers are allowed to signin");
       }
       rs.close();
       st.close();
       con.close();
           }
        catch (SQLException ex)
           {
               System.out.print("exception is" + ex);
           } 
        catch (ClassNotFoundException ex)
           {
               System.out.print("exception is" + ex);
           }
      /*  if(userid.equals("1234"))
        {
            if (password.equals("abc123")) {
                
            }
        }
        //JOptionPane.showMessageDialog(rootPane,"Welcome");*/
    }//GEN-LAST:event_loginActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_userKeyTyped

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
            java.util.logging.Logger.getLogger(flashWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(flashWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(flashWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(flashWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new flashWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgotpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
