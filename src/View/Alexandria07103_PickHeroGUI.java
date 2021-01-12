package View;

import Controller.Alexandria07103_AllObjectModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Alexandria07103_PickHeroGUI {
    JFrame pickhero = new JFrame();
    JLabel top,nohero;
    JTextField noherotext;
    JTable listhero = new JTable();
    JButton back,use;
    JScrollPane scrollhero = new JScrollPane(listhero);
    public Alexandria07103_PickHeroGUI(){
        pickhero.setSize(650,500);
        pickhero.setLayout(null);
        pickhero.getContentPane().setBackground(Color.CYAN);
        top = new JLabel("Pick Hero");
        top.setBounds(220, 30, 200, 30);
        top.setFont(new Font("Timer New Roman",Font.BOLD,40));
        pickhero.add(top);
        scrollhero.setBounds(30, 80, 570, 200);
        
        listhero.setModel(listhero());
        pickhero.add(scrollhero);
        
        nohero = new JLabel("No Hero");
        nohero.setBounds(50, 290, 100, 30);
        pickhero.add(nohero);
        noherotext = new JTextField();
        noherotext.setBounds(100, 290, 100, 30);
        pickhero.add(noherotext);
        use = new JButton("use");
        use.setBounds(250, 290, 100, 30);
        use.setBackground(Color.GREEN);
        pickhero.add(use);
        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.red);
        pickhero.add(back);
        pickhero.setVisible(true);
        pickhero.setLocationRelativeTo(null);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                pickhero.dispose();
            }
        });
        use.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    
                    int nohero = Integer.parseInt(noherotext.getText());
                    listhero.setModel(listhero());
                    Alexandria07103_AllObjectController.akun.getDataAkun().setMainhero(nohero-1);
                    JOptionPane.showMessageDialog(null, "berhasil menggunakan hero", "information", JOptionPane.INFORMATION_MESSAGE);
                    Alexandria07103_AllObjectArena.ar.isitext();
                    pickhero.dispose();
                    
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "inputan salah", "!!WARNING!!", JOptionPane.INFORMATION_MESSAGE);
                }
            }   
        });
        listhero.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = listhero.getSelectedRow();
                noherotext.setText(listhero().getValueAt(i, 0).toString());
            }
        });
        
    }
    public DefaultTableModel listhero(){
        DefaultTableModel dtmlisthero = new DefaultTableModel();
        Object[] kolom ={"No Hero","Nama","Power","Health","Role"};
        dtmlisthero.setColumnIdentifiers(kolom);
        for(int i=0;i<Alexandria07103_AllObjectController.akun.getDataAkun().getLoop();i++){
            if(Alexandria07103_AllObjectController.game.getDataHero(i).getIndexAkun() == 
                    Alexandria07103_AllObjectController.akun.cekdataAkun(
                    Alexandria07103_AllObjectController.akun.getAkunEntityArrayList().get
                    (Alexandria07103_AllObjectController.akun.getIndexLogin()).getUsername(),
                    Alexandria07103_AllObjectController.akun.getAkunEntityArrayList().
                    get(Alexandria07103_AllObjectController.akun.getIndexLogin()).getPassword())){
                
            Object [] data = new Object[5];
            data[0] = Alexandria07103_AllObjectModel.heroModel.datahero().get(Alexandria07103_AllObjectModel.heroModel.getHeroEntityArrayList(i).getIndex()).getNoHero();
            data[1] = Alexandria07103_AllObjectModel.heroModel.datahero().get(Alexandria07103_AllObjectModel.heroModel.getHeroEntityArrayList(i).getIndex()).getNama();
            data[2] = Alexandria07103_AllObjectModel.heroModel.datahero().get(Alexandria07103_AllObjectModel.heroModel.getHeroEntityArrayList(i).getIndex()).getPower();
            data[3] = Alexandria07103_AllObjectModel.heroModel.datahero().get(Alexandria07103_AllObjectModel.heroModel.getHeroEntityArrayList(i).getIndex()).getHealth();
            data[4] = Alexandria07103_AllObjectModel.heroModel.datahero().get(Alexandria07103_AllObjectModel.heroModel.getHeroEntityArrayList(i).getIndex()).getRole();
            dtmlisthero.addRow(data);
            }
        }
        return dtmlisthero;
    }
}
