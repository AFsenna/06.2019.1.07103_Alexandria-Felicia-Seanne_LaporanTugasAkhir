package View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Alexandria07103_ExitGUI {
    JFrame exit = new JFrame();
    JButton kembali,hapus,keluar;
    public Alexandria07103_ExitGUI(){
        exit.setSize(325,170);
        exit.setLayout(null);
        exit.getContentPane().setBackground(Color.BLACK);
        kembali = new JButton("Tampilan awal");
        kembali.setBounds(20, 10, 120, 30);
        kembali.setBackground(Color.RED);
        exit.add(kembali);
        hapus = new JButton("Hapus akun");
        hapus.setBounds(110, 50, 120, 30);
        hapus.setBackground(Color.YELLOW);
        exit.add(hapus);
        keluar = new JButton("Keluar");
        keluar.setBounds(190, 90, 100, 30);
        keluar.setBackground(Color.GREEN);
        exit.add(keluar);
        exit.setVisible(true);
        exit.setLocationRelativeTo(null);
        exit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                exit.dispose();
                Alexandria07103_TampilanAwalGUI gui = new Alexandria07103_TampilanAwalGUI();
            }
        });
        hapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    Alexandria07103_AllObjectController.akun.delete();
                    JOptionPane.showMessageDialog(null, "Akun sudah terhapus", "information", JOptionPane.INFORMATION_MESSAGE);
                    exit.dispose();
                    Alexandria07103_TampilanAwalGUI gui = new Alexandria07103_TampilanAwalGUI();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "error", "!!WARNING!!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        keluar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                exit.dispose();
            }
        });
    }
}
