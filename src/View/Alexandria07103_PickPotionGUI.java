package View;

import Controller.Alexandria07103_AllObjectModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Alexandria07103_PickPotionGUI {
    JFrame pickpotion = new JFrame();
    JLabel top,health;
    JTextField jmlhhealth;
    JTable listitem = new JTable();
    JButton back,use;
    JScrollPane scrollitem = new JScrollPane(listitem);
    public Alexandria07103_PickPotionGUI(){
        pickpotion.setSize(650,500);
        pickpotion.setLayout(null);
        pickpotion.getContentPane().setBackground(Color.CYAN);
        top = new JLabel("Pick Potion");
        top.setBounds(220, 30, 300, 30);
        top.setFont(new Font("Timer New Roman",Font.BOLD,40));
        pickpotion.add(top);
        scrollitem.setBounds(30, 80, 570, 200);
        listitem.setModel(listitem());
        pickpotion.add(scrollitem);
        health = new JLabel("Ingin menambah berapa health?");
        health.setBounds(30, 290, 200, 30);
        pickpotion.add(health);
        jmlhhealth = new JTextField();
        jmlhhealth.setBounds(230, 290, 100, 30);
        pickpotion.add(jmlhhealth);
        use = new JButton("use");
        use.setBounds(230, 330, 80, 30);
        use.setBackground(Color.GREEN);
        pickpotion.add(use);
        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.red);
        pickpotion.add(back);
        pickpotion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pickpotion.setVisible(true);
        pickpotion.setLocationRelativeTo(null);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                pickpotion.dispose();
            }
        });
        use.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    int health = Integer.parseInt(jmlhhealth.getText());
                    listitem.setModel(listitem());
                    Alexandria07103_AllObjectController.akun.getDataAkun().setAtributP(health);
                    JOptionPane.showMessageDialog(null, "berhasil menggunakan potion", "information", JOptionPane.INFORMATION_MESSAGE);
                    Alexandria07103_AllObjectController.game.getDataHero(Alexandria07103_AllObjectController.akun.getDataAkun().getMainhero()).setHealth(health);
                    pickpotion.dispose();
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "inputan salah", "!!WARNING!!", JOptionPane.INFORMATION_MESSAGE);
                }
            }   
        });
        listitem.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = listitem.getSelectedRow();
                jmlhhealth.setText(listitem().getValueAt(i, 0).toString());
            }
        });
    }
    public DefaultTableModel listitem(){
        DefaultTableModel dtmlistitem = new DefaultTableModel();
        Object[] kolom ={"Potion","Atribut"};
        dtmlistitem.setColumnIdentifiers(kolom);
        for(int i=0;i<Alexandria07103_AllObjectController.akun.getDataAkun().getLoopP();i++){
            if(Alexandria07103_AllObjectController.game.getDataItem(i).getIndexAkun() == 
                    Alexandria07103_AllObjectController.akun.cekdataAkun(
                    Alexandria07103_AllObjectController.akun.getAkunEntityArrayList().get
                    (Alexandria07103_AllObjectController.akun.getIndexLogin()).getUsername(),
                    Alexandria07103_AllObjectController.akun.getAkunEntityArrayList().
                    get(Alexandria07103_AllObjectController.akun.getIndexLogin()).getPassword())){
                
            Object [] data = new Object[2];
            data[0] = Alexandria07103_AllObjectModel.itemModel.dataitem().get(Alexandria07103_AllObjectModel.heroModel.getHeroEntityArrayList(i).getIndex()).getNama();
            data[1] = "health + "+Alexandria07103_AllObjectModel.itemModel.dataitem().get(Alexandria07103_AllObjectModel.heroModel.getHeroEntityArrayList(i).getIndex()).getHealth();
            dtmlistitem.addRow(data);
            }
        }
        return dtmlistitem;
    }
}
