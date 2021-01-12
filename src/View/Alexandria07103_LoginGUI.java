package View;

import Controller.Alexandria07103_AllObjectModel;
import Controller.Alexandria07103_AkunController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class Alexandria07103_LoginGUI {
    JFrame akun = new JFrame();
    JLabel top,labelnama,labelpassword;
    JTextField textnama,textpassword;
    JButton check;
    public Alexandria07103_LoginGUI(){
        akun.setSize(370, 250);
        akun.setLayout(null);
        akun.getContentPane().setBackground(Color.CYAN);
        top = new JLabel("login dulu yaa~");
        top.setBounds(80, 5, 300, 50);
        top.setFont(new Font("Times New Roman",Font.BOLD,30));
        akun.add(top);
        labelnama = new JLabel("Username");
        labelnama.setFont(new Font("Times New Roman",Font.BOLD,18));
        labelnama.setBounds(30, 60, 100, 30);
        akun.add(labelnama);
        textnama = new JTextField();
        textnama.setBounds(120, 60, 200, 30);
        akun.add(textnama);
        labelpassword = new JLabel("Password");
        labelpassword.setFont(new Font("Times New Roman",Font.BOLD,18));
        labelpassword.setBounds(30, 100, 100, 30);
        akun.add(labelpassword);
        textpassword = new JPasswordField();
        textpassword.setBounds(120, 100, 200, 30);
        akun.add(textpassword);
        check = new JButton("login");
        check.setBounds(135, 150, 100, 40);
        check.setBackground(Color.GREEN);
        akun.add(check);
        akun.setVisible(true);
        akun.setLocationRelativeTo(null);
        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    Alexandria07103_AllObjectController.akun.login(textnama.getText(), textpassword.getText());
                    JOptionPane.showMessageDialog(null, "Selamat datang "+Alexandria07103_AllObjectController.akun.getAkunEntityArrayList().get(Alexandria07103_AllObjectController.akun.getIndexLogin()).getUsername()+" ~~","information", JOptionPane.INFORMATION_MESSAGE);
                    akun.dispose();
                    Alexandria07103_MenuAwalGUI menu = new Alexandria07103_MenuAwalGUI();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Username atau Password salah", "!!WARNING!!", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });
    }
    void kosong(){
        textnama.setText(null);
        textpassword.setText(null);
    }
}
