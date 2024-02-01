package view;


import controller.OrderController;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class AllCustomerReports extends javax.swing.JFrame {

    /**
     * Creates new form ViewCustomers
     */
   public AllCustomerReports() {
    initComponents();
    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

    DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) allCustomerReportsTable.getTableHeader().getDefaultRenderer();
    headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

    for (int i = 0; i < allCustomerReportsTable.getColumnCount(); i++) {
        allCustomerReportsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
    allCustomerReportsTable.setRowHeight(50);

    Object[] result = OrderController.allCustomerReport();
    DefaultTableModel dtm = (DefaultTableModel) allCustomerReportsTable.getModel();

    String[] customers = (String[]) result[0];
    int[][] tempSizesArray = (int[][]) result[1];
    double[] totalArray = (double[]) result[2];

    for (int i = 0; i < customers.length; i++) {
        String[] rowData = {
            customers[i],
            String.valueOf(tempSizesArray[i][0]),
            String.valueOf(tempSizesArray[i][1]),
            String.valueOf(tempSizesArray[i][2]),
            String.valueOf(tempSizesArray[i][3]),
            String.valueOf(tempSizesArray[i][4]),
            String.valueOf(tempSizesArray[i][5]),
            String.format("%.2f", totalArray[i])
        };
        dtm.addRow(rowData);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        allCustomerReportsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("All Customers");
        setFocusable(false);
        setPreferredSize(new java.awt.Dimension(650, 500));
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

        allCustomerReportsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customers ID", "XS", "S", "M", "L", "XL", "XXL", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(allCustomerReportsTable);
        if (allCustomerReportsTable.getColumnModel().getColumnCount() > 0) {
            allCustomerReportsTable.getColumnModel().getColumn(0).setMaxWidth(200);
            allCustomerReportsTable.getColumnModel().getColumn(1).setMinWidth(20);
            allCustomerReportsTable.getColumnModel().getColumn(1).setMaxWidth(50);
            allCustomerReportsTable.getColumnModel().getColumn(2).setMaxWidth(50);
            allCustomerReportsTable.getColumnModel().getColumn(3).setMaxWidth(50);
            allCustomerReportsTable.getColumnModel().getColumn(4).setMaxWidth(50);
            allCustomerReportsTable.getColumnModel().getColumn(5).setMaxWidth(50);
            allCustomerReportsTable.getColumnModel().getColumn(6).setMaxWidth(50);
            allCustomerReportsTable.getColumnModel().getColumn(7).setMaxWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 540, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
        new ViewReports().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allCustomerReportsTable;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
