/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.Main;

import UI.SystemAdmin.SystemAdminJPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Data;
import model.Enterprise.Enterprise;
import model.Organisation.Organisation;
import model.Person;

import model.Roles.CollegeManagerRole;
import model.Roles.FoodServiceAdminRole;
import model.Roles.RestaurantManagerRole;
import model.Roles.Role;
import model.Roles.SystemAdminRole;
import model.city.City;


//import model.Restaurant;
import model.Roles.Role;

import model.Roles.ClothesServiceAdminRole;
import UI.ClothesService.*;
import UI.College.CollegeManagerPanel;
import UI.Distribution.DistributionManagePanel;
import UI.FoodService.FoodServiceAdminPanel;
import UI.HousingService.HousingServiceAdminPanel;
import UI.NGO.NGOManagerPanel;
import UI.users.UserPanel;
import javax.swing.JPanel;
import model.Roles.DistributionManagerRole;
import model.Roles.HousingServiceAdminRole;
import model.Roles.NGOManagerRole;
import model.Roles.UserRole;

/**
 *
 * @author anupamaditya
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    Data d;
    
    public MainFrame() {
        initComponents();
        d = new Data();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public Person userVerification(String username,String password) throws SQLException,ClassNotFoundException{
        Person p = new Person();
      //try{
          Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewProject", "root", "Pass1234");
         String sql = "select * from Users where User_Name=? and Password=?";
         PreparedStatement pst = conn.prepareStatement(sql);
         pst.setString(1, username);
         pst.setString(2, password);
         ResultSet rs = pst.executeQuery();  //it will return username and password from database and will store in resultset that comes under sql package
         if (rs.next()){
             p.setUserID(rs.getInt(1));
             p.setfName(rs.getString(2));
             p.setEmailAddress(rs.getString(3));
             p.setUserName(rs.getString(4));
             p.setAddress(rs.getString(7));
             p.setPhoneNo(rs.getString(8));
             p.setAge(rs.getInt(9));
             String a = rs.getString(6);
             p.setStatus(rs.getString(10));
             if(a.equals("COLLEGE_MANAGER")){
                 Role r = new CollegeManagerRole();
                 CollegeManagerPanel collegeManagerPanel = (CollegeManagerPanel) r.createWorkArea(mainFrameworkAreaPanel, d, p);
                 mainFrameSplitPanel.setRightComponent(collegeManagerPanel);
                 
                 
             }
             else if(a.equals("RESTAURANT_ADMIN")){
                 //p.setRole(Role.RESTAURANT_ADMIN);
                   //RestAdminPanel restAddAdmin = new RestAdminPanel(p);
                 //mainFrameSplitPanel.setRightComponent(restAddAdmin);;
             }
             else if(a.equals("RESTAURANT_MANAGER")){

                 Role r = new RestaurantManagerRole();
                 //RestManagerPanel restManager = (RestManagerPanel) r.createWorkArea(mainFrameworkAreaPanel, d, p);
                 //mainFrameSplitPanel.setRightComponent(restManager);

             }
             else if(a.equals("DISTRIBUTION_MANAGER")){
                 Role r = new DistributionManagerRole();
                 DistributionManagePanel distributioManagerPanel = (DistributionManagePanel) r.createWorkArea(mainFrameworkAreaPanel, d, p);
                 mainFrameSplitPanel.setRightComponent(distributioManagerPanel);
                 
             }
             else if(a.equals("FOOD_SERVICE_ADMIN")){
                Role r = new FoodServiceAdminRole();
                 FoodServiceAdminPanel foodServiceAdmin = (FoodServiceAdminPanel) r.createWorkArea(mainFrameworkAreaPanel, d, p);
                mainFrameSplitPanel.setRightComponent(foodServiceAdmin);
             }
             else if(a.equals("SYSTEM_ADMIN")){
                 Role r = new SystemAdminRole();
                 SystemAdminJPanel sysAdmin = (SystemAdminJPanel) r.createWorkArea(mainFrameworkAreaPanel, d, p);
                 mainFrameSplitPanel.setRightComponent(sysAdmin);
             }
             else if(a.equals("CLOTHES_SERVICE_ADMIN")){
                 Role r = new ClothesServiceAdminRole();
                 ClothesServiceAdminPanel clothesServiceAdmin = (ClothesServiceAdminPanel) r.createWorkArea(mainFrameworkAreaPanel, d, p);
                 mainFrameSplitPanel.setRightComponent(clothesServiceAdmin);
             }
             else if(a.equals("NGO_MANAGER")){
                 Role r = new NGOManagerRole();
                 NGOManagerPanel ngoManager = (NGOManagerPanel) r.createWorkArea(mainFrameworkAreaPanel, d, p);
                 mainFrameSplitPanel.setRightComponent(ngoManager);
             }
             else if(a.equals("HOUSING_SERVICE_ADMIN")){
                 Role r = new HousingServiceAdminRole();
                 HousingServiceAdminPanel ngoManager = (HousingServiceAdminPanel) r.createWorkArea(mainFrameworkAreaPanel, d, p);
                 mainFrameSplitPanel.setRightComponent(ngoManager);
             }
             else{
                 Role r = new UserRole();
                 UserPanel userPanel = (UserPanel) r.createWorkArea(mainFrameworkAreaPanel, d, p);
                 mainFrameSplitPanel.setRightComponent(userPanel);
             }
             
             
             
        
             
         }else{
             JOptionPane.showMessageDialog(this, "Wrong username and password");
         }
         
//      }  
//      catch(Exception e){
//          JOptionPane.showMessageDialog(this, "fussword");
//      }
      return p;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainFrameSplitPanel = new javax.swing.JSplitPane();
        mainFramecontrolPanel = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        lbl_userNamePass = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mainFrameworkAreaPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainFramecontrolPanel.setBackground(new java.awt.Color(255, 255, 204));

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(204, 255, 204));
        btn_login.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(0, 0, 102));
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("New User?");

        btnRegister.setBackground(new java.awt.Color(204, 255, 204));
        btnRegister.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(0, 0, 102));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Existing User?");

        jLabel4.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("User Name");

        jLabel5.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Password");

        javax.swing.GroupLayout mainFramecontrolPanelLayout = new javax.swing.GroupLayout(mainFramecontrolPanel);
        mainFramecontrolPanel.setLayout(mainFramecontrolPanelLayout);
        mainFramecontrolPanelLayout.setHorizontalGroup(
            mainFramecontrolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFramecontrolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainFramecontrolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainFramecontrolPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainFramecontrolPanelLayout.createSequentialGroup()
                        .addComponent(lbl_userNamePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainFramecontrolPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(mainFramecontrolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainFramecontrolPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainFramecontrolPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainFramecontrolPanelLayout.createSequentialGroup()
                        .addGroup(mainFramecontrolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegister)
                            .addGroup(mainFramecontrolPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        mainFramecontrolPanelLayout.setVerticalGroup(
            mainFramecontrolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFramecontrolPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(mainFramecontrolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainFramecontrolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(lbl_userNamePass, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainFramecontrolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_login)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(mainFramecontrolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegister))
                .addContainerGap(516, Short.MAX_VALUE))
        );

        mainFrameSplitPanel.setLeftComponent(mainFramecontrolPanel);

        mainFrameworkAreaPanel.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon1-modified.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Charter", 3, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("WeCare");

        jLabel7.setFont(new java.awt.Font("Charter", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Developed By");

        jLabel11.setFont(new java.awt.Font("Charter", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Aditya Raj");

        jLabel12.setFont(new java.awt.Font("Charter", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Anupam Aditya");

        jLabel13.setFont(new java.awt.Font("Charter", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Akshita Barot");

        javax.swing.GroupLayout mainFrameworkAreaPanelLayout = new javax.swing.GroupLayout(mainFrameworkAreaPanel);
        mainFrameworkAreaPanel.setLayout(mainFrameworkAreaPanelLayout);
        mainFrameworkAreaPanelLayout.setHorizontalGroup(
            mainFrameworkAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFrameworkAreaPanelLayout.createSequentialGroup()
                .addGroup(mainFrameworkAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainFrameworkAreaPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainFrameworkAreaPanelLayout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addGroup(mainFrameworkAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainFrameworkAreaPanelLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        mainFrameworkAreaPanelLayout.setVerticalGroup(
            mainFrameworkAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFrameworkAreaPanelLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        mainFrameSplitPanel.setRightComponent(mainFrameworkAreaPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainFrameSplitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainFrameSplitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        RegisterPanel registerPanel = new RegisterPanel();
        mainFrameSplitPanel.setRightComponent(registerPanel);
        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        if(username.trim().equals("")|| password.trim().equals("")){
           lbl_userNamePass.setText("Please enter username and password");
        }
        else{
            try{
            userVerification(username, password);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            
        }
        
        txtUsername.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btn_loginActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbl_userNamePass;
    private javax.swing.JSplitPane mainFrameSplitPanel;
    private javax.swing.JPanel mainFramecontrolPanel;
    private javax.swing.JPanel mainFrameworkAreaPanel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
