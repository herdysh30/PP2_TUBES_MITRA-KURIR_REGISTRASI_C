package controller;

import com.lowagie.text.DocumentException;
import model.Kurir;
import model.KurirMapper;
import org.apache.ibatis.session.SqlSession;
import view.UserListView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UserListController {
    private UserListView view;
    private KurirMapper mapper;
    private SqlSession session;

    public UserListController(UserListView view, KurirMapper mapper, SqlSession session) {
        this.view = view;
        this.mapper = mapper;
        this.session = session;

        // Muat data ke tabel saat tampilan dibuka
        loadUserData();

        // Tambahkan listener ke tombol
        view.addRefreshButtonListener(new RefreshButtonListener());
        view.addBackButtonListener(new BackButtonListener());
        view.addDeleteButtonListener(new DeleteButtonListener());
        view.addExportButtonListener(new ExportButtonListener());

    }

    // Method untuk memuat data pengguna ke JTable
    private void loadUserData() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) view.getUserTable().getModel();
            tableModel.setRowCount(0); 

            for (Kurir kurir : mapper.getAllUsers()) {
                Object[] rowData = {
                    kurir.getId(),
                    kurir.getName(),
                    kurir.getEmail(),
                    kurir.getNoTelp(),
                    kurir.getAddress()
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
            loadUserData(); 
        }
    }

    // Listener untuk tombol Kembali
    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose(); // Tutup halaman UserListView
        }
    }
    
    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = view.getUserTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Pilih pengguna yang ingin dihapus.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(view, "Apakah Anda yakin ingin menghapus pengguna ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            try {
                DefaultTableModel tableModel = (DefaultTableModel) view.getUserTable().getModel();
                int userId = (int) tableModel.getValueAt(selectedRow, 0); // Ambil ID dari baris yang dipilih

                mapper.deleteKurir(userId); 
                session.commit();

                JOptionPane.showMessageDialog(view, "Pengguna berhasil dihapus.");
                loadUserData(); // Refresh data tabel setelah penghapusan
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Terjadi kesalahan saat menghapus pengguna: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    class ExportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Dapatkan data dari tabel
                List<String[]> tableData = new ArrayList<>();
                for (Kurir kurir : mapper.getAllUsers()) {
                    tableData.add(new String[]{
                            String.valueOf(kurir.getId()),
                            kurir.getName(),
                            kurir.getEmail(),
                            kurir.getNoTelp(),
                            kurir.getAddress()
                    });
                }

                // Header kolom
                String[] headers = {"ID", "Nama", "Email", "No Telp", "Alamat"};

                // File output
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Simpan PDF");
                if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".pdf";
                    PDFExporter.exportTableToPDF(filePath,"Daftar User", tableData, headers);
                    JOptionPane.showMessageDialog(view, "File berhasil diekspor ke " + filePath);
                }
            } catch (DocumentException | IOException ex) {
                JOptionPane.showMessageDialog(view, "Gagal mengekspor data: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

}
