/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.FoodService;

import BusinessLogic.OrganisationDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Data;
import model.Enterprise.Enterprise;
import model.FoodDetails;
import model.Organisation.Organisation;
import model.Person;

/**
 *
 * @author anupamaditya
 */
public class AddViewFood extends javax.swing.JPanel {

    /**
     * Creates new form RestAddFood
     */
    
    Person p;
    Data d;
    Organisation o;
    
    public AddViewFood(Data d, Person p) {
        initComponents();
            
          this.p = p;
          this.d = d;
          o = getOrgansation(p);
          populateFoodsTable();
          
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFood = new javax.swing.JTable();
        btnViewFood = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFoodId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFoodName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxFoodType = new javax.swing.JComboBox<>();
        txtFoodQuantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAddFood = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "FoodID", "Food Name", "Food Type", "Food Quantity", "Organisation", "Food Status"
            }
        ));
        jScrollPane1.setViewportView(tblFood);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 23, 832, 324));

        btnViewFood.setBackground(new java.awt.Color(204, 255, 204));
        btnViewFood.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        btnViewFood.setForeground(new java.awt.Color(0, 0, 102));
        btnViewFood.setText("View Food");
        btnViewFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFoodActionPerformed(evt);
            }
        });
        add(btnViewFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 370, 113, 31));

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 102));
        jButton2.setText("Delete Food");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 370, 118, 31));

        jLabel1.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("FoodID");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 434, 76, 25));
        add(txtFoodId, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 434, 120, 25));

        jLabel2.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Food Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 471, 76, 25));
        add(txtFoodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 471, 120, 25));

        jLabel3.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Food Type");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 508, 76, 25));

        jComboBoxFoodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veg", "Non-Veg" }));
        add(jComboBoxFoodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 508, 120, 25));
        add(txtFoodQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 545, 120, 25));

        jLabel5.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Food Quantity");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 545, -1, 25));

        btnAddFood.setBackground(new java.awt.Color(204, 255, 204));
        btnAddFood.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        btnAddFood.setForeground(new java.awt.Color(0, 0, 102));
        btnAddFood.setText("Create Food");
        btnAddFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFoodActionPerformed(evt);
            }
        });
        add(btnAddFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, -1, -1));

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setFont(new java.awt.Font("Charter", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 102));
        jButton4.setText("Update Food");
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFoodActionPerformed
        // TODO add your handling code here:
        String name = String.valueOf(txtFoodName.getText());
        String foodType = (String) jComboBoxFoodType.getSelectedItem();
        int quantity = Integer.parseInt(txtFoodQuantity.getText());
        if(txtFoodName.getText().length()==0 || jComboBoxFoodType.getSelectedItem()==null || txtFoodQuantity.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Enter All fields");
            return;
        }

        int v = d.addFood(name,foodType,quantity,o);
        if(v==0){
            JOptionPane.showMessageDialog(this, "Error in adding Food");
            return;
        }
        txtFoodId.setText("");
        txtFoodName.setText("");
        txtFoodQuantity.setText("");
        jComboBoxFoodType.setSelectedItem("");

        JOptionPane.showMessageDialog(this, "City Info Saved");
        populateFoodsTable();
        
    }//GEN-LAST:event_btnAddFoodActionPerformed

    private void btnViewFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFoodActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblFood.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select row to view the details");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblFood.getModel();
        FoodDetails o = (FoodDetails) model.getValueAt(selectedRowIndex, 1);
        txtFoodId.setText(String.valueOf(o.getFoodID()));
        txtFoodId.setEditable(false);
        txtFoodName.setText(String.valueOf(o.getFoodName()));
        txtFoodName.setEditable(true);
        txtFoodQuantity.setText(o.getFoodName());
        txtFoodQuantity.setEditable(true);
        jComboBoxFoodType.setSelectedItem(String.valueOf(o.getFoodType()));
        jComboBoxFoodType.setEditable(true);
        
    }//GEN-LAST:event_btnViewFoodActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFood;
    private javax.swing.JButton btnViewFood;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBoxFoodType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFood;
    private javax.swing.JTextField txtFoodId;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtFoodQuantity;
    // End of variables declaration//GEN-END:variables

    private Organisation getOrgansation(Person p1) {
        Organisation o = d.getOrganisation(p1);
        if(o==null){
            JOptionPane.showMessageDialog(this, "Error in fetching Organisation");
            
        }
        return o;
    }

    private void populateFoodsTable() {
        DefaultTableModel model = (DefaultTableModel) tblFood.getModel();
        model.setRowCount(0);
        
        d.getFoodDetails();
        
        for(FoodDetails f : d.getFoodDirectory().getFoodDirectory()){
            Object[] row = new Object[6];
            row[0] = f.getFoodID();
            row[1] = f;
            row[2] = f.getFoodType();
            row[3] = f.getFoodQuantity();
            row[4] = f.getOrg();
            row[5] = f.getFoodStatus();
            model.addRow(row);
        }
    }
}
