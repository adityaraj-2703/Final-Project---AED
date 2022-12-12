/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Housing;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Data;
import model.FoodDetails;
import model.HousingDetails;
import model.Person;
import model.city.Address;
import model.city.City;
import model.city.Community;

/**
 *
 * @author anupamaditya
 */
public class HousingServiceManagerPanel extends javax.swing.JPanel {

    /**
     * Creates new form HousingServiceManagerPanel
     */
    Data d;
    Person p;
    public HousingServiceManagerPanel(Data d, Person p) {
        initComponents();
        this.d = d;
        this.p = p;
        populateAddress();
        populateHousing();
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
        tblHousing = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtHousingId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBookingdate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAvailableBeds = new javax.swing.JTextField();
        btnAddHousing = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAddress = new javax.swing.JComboBox<>();

        tblHousing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "HousingID", "Address", "Booking Date", "Available Beds", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblHousing);

        jLabel1.setText("HousingID");

        jLabel4.setText("Booking Date");

        jLabel5.setText("Available Beds");

        btnAddHousing.setText("Add");
        btnAddHousing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHousingActionPerformed(evt);
            }
        });

        jButton3.setText("View");

        jLabel2.setText("Address");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtHousingId, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBookingdate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAvailableBeds, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxAddress, 0, 233, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(btnAddHousing)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHousingId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBookingdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAvailableBeds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddHousing)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddHousingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHousingActionPerformed
        // TODO add your handling code here:
        
        String date = txtBookingdate.getText();
        String dateRegex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
        Pattern datePattern = Pattern.compile(dateRegex);
        Matcher matcher = datePattern.matcher(date);
        if(matcher.matches()==false){
            JOptionPane.showMessageDialog(this, "Enter Valid Encounter Date: MM/DD/YYYY");
            return;
        }
        if(txtAvailableBeds.getText().length()==0 || jComboBoxAddress.getSelectedItem()==null){
            JOptionPane.showMessageDialog(this, "Enter All fields");
            return;
        }
        
        int beds = Integer.parseInt(txtAvailableBeds.getText());
        if(beds==0){
            JOptionPane.showMessageDialog(this, "Enter valid Bed Number");
            return;
        }
        Address location = (Address)jComboBoxAddress.getSelectedItem();
        int v = d.addHousing(date,beds,location);
        if(v==0){
            JOptionPane.showMessageDialog(this, "Error in adding Food");
            return;
        }
        txtBookingdate.setText("");
        txtAvailableBeds.setText("");
        
        jComboBoxAddress.setSelectedItem(null);

        JOptionPane.showMessageDialog(this, "Food Added Successfully");
        populateHousing();
        
        
        
    }//GEN-LAST:event_btnAddHousingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHousing;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<Object> jComboBoxAddress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHousing;
    private javax.swing.JTextField txtAvailableBeds;
    private javax.swing.JTextField txtBookingdate;
    private javax.swing.JTextField txtHousingId;
    // End of variables declaration//GEN-END:variables

    private void populateAddress() {
        List<City> cities = d.getCities();
        jComboBoxAddress.removeAllItems();
        for(City c : cities){
            for(Community comm : c.getCommunityList()){
                for(Address add : comm.getHouseList()){
                    jComboBoxAddress.addItem(add);
                }
                
            }
        
        }
    }

    private void populateHousing() {
        DefaultTableModel model = (DefaultTableModel) tblHousing.getModel();
        model.setRowCount(0);
        
        d.getHousingDetails();
        
        for(HousingDetails f : d.getHousingDirectory().getHousingDirectory()){
            Object[] row = new Object[5];
            row[0] = f.getHousingID();
            row[1] = f.getHousingAddress();
            row[2] = f.getBookingDate();
            row[3] = f.getAvailableBeds();
            row[4] = f.getStatus();
            
            model.addRow(row);
        }
    }
}
