package Controller;

import Entity.Alexandria07103_HeroEntity;
import Entity.Alexandria07103_ItemEntity;
import Entity.Alexandria07103_MonsterEntity;
import View.Alexandria07103_AllObjectController;
import javax.swing.table.DefaultTableModel;

public class Alexandria07103_GameController {

    public Alexandria07103_GameController() {
    }
    
    public void dataToko(){
        int noHero [] = {1,2,3,4};
        String namaHero[] = {"Felicia","Seanne","Athanasius","Dextera"};
        String roleHero [] = {"Mage","Assassin","Marksman","Support"};
        int healthHero [] = {3100,3400,4300,3400};
        int powerHero [] = {2510,2755,2600,2498};
        String namaP[] = {"A","B","C","D"};
        int healthP[] = {500,600,300,400};
        for(int i = 0; i<4;i++){
            Alexandria07103_AllObjectModel.heroModel.insert(new Alexandria07103_HeroEntity(namaHero[i], healthHero[i], powerHero[i],roleHero[i],noHero[i]));
            Alexandria07103_AllObjectModel.itemModel.insert(new Alexandria07103_ItemEntity(namaP[i],healthP[i],0,1500));
        }  
    }
    
    public void dataArena(){
        String namaM[] = {"bubu","baba","bibi","bobo"};
        String karakterM[] = {" ↜(╰ •ω•)╯ψ "," Ψ(☆ｗ☆)Ψ "," (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ "," ◥(ฅº￦ºฅ)◤ "};
        int powerM[] = {2222,2889,1500,1780};
        int healthM[] = {3200,3470,4500,3000};
        int uangM[] = {1500,1500,1400,1300};
        for(int i=0;i<namaM.length;i++){
            Alexandria07103_AllObjectModel.monsterModel.insert(new Alexandria07103_MonsterEntity(namaM[i],powerM[i],healthM[i],uangM[i],karakterM[i]));
        }
    }
    public Alexandria07103_HeroEntity getDataHero(int index) {
        return Alexandria07103_AllObjectModel.heroModel.getHeroEntityArrayList(index);
    }
    public void setstatsHero(){
        Alexandria07103_AllObjectModel.heroModel.setstats();
    }
    public Alexandria07103_MonsterEntity showMonster(int index) {
        return Alexandria07103_AllObjectModel.monsterModel.showData(index);
    }
    public Alexandria07103_MonsterEntity getDataMonster(int index) {
        return Alexandria07103_AllObjectModel.monsterModel.getMonsteraEntityArrayList(index);
    }
    public void setstatsMonster(){
        Alexandria07103_AllObjectModel.monsterModel.setstats();
    }
    public Alexandria07103_ItemEntity getDataItem(int index) {
        return Alexandria07103_AllObjectModel.itemModel.getItemEntityArrayList(index);
    }
     
   
}
