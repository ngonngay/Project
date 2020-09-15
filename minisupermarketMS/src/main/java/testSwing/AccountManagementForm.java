/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testSwing;

import vn.edu.vtc.bl.AccountBL;
import vn.edu.vtc.bl.PasswordService;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.pl.OrderService;
import vn.edu.vtc.pl.StaticFunctionService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class AccountManagementForm extends javax.swing.JFrame {
    DefaultTableModel defaultTableModel;
    List<Account> accounts=new ArrayList<>();
    Account account;
    /**
     * Creates new form AccountManagementForm
     */
    public AccountManagementForm(Account account) {
        initComponents();
        defaultTableModel=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.account=account;
        tblListAccount.setModel(defaultTableModel);
        defaultTableModel.addColumn("Tên người dùng");
        defaultTableModel.addColumn("Mã nhân viên");
        defaultTableModel.addColumn("Tên nhân viên");
        defaultTableModel.addColumn("Vai trò");
        tblListAccount.setComponentPopupMenu(popupmenuUpdateAccount);
        show2();
    }
    public void show2(){
        defaultTableModel.setRowCount(0);

        accounts=new AccountBL().getAll();
        for (Account account : accounts){
            String actor;
            if (account.getIsAdmin()==0){
                actor="Quản Lý";
            }else {
                actor="Nhân viên";
            }
            defaultTableModel.addRow(new Object[]{account.getUserName(),account.getStaff_id(),account.getName(),actor});
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

        popupmenuUpdateAccount = new javax.swing.JPopupMenu();
        itemUpdate = new javax.swing.JMenuItem();
        itemResetPassword = new javax.swing.JMenuItem();
        itemDeteleAccount = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBack = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListAccount = new javax.swing.JTable();
        btnRefesh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnewUserName = new javax.swing.JTextField();
        btnCheckExitst = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNewStaffName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        checkboxPassword = new javax.swing.JCheckBox();
        lbPassword = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtReEnterPassword = new javax.swing.JPasswordField();
        checkboxReenterPassword = new javax.swing.JCheckBox();
        lbReEnterPassword = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();
        lbUserName = new javax.swing.JLabel();

        itemUpdate.setText("Cập nhật thông tin tài khoản");
        itemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUpdateActionPerformed(evt);
            }
        });
        popupmenuUpdateAccount.add(itemUpdate);

        itemResetPassword.setText("Đổi mật khẩu");
        itemResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemResetPasswordActionPerformed(evt);
            }
        });
        popupmenuUpdateAccount.add(itemResetPassword);

        itemDeteleAccount.setText("Xóa tài khoản");
        itemDeteleAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeteleAccountActionPerformed(evt);
            }
        });
        popupmenuUpdateAccount.add(itemDeteleAccount);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Quản lý tài khoản");

        btnBack.setText("<- Trở lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tblListAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên người dùng", "Mã nhân viên", "Tên nhân viên", "Vai trò"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListAccount);

        btnRefesh.setText("Làm mới");
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefesh)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRefesh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Danh sách tài khoản", jPanel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nhập tên đăng nhập :");

        txtnewUserName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtnewUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnewUserNameActionPerformed(evt);
            }
        });

        btnCheckExitst.setText("Kiểm tra");
        btnCheckExitst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckExitstActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tên của bạn             :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mật khẩu                  :");

        txtPassword.setToolTipText("Mật khẩu phải chứa từ 8-20 kí tự, có ít nhất một chữ cái hoa và chữ cái thường và chứa một kí tự số");

        checkboxPassword.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Nhập lại mật khẩu    :");

        checkboxReenterPassword.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Tạo Tài Khoản");

        btnCancle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancle.setText("Hủy");
        btnCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtnewUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addComponent(txtNewStaffName)
                        .addComponent(txtPassword)
                        .addComponent(txtReEnterPassword))
                    .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(checkboxReenterPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkboxPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbReEnterPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCheckExitst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnewUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckExitst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(checkboxPassword)
                    .addComponent(txtPassword))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addComponent(txtReEnterPassword))
                    .addComponent(checkboxReenterPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbReEnterPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnCancle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tạo mới tài khoản", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        // TODO add your handling code here:
        show2();
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void itemUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUpdateActionPerformed
        // TODO add your handling code here:
        int useRow =tblListAccount.getSelectedRow();
        if (useRow==-1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn tài khoản để thực hiện chức năng");
            return;
        }
            String username = (String) tblListAccount.getValueAt(useRow, 0);
            String oldStaffName = (String) tblListAccount.getValueAt(useRow, 2);
            UpdateAccountInformationForm updateAccountInformationForm =new UpdateAccountInformationForm(username,oldStaffName);
            updateAccountInformationForm.setVisible(true);

    }//GEN-LAST:event_itemUpdateActionPerformed

    private void itemResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemResetPasswordActionPerformed
        // TODO add your handling code here:
        int useRow =tblListAccount.getSelectedRow();
        if (useRow==-1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn tài khoản để thực hiện chức năng");
            return;
        }
        Integer selected= JOptionPane.showConfirmDialog(this,"Đổi mật khẩu");
        if (selected==JOptionPane.YES_OPTION) {
            String username=(String) tblListAccount.getValueAt(useRow,0);
            String actor = (String) tblListAccount.getValueAt(useRow, 3);
            if (actor.equalsIgnoreCase("Quản Lý")) {
               String oldPassword= (String)JOptionPane.showInputDialog("Nhập mật khẩu cũ:");
               if (oldPassword==null){
                   JOptionPane.showMessageDialog(this,"Mật khẩu trống!");
                   return;
               }
               Account accountCheck=new AccountBL().login(username, StaticFunctionService.getMd5(oldPassword));
               if (accountCheck==null){
                   JOptionPane.showMessageDialog(this,"Sai mật khẩu","Nhập mật khẩu cũ",JOptionPane.ERROR_MESSAGE);
                   return;
               }
                String newPassword= (String)JOptionPane.showInputDialog("Nhập mật khẩu mới:");
               if (newPassword==null){
                   JOptionPane.showMessageDialog(this,"Mật khẩu trống!");
                   return;
               }
                if (new AccountBL().changePassword(StaticFunctionService.getMd5(newPassword),username)){
                    JOptionPane.showMessageDialog(this,"Đổi mật khẩu thành công");
                    return;
                }else {
                    JOptionPane.showMessageDialog(this,"Đổi mật khẩu thất bại","Đổi mật khẩu",JOptionPane.ERROR_MESSAGE);
                }

                return;
            }else{
                String newPassword= (String)JOptionPane.showInputDialog("Nhập mật khẩu mới:");
                if (newPassword==null){
                    JOptionPane.showMessageDialog(this,"Mật khẩu trống!");
                    return;
                }
                if (new AccountBL().changePassword(StaticFunctionService.getMd5(newPassword),username)){
                    JOptionPane.showMessageDialog(this,"Đổi mật khẩu thành công");
                    return;
                }else {
                    JOptionPane.showMessageDialog(this,"Đổi mật khẩu thất bại","Đổi mật khẩu",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_itemResetPasswordActionPerformed

    private void itemDeteleAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeteleAccountActionPerformed
        // TODO add your handling code here:
        int useRow =tblListAccount.getSelectedRow();
        if (useRow==-1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn tài khoản để thực hiện chức năng");
            return;
        }
        Integer selected= JOptionPane.showConfirmDialog(this,"Xóa tài khoản này?");
        if (selected==JOptionPane.YES_OPTION){
            String actor=(String) tblListAccount.getValueAt(useRow,3);
            if (actor.equalsIgnoreCase("Quản Lý")){
                JOptionPane.showMessageDialog(this,"Không thể xóa tài khoản của quản lí","Xóa tài khoản",JOptionPane.ERROR_MESSAGE);
                return;
            }
            String username=(String) tblListAccount.getValueAt(useRow,0);
            int result=new AccountBL().delete(username);
            if (result==1){
                JOptionPane.showMessageDialog(this,"Xóa thành công");
                show2();
                return;
            }else if (result==-2){
                JOptionPane.showMessageDialog(this,"Không thể xóa tài khoản của quản lí","Xóa tài khoản",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                JOptionPane.showMessageDialog(this,"Xóa không thành công , vui lòng thử lại sau");
                show2();
            }
        }
    }//GEN-LAST:event_itemDeteleAccountActionPerformed

    private void txtnewUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnewUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnewUserNameActionPerformed

    private void btnCheckExitstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckExitstActionPerformed
        // TODO add your handling code here:
        String userName=txtnewUserName.getText();
        if (userName==null||userName.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đăng nhập để kiểm tra", "", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            boolean check=new AccountBL().checkExist(userName);
            if (check){
                lbUserName.setText("Tên người dùng đã tồn tại");
                lbUserName.setForeground(Color.RED);
                return;
            } else {
                if (PasswordService.validateUsername(userName)) {
                    lbUserName.setText("Hợp lệ");
                    return;
                }else{
                    JOptionPane.showMessageDialog(this,"Tên người dùng phải không có kí tự đặc biệt và phải có từ 8-20 kí tự", "", JOptionPane.ERROR_MESSAGE);
                    lbUserName.setText("Không hợp lệ");
                    return;
                }
                
            }
        }
    }//GEN-LAST:event_btnCheckExitstActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        // TODO add your handling code here:
        txtnewUserName.setText("");
        txtNewStaffName.setText("");
        txtPassword.setText("");
        txtReEnterPassword.setText("");
        checkboxPassword.setSelected(false);
        checkboxReenterPassword.setSelected(false);
        lbPassword.setText("");
        lbReEnterPassword.setText("");
    }//GEN-LAST:event_btnCancleActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        ManagerForm managerForm =new ManagerForm(account);
        managerForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(AccountManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Account account = new AccountBL().login("Nguyenquyetthang",
                StaticFunctionService.getMd5("Thangnguyenquyet123"));
                new AccountManagementForm(account).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnCheckExitst;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JCheckBox checkboxPassword;
    private javax.swing.JCheckBox checkboxReenterPassword;
    private javax.swing.JMenuItem itemDeteleAccount;
    private javax.swing.JMenuItem itemResetPassword;
    private javax.swing.JMenuItem itemUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbReEnterPassword;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JPopupMenu popupmenuUpdateAccount;
    private javax.swing.JTable tblListAccount;
    private javax.swing.JTextField txtNewStaffName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtReEnterPassword;
    private javax.swing.JTextField txtnewUserName;
    // End of variables declaration//GEN-END:variables
}