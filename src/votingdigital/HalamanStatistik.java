// Paket
package votingdigital; 
// Kelas Halaman Statistik
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// Kelas - Halaman Statistik
public class HalamanStatistik extends JFrame {
    // Metode Public - Halaman Statistik
    public HalamanStatistik(String[] namaKandidat, String[] gambarKandidat, int[] suaraKandidat) {
        // 1.0 Jendela Utama
        setTitle("Statistik Pemilihan");
        setSize(600, 400);
        getContentPane().setBackground(new Color(173, 216, 230));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        // Perhitungan Suara Masing-Masing Kandidat
        int totalSuara = suaraKandidat[0] + suaraKandidat[1];
        String[] persentaseSuara = {
            totalSuara > 0 ? String.format("%.1f%%", (suaraKandidat[0] * 100.0) / totalSuara) : "0%",
            totalSuara > 0 ? String.format("%.1f%%", (suaraKandidat[1] * 100.0) / totalSuara) : "0%"
        };
        // Iterasi Penempatan Informasi kandidat 
        for (int i = 0; i < 2; i++) {
            int x = i * 300; // Posisi horizontal kandidat + Jeda Piksel (50)
            // 2.0 Gambar Kandidat
            JLabel gambar = new JLabel(Method.memuatGambar(gambarKandidat[i], 200, 200));
            gambar.setBounds(x + 50, 50, 200, 200);
            add(gambar);
            // 3.0 Nama Kandidat
            JLabel nama = new JLabel(namaKandidat[i], SwingConstants.CENTER);
            nama.setBounds(x + 50, 260, 200, 30);
            nama.setFont(new Font("Arial", Font.BOLD, 18));
            nama.setForeground(Color.BLACK);
            add(nama);
            // 4.0 Perolehan Suara 
            JLabel suara = new JLabel(persentaseSuara[i], SwingConstants.CENTER);
            suara.setBounds(x + 50, 300, 200, 30);
            suara.setFont(new Font("Arial", Font.BOLD, 16));
            suara.setForeground(Color.BLUE);
            add(suara);
        }
        // 6.0 Tombol Logout 
        JButton tombolLogout = Method.membuatTombol("Log Out", 250, 320, 100, 30);
        tombolLogout.setBackground(Color.BLUE);
        // ActionListener Untuk Tombol Logout 
        tombolLogout.addActionListener(e -> {
            new HalamanLogin().setVisible(true);
            dispose(); // Menutup halaman statistik
        });
        add(tombolLogout);
    }
}
