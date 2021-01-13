package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Alexandria07103_MenuAwalGUI {
    JFrame menu = new JFrame();
    JLabel top;
    JRadioButton shop,pick,akun,exit;
    JButton go;
    private int letsgo;
    public Alexandria07103_MenuAwalGUI(){
        menu.setSize(370, 300);
        menu.setLayout(null);
        menu.getContentPane().setBackground(Color.getHSBColor(30, 51, 60));
        top = new JLabel("Mau kemana?");
        top.setBounds(50, 10, 600, 50);
        top.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        menu.add(top);
        shop = new JRadioButton("SHOP");
        shop.setBounds(30, 80, 100, 30);
        shop.setBackground(Color.getHSBColor(158, 68, 66));
        menu.add(shop);
        pick = new JRadioButton("ARENA");
        pick.setBounds(30, 120, 100, 30);
        pick.setBackground(Color.getHSBColor(158, 68, 66));
        menu.add(pick);
        akun = new JRadioButton("AKUN");
        akun.setBounds(30, 160, 100, 30);
        akun.setBackground(Color.getHSBColor(158, 68, 66));
        menu.add(akun);
        exit = new JRadioButton("EXIT");
        exit.setBounds(30, 200, 100, 30);
        exit.setBackground(Color.getHSBColor(158, 68, 66));
        menu.add(exit);
        go = new JButton("GO");
        go.setBounds(160, 130, 100, 30);
        go.setBackground(Color.getHSBColor(164, 44, 60));
        menu.add(go);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        shop.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(shop.isSelected()){
                pick.setSelected(false);
                akun.setSelected(false);
                exit.setSelected(false);
                letsgo=1;
                }
            }
        });
        pick.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(pick.isSelected()){
                shop.setSelected(false);
                akun.setSelected(false);
                exit.setSelected(false);
                letsgo=2;
                }
            }
        });
        akun.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(akun.isSelected()){
                pick.setSelected(false);
                shop.setSelected(false);
                exit.setSelected(false);
                letsgo=3;
                }
            }
        });
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(exit.isSelected()){
                pick.setSelected(false);
                akun.setSelected(false);
                shop.setSelected(false);
                letsgo=4;
                }
            }
        });
        go.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(letsgo==1){
                    Alexandria07103_ShopGUI shop = new Alexandria07103_ShopGUI();
                    menu.dispose();
                }
                else if(letsgo==2){
                    if(Alexandria07103_AllObjectController.akun.getDataAkun().getLoop()==0){
                        JOptionPane.showMessageDialog(null, "Tidak memiliki hero untuk masuk ke arena", "!!WARNING!!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        Alexandria07103_AllObjectArena.ar.arena.setVisible(true);
                        menu.dispose();
                    }
                }
                else if(letsgo==3){
                    Alexandria07103_AkunGUI akun = new Alexandria07103_AkunGUI();
                    menu.dispose();
                }
                else if(letsgo==4){
                    Alexandria07103_ExitGUI exit = new Alexandria07103_ExitGUI();
                    menu.dispose();
                }
            }
        });
    }
}
