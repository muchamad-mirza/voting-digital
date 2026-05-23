// Paket
package votingdigital;
// Pustaka 
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
// Superklas
public class Method {
    // Metode Public Static - Memuat Gambar 
    public static ImageIcon memuatGambar(String lokasi, int width, int height) {
        ImageIcon gambar = new ImageIcon(lokasi);
        // --> Get Object
        Image gambarAsli = gambar.getImage();
        // --> Scalling Gambar
        Image skalaGambar = gambarAsli.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        // --> Kelas Image Icon Lebih Sederhana
        return new ImageIcon(skalaGambar);
    }
    // Metode (publik) - Membuat JLabel + _Allignment - Informasi 
    public static JLabel membuatInformasi(String informasi,int allignment, int x, int y, int width, int height, java.awt.Color warna) {
        JLabel label = new JLabel(informasi);
        label.setBounds(x, y, width, height);
        label.setForeground(warna);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        return label;
    } 
    // Metode (publik) - Membuat JLabel + _Allignment - Informasi
    public static JLabel membuatInformasi1(String informasi, int x, int y, int width, int height, java.awt.Color warna) {
        JLabel label1 = new JLabel(informasi);
        label1.setBounds(x, y, width, height);
        label1.setForeground(warna);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        return label1;
    }
    // Metode (publik) - Membuat Tombol
    public static JButton membuatTombol(String nama, int x, int y, int width, int height) {
        JButton button = new JButton(nama);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        return button;
    }
}
