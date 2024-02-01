package view;


import controller.OrderController;
import javax.swing.JOptionPane;
import model.Orders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class SearchOrder extends javax.swing.JFrame {

    /**
     * Creates new form SearchOrder
     */
    public SearchOrder() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        orderIdLabel = new javax.swing.JLabel();
        orderIdText = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        customerIdLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        qtyLable = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        customerIdLabel2 = new javax.swing.JLabel();
        sizeLabel2 = new javax.swing.JLabel();
        qtyLabel2 = new javax.swing.JLabel();
        amountLabel2 = new javax.swing.JLabel();
        statusLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Order");
        setFocusable(false);
        setResizable(false);

        backButton.setBackground(new java.awt.Color(255, 102, 51));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        orderIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        orderIdLabel.setText("Enter Order ID :");

        orderIdText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        searchButton.setBackground(new java.awt.Color(55, 168, 161));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setPreferredSize(new java.awt.Dimension(85, 37));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        customerIdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        customerIdLabel.setText("Customer ID :");

        sizeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sizeLabel.setText("Size :");

        qtyLable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        qtyLable.setText("Qty :");

        amountLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        amountLabel.setText("Amount :");

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        statusLabel.setText("Status :");

        customerIdLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        sizeLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        qtyLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        amountLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        statusLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderIdLabel)
                    .addComponent(customerIdLabel)
                    .addComponent(statusLabel)
                    .addComponent(amountLabel)
                    .addComponent(qtyLable)
                    .addComponent(sizeLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerIdLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(orderIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sizeLabel2)
                            .addComponent(qtyLabel2)
                            .addComponent(amountLabel2)
                            .addComponent(statusLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderIdLabel)
                    .addComponent(orderIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerIdLabel)
                    .addComponent(customerIdLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel)
                    .addComponent(sizeLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtyLable)
                    .addComponent(qtyLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountLabel)
                    .addComponent(amountLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusLabel2))
                .addGap(0, 98, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
        new HomeMain().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        Orders orders = OrderController.searchOrder(orderIdText.getText());
        if (orders == null) {
            JOptionPane.showMessageDialog(this, "Order not exists..");
            orderIdText.setText("");
        } else {
            String status1 = orders.getOrderStatus() == 0 ? "PROCESSING" : orders.getOrderStatus() == 1 ? "DELIVERING" : "DELIVERED";

            customerIdLabel2.setText(orders.getMobileNumber());
            sizeLabel2.setText(orders.getSizes());
            qtyLabel2.setText(String.valueOf(orders.getQty()));
            amountLabel2.setText(String.format("%.2f", orders.getAmount()));
            statusLabel2.setText(String.valueOf(status1));

        }
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel amountLabel2;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel customerIdLabel;
    private javax.swing.JLabel customerIdLabel2;
    private javax.swing.JLabel orderIdLabel;
    private javax.swing.JTextField orderIdText;
    private javax.swing.JLabel qtyLabel2;
    private javax.swing.JLabel qtyLable;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JLabel sizeLabel2;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel statusLabel2;
    // End of variables declaration//GEN-END:variables
}
