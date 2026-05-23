// Paket
package votingdigital;
// Pustaka
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// Kelas Halaman Pemilihan Suara
public class HalamanPemilihanSuara extends JFrame {
    // Variabel untuk melacak jumlah suara
    private static int[] suaraKandidat = {0, 0};
    // Metode Publik
    public HalamanPemilihanSuara() {
        // 1.0 Jendela Utama
        setTitle("Voting OSIS");
        setSize(500, 550);
        getContentPane().setBackground(new Color(173, 216, 230));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null); 
        // 2.0 Gambar 
        JLabel judul = new JLabel(Method.memuatGambar("assets/header_voting_page.png", 500, 125));
        judul.setBounds(0, 0, 500, 125);
        add(judul);
        // 3.0 Informasi Kandidat
        String[] gambarKandidat = {"assets/kandidat_1.png", "assets/kandidat_2.png"};
        String[] namaKandidat = {"Henry Stickman", "Alicia Keys"};
        String[] kelasKandidat = {"Kelas 12 MIPA 4", "Kelas 12 MIPA 6"};
        String[] visiDanMisi = {
                "Visi dan Misi Calon Pengurus 1:\nVisi: Meningkatkan kualitas pengurus OSIS\nMisi: Memperkaya kegiatan positif",
                "Visi dan Misi Calon Pengurus 2:\nVisi: Menciptakan lingkungan OSIS yang inklusif\nMisi: Menjembatani aspirasi siswa"
        };
        // Iterasi 
        for (int i = 0; i < 2; i++) {
            int x = i * 250; // Posisi Horizontal Kandidat
            // 4.0 Panel Kedua Kandidat
            JPanel panel = new JPanel(null);
            panel.setBounds(x, 130, 240, 390);
            add(panel);
            // 4.1 Gambar Kandidat
            JLabel gambar = new JLabel(new ImageIcon(gambarKandidat[i]));
            gambar.setBounds(20, 20, 200, 200);
            panel.add(gambar);
            // 4.2 Nama Kandidat
            JLabel nama = Method.membuatInformasi(namaKandidat[i], SwingConstants.CENTER, 20, 230, 200, 20, Color.BLUE);
            panel.add(nama);
            // 4.3 Kelas Kandidat
            JLabel kelas = Method.membuatInformasi(kelasKandidat[i], SwingConstants.CENTER, 20, 260, 200, 20, Color.BLUE);
            panel.add(kelas);
            // 4.4 Tombol Visi & Misi
            JButton tombolVisiDanMisi = Method.membuatTombol("Visi dan Misi", 20, 290, 200, 30);
            tombolVisiDanMisi.setBackground(Color.BLUE);
            tombolVisiDanMisi.setForeground(Color.WHITE);
            int index = i;
            tombolVisiDanMisi.addActionListener(e -> JOptionPane.showMessageDialog(this, visiDanMisi[index]));
            panel.add(tombolVisiDanMisi);
            // 4.5 Tombol Pilih
            JButton tombolPilih = Method.membuatTombol("Pilih", 20, 330, 200, 30);
            tombolPilih.setBackground(Color.BLUE);
            tombolPilih.setForeground(Color.WHITE);
            // ActionListener Pilihan Suara Siswa 
            tombolPilih.addActionListener(e -> {
                int konfirmasi = JOptionPane.showConfirmDialog(HalamanPemilihanSuara.this, "Apakah Anda yakin memilih " + namaKandidat[index] + "?", "Konfirmasi Pilihan", JOptionPane.YES_NO_OPTION);
                if (konfirmasi == JOptionPane.YES_OPTION) {
                    // Menambahkan Jumlah Suara
                    suaraKandidat[index]++;
                    JOptionPane.showMessageDialog(HalamanPemilihanSuara.this, "Terima kasih telah memilih " + namaKandidat[index] + "!");
                    // Menampilkan Halaman Statistik
                    new HalamanStatistik(namaKandidat, gambarKandidat, suaraKandidat).setVisible(true);
                    dispose(); // Menutup halaman pemilihan
                }
            });
            panel.add(tombolPilih);
        }
    }
}