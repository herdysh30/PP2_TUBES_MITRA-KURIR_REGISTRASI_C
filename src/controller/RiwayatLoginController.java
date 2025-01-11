package controller;

import model.RiwayatLogin;
import model.RiwayatLoginMapper;
import org.apache.ibatis.session.SqlSession;
import view.RiwayatLoginView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RiwayatLoginController {
    private RiwayatLoginView view;
    private RiwayatLoginMapper riwayatLoginMapper;
    private SqlSession session;

    public RiwayatLoginController(RiwayatLoginView view, RiwayatLoginMapper riwayatLoginMapper, SqlSession session) {
        this.view = view;
        this.riwayatLoginMapper = riwayatLoginMapper;
        this.session = session;

        // Muat data saat tampilan dibuka
        loadRiwayatLoginData();

        // Tambahkan listener ke tombol
        view.addRefreshButtonListener(new RefreshButtonListener());
        view.addBackButtonListener(new BackButtonListener());
    }

    // Method untuk memuat data riwayat login ke JTable
    private void loadRiwayatLoginData() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) view.getLoginTable().getModel();
            tableModel.setRowCount(0); 

            List<RiwayatLogin> riwayatLogins = riwayatLoginMapper.getAllRiwayatLogin();
            for (RiwayatLogin riwayat : riwayatLogins) {
                Object[] rowData = {
                    riwayat.getId(),
                    riwayat.getKurirId(),
                    riwayat.getName(),
                    riwayat.getEmail(),
                    riwayat.getLoginTime()
                };
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Listener untuk tombol Refresh
    class RefreshButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadRiwayatLoginData(); // Panggil ulang untuk memuat data terbaru
        }
    }

    // Listener untuk tombol Kembali
    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose(); // Tutup tampilan RiwayatLoginView
        }
    }
}
