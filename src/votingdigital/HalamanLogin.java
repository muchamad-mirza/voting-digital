// Paket
package votingdigital;
// Pustaka 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// Kelas 
public class HalamanLogin extends JFrame {
    // Melacak Status Login
    private static boolean sudahMasuk = false;
    private static String siswaYangMasuk = null;
    // Kata Terminasi
    private static final String Kata_Terminasi = "SMANELA_JAYA";
    // Set Untuk Mencatat Siswa yang Telah Login
    private static Set<String> loginTercatat = new HashSet<>();
    // Metode - Halaman Login
    public HalamanLogin() {
        // 1.0 Jendela Utama
        setTitle("Voting Digital: OSIS ");
        setSize(600, 400);
        getContentPane().setBackground(new Color(173, 216, 230));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        // 2.0 Gambar Header - Judul
        JLabel judul = new JLabel(Method.memuatGambar("C:\\Users\\WINDOWS 11\\OneDrive\\Documents\\NetBeansProjects\\File\\Header - Sistem Voting Digital.png", 600, 80));
        judul.setBounds(0, 0, 600, 80); 
        add(judul);
        // 2.1 Label NISN
        JLabel ketNISNTest = Method.membuatInformasi1("NISN: ", 150, 100, 80, 25, Color.BLUE);
        add(ketNISNTest);
        // 2.2 TextField NISN
        JTextField isiNISN = new JTextField();
        isiNISN.setBounds(250, 100, 200, 25);
        add(isiNISN);
        // 3.1 Label Password 
        JLabel ketPassword = Method.membuatInformasi1("Password: ", 150, 150, 80, 25, Color.BLUE);
        add(ketPassword);
        // 3.2 TextField Password 
        JPasswordField isiPassword = new JPasswordField();
        isiPassword.setBounds(250, 150, 200, 25);
        add(isiPassword);
        // 4.0 Login
        JButton tombolLogin = Method.membuatTombol("Login", 250, 200, 100, 30);
        tombolLogin.setBackground(Color.BLUE);
        tombolLogin.setForeground(Color.WHITE);
        add(tombolLogin);
        // 5.0 Label untuk menampilkan pesan
        JLabel ketPesan = Method.membuatInformasi("", SwingConstants.CENTER, 250, 250, 300, 25, Color.WHITE);
        add(ketPesan);
        // ActionListener untuk Log In
        tombolLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NISN = isiNISN.getText();
                String password = new String(isiPassword.getPassword());
                // Pencabangan
                if (autentifikasi(NISN, password)) {
                    ketPesan.setText("Login berhasil!");
                    ketPesan.setForeground(Color.GREEN);
                    // Buka Halaman Pemilihan Suara
                    SwingUtilities.invokeLater(() -> {
                        HalamanPemilihanSuara halamanPemilihanSuara = new HalamanPemilihanSuara();
                        halamanPemilihanSuara.setVisible(true);
                        setVisible(false);
                    });
                } else {
                    if (loginTercatat.contains(NISN)) {
                        ketPesan.setText("Akun ini sudah melakukan login sebelumnya.");
                    } else {
                        ketPesan.setText("NISN atau password salah.");
                    }
                    ketPesan.setForeground(Color.RED);
                }
            }
        });
        // Menutup Aplikasi
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Kode penutup
                String kata = JOptionPane.showInputDialog(HalamanLogin.this, "Masukan kata terminasi: ", "Kata Terminasi", JOptionPane.PLAIN_MESSAGE);
                // Pencabangan - Memeriksa Kata Terminasi
                if (Kata_Terminasi.equals(kata)) {
                    // Me-reset Akun
                    sudahMasuk = false;
                    siswaYangMasuk = null; 
                    // Menutup Program
                    System.exit(0);  
                } else {
                    JOptionPane.showMessageDialog(HalamanLogin.this, "Mohon maaf, kata salah", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    // Pengecekan Aktivitas Login
    private static boolean autentifikasi(String NISN, String password) {
        // Periksa apakah NISN sudah login sebelumnya
        if (loginTercatat.contains(NISN)) {
            return false; 
        }
        for (String[] user : AkunSiswa.siswa) {
            if (user[0].equals(NISN) && user[1].equals(password)) {
                // Tandai akun telah login
                sudahMasuk = true;
                siswaYangMasuk = NISN;
                loginTercatat.add(NISN); 
                return true;
            }
        }
        return false; 
    }
    // Metode Main
    public static void main(String[] args) {
        // Menjalankan aplikasi
        SwingUtilities.invokeLater(() -> {
            HalamanLogin halamanLogin = new HalamanLogin();
            halamanLogin.setVisible(true);
        });
    }
}