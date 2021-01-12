package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Alexandria07103_AkunGUI {
    JFrame akun = new JFrame();
    JButton akunlist,hero,item,back;
    JLabel top;
    JTextArea tabel = new JTextArea();
    public Alexandria07103_AkunGUI(){
        akun.setSize(650,390);
        akun.setLayout(null);
        akun.getContentPane().setBackground(Color.gray);
        top = new JLabel("Data Pada Akunmu");
        top.setBounds(20, 20, 300, 30);
        top.setBackground(Color.getHSBColor(158, 68, 66));
        top.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        akun.add(top);
        akunlist = new JButton("Data Akun");
        akunlist.setBounds(70, 120, 120, 30);
        akunlist.setBackground(Color.RED);
        akun.add(akunlist);
        hero = new JButton("Data Hero");
        hero.setBounds(70, 160, 120, 30);
        hero.setBackground(Color.YELLOW);
        akun.add(hero);
        item = new JButton("Data Item");
        item.setBounds(70, 200, 120, 30);
        item.setBackground(Color.GREEN);
        akun.add(item);
        back = new JButton("back");
        back.setBounds(20, 310, 100, 30);
        back.setBackground(Color.MAGENTA);
        akun.add(back);
        tabel.setBounds(300, 30, 300, 300);
        akun.add(tabel);
        akun.setVisible(true);
        akun.setLocationRelativeTo(null);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Alexandria07103_MenuAwalGUI menu = new Alexandria07103_MenuAwalGUI();
                akun.dispose();
            }
        });
        akunlist.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                tabel.setText(dataakun());
            }
        });
        hero.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                int cekdata = Alexandria07103_AllObjectController.akun.cekdataAkun(Alexandria07103_AllObjectController.akun.getDataAkun().getUsername(),Alexandria07103_AllObjectController.akun.getDataAkun().getPassword());
                if(Alexandria07103_AllObjectController.akun.getDataAkun().getLoop()==0){
                    tabel.setText("Belum punya hero");
                }
                    System.out.println(Alexandria07103_AllObjectController.akun.getDataAkun().getLoop());
                for(int i=0;i<Alexandria07103_AllObjectController.akun.getDataAkun().getLoop();i++){
                    if(Alexandria07103_AllObjectController.game.getDataHero(i).getIndexAkun()==cekdata)
                        tabel.setText(datahero(Alexandria07103_AllObjectController.game.getDataHero(i).getIndex()));
                    }
                }catch(Exception e){
                    tabel.setText("Belum punya hero");
                }
            }
        });
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                int cekdata = Alexandria07103_AllObjectController.akun.cekdataAkun(Alexandria07103_AllObjectController.akun.getDataAkun().getUsername(),Alexandria07103_AllObjectController.akun.getDataAkun().getPassword());
                if(Alexandria07103_AllObjectController.akun.getDataAkun().getLoopP()==0){
                    tabel.setText("Belum punya item");
                }
                for(int i=0;i<Alexandria07103_AllObjectController.akun.getDataAkun().getLoopP();i++){
                    if(Alexandria07103_AllObjectController.game.getDataItem(i).getIndexAkun()==cekdata)
                        tabel.setText(dataitem(Alexandria07103_AllObjectController.game.getDataItem(i).getIdx()));
                    }
                }catch(Exception e){
                    tabel.setText("Belum punya item");
                }
            }
        });
    }
    String dataakun(){
        String dataakun = "\tData akun\n"+
                          "\n Username\t: "+Alexandria07103_AllObjectController.akun.getDataAkun().getUsername() +
                          "\n Password\t: "+Alexandria07103_AllObjectController.akun.getDataAkun().getPassword() +
                          "\n Email\t: "+Alexandria07103_AllObjectController.akun.getDataAkun().getEmail() +
                          "\n Uang\t: "+Alexandria07103_AllObjectController.akun.getDataAkun().getUangR();
        return dataakun;
    }
    String datahero(int index){
        String listhero = "\tHero yang dimiliki\n\n" +
                          "Nama hero\t:"+Alexandria07103_AllObjectController.game.getDataHero(index).getNama()+
                          "\n Health\t: "+Alexandria07103_AllObjectController.game.getDataHero(index).getHealth()+
                          "\n Power\t: "+Alexandria07103_AllObjectController.game.getDataHero(index).getPower()+
                          "\n Role\t: "+Alexandria07103_AllObjectController.game.getDataHero(index).getRole()+"\n";
        return listhero;
    }
    String dataitem(int idx){
        String listitem = "\titem yang dimiliki\n\n"+
                          " Potion\t: "+Alexandria07103_AllObjectController.game.getDataItem(idx).getNama()+
                          "\n Atribut\t: + Health "+Alexandria07103_AllObjectController.game.getDataItem(idx).getHealth();
        return listitem;
    }
}
