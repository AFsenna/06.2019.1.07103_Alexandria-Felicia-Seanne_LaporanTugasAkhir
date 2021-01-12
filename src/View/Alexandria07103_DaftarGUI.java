package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Alexandria07103_DaftarGUI {
    JFrame daftar = new JFrame();
    JLabel top,labelnama,labelumur,labelpassword,labelemail;
    JTextField textnama,textumur,textpassword,textemail;
    JButton reg;
    public Alexandria07103_DaftarGUI(){
        daftar.setSize(420,370);
        daftar.setLayout(null);
        daftar.getContentPane().setBackground(Color.CYAN);
        top = new JLabel("Ayo buat akunnyaa~~");
        top.setBounds(50, 10, 600, 50);
        top.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        daftar.add(top);
        labelnama = new JLabel("Username");
        labelnama.setFont(new Font("Times New Roman",Font.BOLD,18));
        labelnama.setBounds(30, 90, 100, 30);
        daftar.add(labelnama);
        textnama = new JTextField();
        textnama.setBounds(120, 90, 200, 30);
        daftar.add(textnama);
        labelpassword = new JLabel("Password");
        labelpassword.setFont(new Font("Times New Roman",Font.BOLD,18));
        labelpassword.setBounds(30, 130, 100, 30);
        daftar.add(labelpassword);
        textpassword = new JPasswordField();
        textpassword.setBounds(120, 130, 200, 30);
        daftar.add(textpassword);
        labelumur = new JLabel("Umur");
        labelumur.setFont(new Font("Times New Roman",Font.BOLD,18));
        labelumur.setBounds(30, 170, 100, 30);
        daftar.add(labelumur);
        textumur = new JTextField();
        textumur.setBounds(120, 170, 200, 30);
        daftar.add(textumur);
        labelemail = new JLabel("Email");
        labelemail.setFont(new Font("Times New Roman",Font.BOLD,18));
        labelemail.setBounds(30, 210, 100, 30);
        daftar.add(labelemail);
        textemail = new JTextField();
        textemail.setBounds(120, 210, 200, 30);
        daftar.add(textemail);
        reg = new JButton("Daftar");
        reg.setBounds(160, 260, 100, 40);
        reg.setBackground(Color.GREEN);
        daftar.add(reg);
        daftar.setVisible(true);
        daftar.setLocationRelativeTo(null);
        reg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                String nama = textnama.getText();
                String email = textemail.getText();
                int umur = Integer.parseInt(textumur.getText());
                String password = textpassword.getText();
                Alexandria07103_AllObjectController.akun.insert(nama, password, umur, email, 5000);
                Alexandria07103_AllObjectController.akun.insert2(0,0,-1,-1);
                JOptionPane.showMessageDialog(null, "Registrasi sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                kosong();daftar.dispose();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Format Pengisian Salah\nRegistrasi Gagal", "!!WARNING!!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    
    void kosong(){
    textnama.setText(null);
    textpassword.setText(null);
    textumur.setText(null);
    textemail.setText(null);
    }
}
