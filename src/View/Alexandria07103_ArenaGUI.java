package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class Alexandria07103_ArenaGUI {
    JFrame arena = new JFrame();
    JLabel top;
    JButton back,start;
    JButton lawan,use,shop,nyerah,change;
    JTextArea txtarea1 = new JTextArea();
    JTextArea txtarea2 = new JTextArea();
    JTextArea txtarea3 = new JTextArea();
    JScrollPane area3;
    private String attack="";
    private static Random rand = new Random();
    private int no,healthM,powerM,darahM,uangNew,powerH,darahH,healthH;
    public Alexandria07103_ArenaGUI(){
        arena.setSize(820,650);
        arena.setLayout(null);
        arena.getContentPane().setBackground(Color.YELLOW);
        top = new JLabel("ARENA");
        top.setBounds(300, 10, 200, 50);
        top.setBackground(Color.getHSBColor(158, 68, 66));
        top.setFont(new Font("Comic Sans MS",Font.BOLD,35));
        arena.add(top);
        txtarea1.setBounds(20, 80, 260, 130);
        txtarea1.setEditable(false);
        arena.add(txtarea1);
        txtarea2.setBounds(20, 210, 260, 130);
        txtarea2.setEditable(false);
        arena.add(txtarea2);
        area3=new JScrollPane(txtarea3);
        area3.setBounds(450, 80, 330, 400);
        txtarea3.setEditable(false);
        arena.add(area3);
        start = new JButton("start");
        start.setBounds(105, 350, 100, 30);
        start.setBackground(Color.GREEN);
        arena.add(start);
        back = new JButton("BACK");
        back.setBounds(20, 560, 100, 30);
        back.setBackground(Color.getHSBColor(158, 68, 66));
        arena.add(back);
        lawan = new JButton("Attack");
        lawan.setBounds(300, 100, 120, 30);
        lawan.setBackground(Color.RED);
        arena.add(lawan);
        use = new JButton("Potion");
        use.setBounds(300, 140, 120, 30);
        use.setBackground(Color.GREEN);
        arena.add(use);
        nyerah = new JButton("Surrender");
        nyerah.setBounds(300, 180, 120, 30);
        nyerah.setBackground(Color.CYAN);
        arena.add(nyerah);
        change = new JButton("Change hero");
        change.setBounds(300, 220, 120, 30);
        change.setBackground(Color.PINK);
        arena.add(change);
        arena.setLocationRelativeTo(null);
        arena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Alexandria07103_MenuAwalGUI menu = new Alexandria07103_MenuAwalGUI();
                Alexandria07103_AllObjectController.game.setstatsMonster();
                Alexandria07103_AllObjectController.game.setstatsHero();
                arena.dispose();
            }
        });
        
        lawan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Alexandria07103_AllObjectController.game.dataArena();
                healthM = Alexandria07103_AllObjectController.game.showMonster(no).getHealth();
                powerM = Alexandria07103_AllObjectController.game.showMonster(no).getPower();
                healthH = Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).getHealth();
                powerH = Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).getPower();
                darahM = healthM - powerH;
                darahH = healthH - powerM;
                if(darahM>0){
                    Alexandria07103_AllObjectController.game.getDataMonster(no).setHealth(darahM);
                }
                else if(darahM <= 0){
                    uangNew = Alexandria07103_AllObjectController.akun.getDataAkun().getUangR() + Alexandria07103_AllObjectController.game.showMonster(no).getUangM();
                    Alexandria07103_AllObjectController.akun.getDataAkun().setUangR(uangNew);
                    Alexandria07103_AllObjectController.game.setstatsMonster();
                    Alexandria07103_AllObjectController.game.setstatsHero();
                    txtarea1.setText(null);
                    txtarea2.setText(null);
                    txtarea3.setText(null);
                    JOptionPane.showMessageDialog(null, "Monster kalah", "information", JOptionPane.INFORMATION_MESSAGE);
                    Alexandria07103_MenuAwalGUI menu = new Alexandria07103_MenuAwalGUI();
                    arena.dispose();
                }
                else{
                    darahH = Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).getHealth() - powerM;
                    if(darahH>0){
                        Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).setHealth(darahH);
                    }
                    else if(darahH <=0){
                        Alexandria07103_AllObjectController.game.setstatsMonster();
                        Alexandria07103_AllObjectController.game.setstatsHero();
                        JOptionPane.showMessageDialog(null, "Hero kalah", "information", JOptionPane.INFORMATION_MESSAGE);
                        Alexandria07103_MenuAwalGUI menu = new Alexandria07103_MenuAwalGUI();
                        arena.dispose();
                    }
                }
                attack+="\n\t"+Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).getNama()+" VS "+Alexandria07103_AllObjectController.game.showMonster(no).getNama()
                + "\t\nHealth hero     : "+darahH+"\t\nPower hero      : "+powerH
                +"\t\nHealth Monster  : "+healthM +"\nPower Monster   : "+powerM
                +"\t\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
                txtarea3.setText(attack);                
            }
        });
        
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Alexandria07103_AllObjectController.game.dataArena();
                int hasil = rand.nextInt(100);
                no = hasil%4;
                txtarea1.setText(datamonster());
                JOptionPane.showMessageDialog(null, "Pilihlah hero yang ingin digunakan", "Information", JOptionPane.INFORMATION_MESSAGE);
                Alexandria07103_PickHeroGUI pick = new Alexandria07103_PickHeroGUI();
                
            }
        });
        nyerah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JOptionPane.showMessageDialog(null, "losers (>y <)", "", JOptionPane.INFORMATION_MESSAGE);
                arena.dispose();
            }
        });
        use.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Alexandria07103_PickPotionGUI pickp =new Alexandria07103_PickPotionGUI();
            }
        });
        change.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Alexandria07103_PickHeroGUI pick = new Alexandria07103_PickHeroGUI();
            }
        });
        
    }
    String datamonster(){
        String datamonster = "\t"+Alexandria07103_AllObjectController.game.showMonster(no).getKarakterM()+"\n\t"
                             +Alexandria07103_AllObjectController.game.showMonster(no).getNama()+" Has Arrived\n"
                             +"\n\t------STATS------\n"
                             +"\tPower  : "+Alexandria07103_AllObjectController.game.showMonster(no).getPower()
                             +"\n\tHealth : "+Alexandria07103_AllObjectController.game.showMonster(no).getHealth()
                             +"\n\n######################################\n";
        return datamonster;
    }
    String datahero(){
        String datahero = "\t---STATS HERO---"+
                      "\n\tNama  "+Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).getNama()+"\n"+
                      "\n\tHealth : "+Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).getHealth()+
                      "\n\tPower : "+Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).getPower()+
                      "\n\tRole    : "+Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).getRole()+"\n";
        return datahero;
    }
    public void isitext(){
        txtarea2.setText(datahero());
    }
}
