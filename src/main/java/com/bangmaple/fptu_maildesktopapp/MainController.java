package com.bangmaple.fptu_maildesktopapp;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;

/**
 *
 * @author bangmaple SE140937
 */
public class MainController extends javax.swing.JFrame {

    private static int NUMBER_OF_MAIL_SEND = 1;
    private static int NUMBER_OF_SEC = 5;
    private static String[] ADDRESSES = null;

    public MainController() {
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLayout(null);
        initComponents();
        popupMenu();
    }

    private void popupMenu() {
        CutCopyPasteActionSupport support = new CutCopyPasteActionSupport();
        support.setPopup(txtMail);

    }

    private boolean validateInfo() {

        if (txtUsername.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please don't leave e-mail username blank.");
            return false;
        } else if (!txtUsername.getText().trim().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
            JOptionPane.showMessageDialog(this, "Only accept correct e-mail address format. Please try again");
            return false;
        }
        if (txtPassword.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please don't leave password blank.");
            return false;
        }
        if (txtAddress.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please don't leave receiver e-mail blank.");
            return false;
        } else {
            if (!txtAddress.getText().contains(",")) {
                ADDRESSES = new String[]{txtAddress.getText()};
            } else {
                ADDRESSES = txtAddress.getText().trim().split(",");
                if (ADDRESSES == null) {
                    JOptionPane.showMessageDialog(this, "Receiver address is not in correct format!");
                } else {
                    for (int i = 0; i < ADDRESSES.length; i++) {
                        if (!ADDRESSES[i].trim().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
                            JOptionPane.showMessageDialog(this, "Receiver address is not in correct format!");
                            return false;
                        }
                    }
                }
            }
        }
        if (txtNumSend.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please don't leave number of sending mail blank. At least 1.");
            return false;
        } else {
            try {
                int num = Integer.parseInt(txtNumSend.getText());
                if (num < 1 || num > 999) {
                    JOptionPane.showMessageDialog(this, "Only accept number of sending mail above 0 and less than 999.");
                    return false;
                } else {
                    NUMBER_OF_MAIL_SEND = num;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Only accept number of sending mail as number.");
                return false;
            }
        }
        if (!txtSec.getText().trim().isEmpty()) {
            try {
                int num1 = Integer.parseInt(txtSec.getText());
                if (num1 < 5 || num1 > 99999) {
                    JOptionPane.showMessageDialog(this, "Only accept number of sending mail above or equal 5 and less than 99999.");
                    return false;
                } else {
                    NUMBER_OF_SEC = num1;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Only accept number of second as number.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please don't leave timer field blank.");
            return false;
        }
        if (txtTitle.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please don't leave the mail title blank.");
            return false;
        }
        if (txtMail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please don't leave the mail body blank.");
            return false;
        }
        return true;
    }

    private void disableItems() {
        btnSend.setEnabled(false);
        btnReset.setEnabled(false);
        jButton1.setEnabled(false);
        txtPassword.setEnabled(false);
        txtUsername.setEnabled(false);
        txtTitle.setEnabled(false);
        txtNumSend.setEnabled(false);
        txtSec.setEnabled(false);
        txtMail.setEnabled(false);
    }

    private void enableItems() {
        btnSend.setEnabled(true);
        btnReset.setEnabled(true);
        jButton1.setEnabled(true);
        txtPassword.setEnabled(true);
        txtUsername.setEnabled(true);
        txtTitle.setEnabled(true);
        txtNumSend.setEnabled(true);
        txtSec.setEnabled(true);
        txtMail.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new MotionPanel(this);
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMail = new javax.swing.JTextArea();
        jPanel3 = new MotionPanel(this);
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        txtNumSend = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSec = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtStatus = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btnUse = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnReset = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Mail Sending Application - SE140937");

        txtMail.setColumns(20);
        txtMail.setRows(5);
        jScrollPane1.setViewportView(txtMail);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel4.setText("To (separate e-mail by ,):");

        jLabel5.setText("Number of mail(s) will be sent:");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        txtAddress.setText("qldthcm@fe.edu.vn, anhtt94@fe.edu.vn");
        jScrollPane2.setViewportView(txtAddress);

        txtNumSend.setText("1");

        jLabel7.setText("for each");

        txtSec.setText("10");

        jLabel8.setText("(s)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNumSend, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSec, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(11, 11, 11))
        );

        jLabel6.setText("Title:");

        txtStatus.setEditable(false);
        txtStatus.setColumns(20);
        txtStatus.setRows(5);
        txtStatus.setText("Status: Waiting to send...");
        jScrollPane3.setViewportView(txtStatus);

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnUse.setText("How to use");
        btnUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUse)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btnUse))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mail authentication"));

        jLabel1.setText("E-mail:");

        jLabel2.setText("Password:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSend.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        btnSend.setText("SEND");
        btnSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSendMouseClicked(evt);
            }
        });
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        if (validateInfo()) {
            SendMailDAO dao = new SendMailDAO();
            new SwingWorker<Void, Void>() {
                boolean flag = true;

                @Override
                protected Void doInBackground() throws Exception {
                    disableItems();
                    txtStatus.setForeground(Color.CYAN);
                    txtStatus.setText("Status: Sending mail now...");

                    try {
                        for (int i = 0; i < NUMBER_OF_MAIL_SEND; i++) {
                            if (NUMBER_OF_MAIL_SEND > 1) {
                                txtStatus.setForeground(Color.CYAN);
                                txtStatus.setText("Status: Sending mail number " + (i + 1) + " ...");
                            }
                            for (int j = 0; j < ADDRESSES.length; j++) {
                                dao.sendMail(txtUsername.getText().trim(), txtPassword.getText().trim(), ADDRESSES[j], txtTitle.getText(), txtMail.getText());
                            }
                            Thread.sleep(NUMBER_OF_SEC * 1000);
                        }
                    } catch (Exception e) {
                        enableItems();
                        JOptionPane.showMessageDialog(null, "Error while sending mail. Did you enter wrong info or sent too many mails?\nPlease read 'How to use'.");
                        txtStatus.setForeground(Color.red);
                        txtStatus.setText("Status: Failed! Please send again!");
                        flag = false;
                    }
                    enableItems();
                    if (flag) {
                        txtStatus.setForeground(Color.GREEN);
                        txtStatus.setText("Status: Successful!");
                    }
                    return null;
                }
            }.execute();
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSendMouseClicked

    private void btnUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "- Turn on the \"Less secure app access\" in the Google Account Setting.\n- Type your receiver(s) and your e-mail information to proceed.\n- Type number of mail(s) and sec(s) to send.", "How to use this program?", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnUseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtMail.setText("");
        txtTitle.setText("");
        txtPassword.setText("");
        txtUsername.setText("");
        txtNumSend.setText("1");
        txtSec.setText("5");
    }//GEN-LAST:event_btnResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!txtMail.getText().trim().isEmpty() || !txtTitle.getText().trim().isEmpty()) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure want to exit?");
            if (choice == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, "Thanks for using my application! ^^");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thanks for using my application! ^^");
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainController().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnUse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtMail;
    private javax.swing.JTextField txtNumSend;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSec;
    private javax.swing.JTextArea txtStatus;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
