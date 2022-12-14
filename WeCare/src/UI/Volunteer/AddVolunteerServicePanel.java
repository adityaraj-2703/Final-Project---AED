/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Volunteer;

import BusinessLogic.VolunteerDAO;
import javax.swing.JOptionPane;
import model.Person;

/**
 *
 * @author akshitabarot
 */
public class AddVolunteerServicePanel extends javax.swing.JPanel {

    VolunteerDAO volunteerDAO;
    String location, volunteerManager;

    Person p;
          
    /**
     * Creates new form AddVolunteerServicePanel
     */
    public AddVolunteerServicePanel() {
        initComponents();
        this.p = p;
        volunteerDAO = new VolunteerDAO();
        populateVolunteerManager();
        
    }

    
    boolean validation(){
        location = txtVolunteerServiceLocation.getText();
        volunteerManager = jComboBoxVolunteerServiceManager.getSelectedItem().toString();
        
        
        
        if (location.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter Location ");
            return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBoxVolunteerOrg = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        txtVolunteerServiceLocation = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jComboBoxVolunteerServiceManager = new javax.swing.JComboBox<>();
        btnAddVolunteerService = new javax.swing.JButton();

        jLabel2.setText("Volunteer Organisation");

        jComboBoxVolunteerOrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NGO", "College", "Self" }));

        jLabel42.setText("Location");

        jLabel43.setText("Volunteer Manager");

        btnAddVolunteerService.setText("Add Volunteer Service");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxVolunteerServiceManager, 0, 150, Short.MAX_VALUE)
                    .addComponent(jComboBoxVolunteerOrg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVolunteerServiceLocation))
                .addGap(293, 293, 293))
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(btnAddVolunteerService)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxVolunteerOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(txtVolunteerServiceLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jComboBoxVolunteerServiceManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(btnAddVolunteerService)
                .addGap(226, 226, 226))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVolunteerService;
    private javax.swing.JComboBox<String> jComboBoxVolunteerOrg;
    private javax.swing.JComboBox<Object> jComboBoxVolunteerServiceManager;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JTextField txtVolunteerServiceLocation;
    // End of variables declaration//GEN-END:variables

    private void populateVolunteerManager() {
        
    }
}
