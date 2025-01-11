package view;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.table.TableColumnModel;

public class OTPListView extends javax.swing.JFrame {

    private JTable otpTable;
    private JButton refreshButton;
    private JButton backButton;
    private javax.swing.JButton deleteBtn;

    public OTPListView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Daftar OTP");
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));

        otpTable = new JTable(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID OTP", "Kode OTP", "Dibuat Pada", "Berakhir Pada", "Status"}
        ));
        
        // Atur lebar kolom untuk menyesuaikan data
        otpTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        TableColumnModel columnModel = otpTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);  // ID OTP
        columnModel.getColumn(1).setPreferredWidth(150); // Kode OTP
        columnModel.getColumn(2).setPreferredWidth(200); // Dibuat Pada
        columnModel.getColumn(3).setPreferredWidth(200); // Berakhir Pada
        columnModel.getColumn(4).setPreferredWidth(130); // Status

        JScrollPane tableScrollPane = new JScrollPane(otpTable);

        refreshButton = new JButton("Refresh");
        backButton = new JButton("Back");
        deleteBtn = new JButton("Delete");

    

        GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);

            // Perpanjang ukuran frame
            setPreferredSize(new Dimension(800, 500));

            // Horizontal Group
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(titleLabel)
                    .addComponent(tableScrollPane, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE) // Sesuaikan lebar tabel
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backButton))
            );

            // Vertical Group
            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGap(20) // Padding atas
                    .addComponent(titleLabel)
                    .addGap(20)
                    .addComponent(tableScrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE) // Tambahkan tinggi tabel
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(refreshButton)
                        .addComponent(deleteBtn)
                        .addComponent(backButton))
                    .addGap(20) // Padding bawah
            );

            // Simpan pengaturan baru
            pack();
            setLocationRelativeTo(null); // Pastikan frame muncul di tengah layar

    }

    public JTable getOTPTable() {
        return otpTable;
    }

    public void addRefreshButtonListener(ActionListener listener) {
        refreshButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
    public void addDeleteButtonListener(ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }
}
