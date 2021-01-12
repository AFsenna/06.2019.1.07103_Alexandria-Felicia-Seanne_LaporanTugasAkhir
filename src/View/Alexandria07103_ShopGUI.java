package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;
public class Alexandria07103_ShopGUI {
    JFrame shop = new JFrame();
    JLabel top;
    JRadioButton gacha,buyP;
    JButton back,beli;
    JTextArea txttabel = new JTextArea();
    private static Random rand = new Random();
    private boolean cek;
    private int loop,loopP,idx,idxP;
    public Alexandria07103_ShopGUI(){
        shop.setSize(650,380);
        shop.setLayout(null);
        shop.getContentPane().setBackground(Color.LIGHT_GRAY);
        top = new JLabel("SHOP");
        top.setBounds(20, 20, 100, 30);
        top.setBackground(Color.getHSBColor(158, 68, 66));
        top.setFont(new Font("Times New Roman",Font.BOLD,30));
        shop.add(top);
        back = new JButton("BACK");
        back.setBounds(20, 300, 100, 30);
        back.setBackground(Color.getHSBColor(158, 68, 66));
        shop.add(back);
        beli = new JButton("BELI");
        beli.setBounds(130, 90, 100, 30);
        beli.setBackground(Color.getHSBColor(158, 68, 66));
        shop.add(beli);
        gacha = new JRadioButton("Spin Gacha");
        gacha.setBounds(20, 70, 100, 30);
        gacha.setBackground(Color.CYAN);
        shop.add(gacha);
        buyP = new JRadioButton("Buy Potion");
        buyP.setBounds(20, 110, 100, 30);
        buyP.setBackground(Color.CYAN);
        shop.add(buyP);
        txttabel.setBounds(300, 30, 300, 300);
        txttabel.setEditable(false);
        shop.add(txttabel);
        shop.setVisible(true);
        shop.setLocationRelativeTo(null);
        gacha.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(gacha.isSelected()){
                    buyP.setSelected(false);
                    cek=true;
                }
            }
        });
        buyP.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(buyP.isSelected()){
                    gacha.setSelected(false);
                    cek=false;
                }
            }
        });
        beli.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Alexandria07103_AllObjectController.game.dataToko();
                int uang;
                int cekdata = Alexandria07103_AllObjectController.akun.cekdataAkun(Alexandria07103_AllObjectController.akun.getDataAkun().getUsername(), Alexandria07103_AllObjectController.akun.getDataAkun().getPassword());
                if(cek==true){
                    Alexandria07103_AllObjectController.akun.login(Alexandria07103_AllObjectController.akun.getDataAkun().getUsername(), Alexandria07103_AllObjectController.akun.getDataAkun().getPassword());
                    if(Alexandria07103_AllObjectController.akun.getDataAkun().getUangR()<2500){
                       JOptionPane.showMessageDialog(null, "Uang anda tidak cukup untuk gacha", "!!WARNING!!", JOptionPane.INFORMATION_MESSAGE); 
                    }
                    else{
                        int hasil = rand.nextInt(100);
                        idx = hasil%4;
                        Alexandria07103_AllObjectController.game.getDataHero(loop).setIndex(idx);
                        Alexandria07103_AllObjectController.game.getDataHero(loop).setIndexAkun(cekdata); 
                        loop++;
                        Alexandria07103_AllObjectController.akun.getDataAkun().setLoop(loop);
                        uang = Alexandria07103_AllObjectController.akun.getDataAkun().getUangR()-2500;
                        Alexandria07103_AllObjectController.akun.getDataAkun().setUangR(uang);
                        txttabel.setText(datahero());
                        JOptionPane.showMessageDialog(null, "Sukses spin gacha", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    if(Alexandria07103_AllObjectController.akun.getDataAkun().getUangR()<1500){
                       JOptionPane.showMessageDialog(null, "Uang anda tidak cukup untuk beli potion","!!WARNING!!", JOptionPane.INFORMATION_MESSAGE); 
                    }
                    else{
                        int hasilP = rand.nextInt(100);
                        idxP = hasilP%4;
                        Alexandria07103_AllObjectController.game.getDataItem(loop).setIdx(idxP);
                        Alexandria07103_AllObjectController.game.getDataItem(loop).setIndexAkun(cekdata); 
                        loopP++;
                        Alexandria07103_AllObjectController.akun.getDataAkun().setLoopP(loopP);
                        uang = Alexandria07103_AllObjectController.akun.getDataAkun().getUangR()-1500;
                        Alexandria07103_AllObjectController.akun.getDataAkun().setUangR(uang);
                        txttabel.setText(datapotion());
                        JOptionPane.showMessageDialog(null, "Sukses membeli potion", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Alexandria07103_MenuAwalGUI menu = new Alexandria07103_MenuAwalGUI();
                shop.dispose();
            }
        });
    }
    String datahero(){
        String text = "Anda Mendapatkan hero "+Alexandria07103_AllObjectController.game.getDataHero(idx).getNama()+"\n"+
                      "\nBIODATA HERO\n\n Health : "+Alexandria07103_AllObjectController.game.getDataHero(idx).getHealth()+
                      "\n Power : "+Alexandria07103_AllObjectController.game.getDataHero(idx).getPower()+
                      "\n Role    : "+Alexandria07103_AllObjectController.game.getDataHero(idx).getRole()+"\n";
        return text;
    }
    String datapotion(){
        String text2 = "Potion yang didapat\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                     +"\n Potion  : "+Alexandria07103_AllObjectController.game.getDataItem(idxP).getNama()
                     +"\n Atribut  : + Health "+Alexandria07103_AllObjectController.game.getDataItem(idxP).getHealth()
                     +"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        return text2;
    }
}
