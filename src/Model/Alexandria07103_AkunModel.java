package Model;
import Entity.Alexandria07103_AkunEntity;
import java.util.ArrayList;
public class Alexandria07103_AkunModel {
    private ArrayList <Alexandria07103_AkunEntity> akunEntityArrayList;
    public Alexandria07103_AkunModel(){
        akunEntityArrayList = new ArrayList <Alexandria07103_AkunEntity>();
    }
    
    public void insert (Alexandria07103_AkunEntity penggunaEntity){
        akunEntityArrayList.add(penggunaEntity);
    }
    
    public int cekdata(String nama, String password){   
        int loop = 0;
        for (Alexandria07103_AkunEntity akunEntity : akunEntityArrayList) {
            if (akunEntity.getUsername().equals(nama) && akunEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    
    public Alexandria07103_AkunEntity getAkunEntityArrayList(int index){
        return akunEntityArrayList.get(index);
    }
    public ArrayList<Alexandria07103_AkunEntity> getAkunn() {
        return akunEntityArrayList;
    }
    
    public void delete(int index){
        akunEntityArrayList.remove(index);
    }
    
    public boolean cekempty(boolean cek){
        if(akunEntityArrayList.isEmpty()){
            cek=true;
        }
        else{
            cek=false;
        }
        return cek;
    }
}
