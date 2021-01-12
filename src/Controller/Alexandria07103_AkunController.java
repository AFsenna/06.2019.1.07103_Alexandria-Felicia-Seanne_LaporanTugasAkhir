package Controller;
import Entity.Alexandria07103_AkunEntity;
import java.util.ArrayList;
public class Alexandria07103_AkunController {
    int indexlogin=0;
    
    public Alexandria07103_AkunController() {
    }
    
    public Alexandria07103_AkunEntity getDataAkun() {
        return Alexandria07103_AllObjectModel.akunModel.getAkunEntityArrayList(indexlogin);
    }
    
    public void insert(String nama, String password, int umur, String email,int uangR) {
        Alexandria07103_AkunEntity akun = new Alexandria07103_AkunEntity();
        akun.setEmail(email);
        akun.setUsername(nama);
        akun.setUangR(uangR);
        akun.setPassword(password);
        akun.setUmur(umur);
        Alexandria07103_AllObjectModel.akunModel.insert(akun);
    }
    
    public void insert2(int loop,int loopP, int mainhero,int atributP){
        Alexandria07103_AllObjectModel.akunModel.insert(new Alexandria07103_AkunEntity(loop,loopP,mainhero,atributP));
    }
    
    public int cekdataAkun(String nama,String password){
        int cekdata = Alexandria07103_AllObjectModel.akunModel.cekdata(nama, password);
        return cekdata;
    }
    
    public void login(String nama,String password){
        indexlogin = Alexandria07103_AllObjectModel.akunModel.cekdata(nama, password);
    }
    
    public int getIndexLogin(){
        return indexlogin;
    }
    
    public void delete(){
        Alexandria07103_AllObjectModel.akunModel.delete(indexlogin);
    }
    
    public boolean cekKosong(boolean cek){
        boolean cekakun = Alexandria07103_AllObjectModel.akunModel.cekempty(cek);
        return cekakun;
    }
        
    public ArrayList<Alexandria07103_AkunEntity> getAkunEntityArrayList() {
        return Alexandria07103_AllObjectModel.akunModel.getAkunn();
    }
}
