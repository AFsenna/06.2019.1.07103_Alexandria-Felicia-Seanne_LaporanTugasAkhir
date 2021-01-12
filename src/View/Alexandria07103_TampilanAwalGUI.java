package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Alexandria07103_TampilanAwalGUI {
    JFrame Awalan = new JFrame();
    JLabel top,pertanyaan,bottom;
    JRadioButton sudah,belum;
    JButton next;
    private boolean cek;
    public Alexandria07103_TampilanAwalGUI(){
        Awalan.setSize(400, 280);
        Awalan.setLayout(null);
        Awalan.getContentPane().setBackground(Color.PINK);
        top = new JLabel("Welcome to Monster Arena !");
        top.setBounds(30, 5, 400, 50);
        top.setFont(new Font("Times New Roman",Font.BOLD,25));
        Awalan.add(top);
        pertanyaan = new JLabel("Sudah punya akun?");
        pertanyaan.setBounds(105, 70, 200, 30);
        pertanyaan.setFont(new Font("Times New Roman",Font.BOLD,20));
        Awalan.add(pertanyaan);
            sudah = new JRadioButton("Sudah");
        sudah.setBounds(60, 115, 100, 30);
        sudah.setBackground(Color.WHITE);
        Awalan.add(sudah);
        belum = new JRadioButton("Belum");
        belum.setBounds(200, 115, 100, 30);
        belum.setBackground(Color.WHITE);
        Awalan.add(belum);
        next = new JButton("next");
        next.setBounds(140, 160, 100, 30);
        next.setBackground(Color.RED);
        Awalan.add(next);
        bottom = new JLabel("(⁰□⁰ ) ( ⁰д⁰) (^-^ ) < `~´> (=^-^= ) (/* ^ *)/");
        bottom.setBounds(10,215,400,30);
        bottom.setFont(new Font("Consolas",Font.BOLD,15));
        Awalan.add(bottom);
        Awalan.setVisible(true);
        Awalan.setLocationRelativeTo(null);
        sudah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(sudah.isSelected()){
                    belum.setSelected(false);
                    cek=true;
                }
            }
        });
        belum.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(belum.isSelected()){
                    sudah.setSelected(false);
                    cek=false;
                }
            }
        });
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                boolean test = false;
                if(cek==true){
                    test = Alexandria07103_AllObjectController.akun.cekKosong(test);
                    if(test==false){
                    Alexandria07103_LoginGUI login = new Alexandria07103_LoginGUI();
                    Awalan.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Belum ada akun yang terdaftar","!!WARNING!!",JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    Alexandria07103_DaftarGUI daftar = new Alexandria07103_DaftarGUI();
                }
            }
        });
    }
}
