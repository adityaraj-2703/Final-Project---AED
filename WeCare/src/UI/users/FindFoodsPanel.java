/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.users;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Data;
import model.FoodDetails;
import model.FoodOrder;
import model.Person;

/**
 *
 * @author adityaraj
 */
public class FindFoodsPanel extends javax.swing.JPanel {

    /**
     * Creates new form FindFoodsPanel
     */
    Data d;
    Person p;
    public FindFoodsPanel(Data d,Person p) {
        initComponents();
        this.d = d;
        this.p = p;
        populateFoodsAvailable();
        populateFoodsOrderTable();
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
        tblFindFoodsAvailable = new javax.swing.JTable();
        btnBookFood = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFoodOrders = new javax.swing.JTable();

        tblFindFoodsAvailable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FoodId", "Food Name", "Food Type", "Quantity Left", "Food Location"
            }
        ));
        jScrollPane1.setViewportView(tblFindFoodsAvailable);

        btnBookFood.setText("Book");
        btnBookFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookFoodActionPerformed(evt);
            }
        });

        tblFoodOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "OrderId", "FoodId", "Customer"
            }
        ));
        jScrollPane2.setViewportView(tblFoodOrders);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBookFood)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBookFood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookFoodActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblFindFoodsAvailable.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select row to approve the request");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblFindFoodsAvailable.getModel();
        FoodDetails f = (FoodDetails) model.getValueAt(selectedRowIndex, 1);
        int v = d.addOrder(f,p);
        if(v==0){
            JOptionPane.showMessageDialog(this, "Error in Approving Foods");
            return;
        }
        populateFoodsAvailable();
        populateFoodsOrderTable();
        
    }//GEN-LAST:event_btnBookFoodActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookFood;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblFindFoodsAvailable;
    private javax.swing.JTable tblFoodOrders;
    // End of variables declaration//GEN-END:variables

    private void populateFoodsAvailable() {
        DefaultTableModel model = (DefaultTableModel) tblFindFoodsAvailable.getModel();
        model.setRowCount(0);
        d.getFoodDetails();
        for(FoodDetails f : d.getApprovedFoodDetails()){
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

    private void populateFoodsOrderTable() {
        DefaultTableModel model = (DefaultTableModel) tblFoodOrders.getModel();
        model.setRowCount(0);
        d.getFoodOrderDetails();
        for(FoodOrder f : d.getFoodOrderDetails()){
            Object[] row = new Object[4];
            row[0] = f.getFoodId();
            row[1] = f.getOrderId();
            row[2] = f.getPerson();
            model.addRow(row);
        }
    }
}
