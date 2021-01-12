package Model;
import Entity.Alexandria07103_HeroEntity;
import java.util.ArrayList;
public class Alexandria07103_HeroModel implements Alexandria07103_CharacterGameInterfaces{
    private ArrayList <Alexandria07103_HeroEntity> heroEntityArrayList;
    
    public Alexandria07103_HeroModel() {
        heroEntityArrayList = new ArrayList <Alexandria07103_HeroEntity>();
    }
    
    public void insert(Alexandria07103_HeroEntity hero){
        heroEntityArrayList.add(hero);}
    
    public Alexandria07103_HeroEntity getHeroEntityArrayList(int index){
        return heroEntityArrayList.get(index);
    }
    
    public void setstats(){
        heroEntityArrayList.get(0).setHealth(3100);
        heroEntityArrayList.get(1).setHealth(3400);
        heroEntityArrayList.get(2).setHealth(4300);
        heroEntityArrayList.get(3).setHealth(3400);
    }
    
    public ArrayList <Alexandria07103_HeroEntity> datahero(){
        return heroEntityArrayList;
    } 
}