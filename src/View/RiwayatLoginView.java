package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RiwayatLoginView extends JFrame {
    private JTable loginTable;
    private JButton refreshButton;
    private JButton backButton;

    public RiwayatLoginView() {
        setTitle("Riwayat Login User");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Label title
        JLabel titleLabel = new JLabel("Riwayat Login User", SwingConstants.CENTER);
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));

        // Tabel untuk menampilkan data
        loginTable = new JTable(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID Riwayat", "ID Kurir", "Nama Kurir", "Email", "Login Timestamp"}
        ));
        JScrollPane tableScrollPane = new JScrollPane(loginTable);

        // Tombol
        refreshButton = new JButton("Refresh");
        backButton = new JButton("Kembali");

        // Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(titleLabel)
                .addComponent(tableScrollPane, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(refreshButton)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(backButton))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(20)
                .addComponent(titleLabel)
                .addGap(20)
                .addComponent(tableScrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(backButton))
        );
    }

    // Getter untuk tabel
    public JTable getLoginTable() {
        return loginTable;
    }

    // Getter untuk tombol
    public JButton getRefreshButton() {
        return refreshButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    // Listener untuk tombol refresh
    public void addRefreshButtonListener(java.awt.event.ActionListener listener) {
        refreshButton.addActionListener(listener);
    }

    // Listener untuk tombol kembali
    public void addBackButtonListener(java.awt.event.ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
