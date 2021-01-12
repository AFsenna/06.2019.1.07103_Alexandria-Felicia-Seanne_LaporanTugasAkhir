package Model;

import Entity.Alexandria07103_ItemEntity;
import java.util.ArrayList;

public class Alexandria07103_ItemModel {
    private ArrayList <Alexandria07103_ItemEntity> itemEntityArrayList;

    public Alexandria07103_ItemModel() {
        itemEntityArrayList = new ArrayList <Alexandria07103_ItemEntity>();
    }
    public void insert(Alexandria07103_ItemEntity itemEntity){
        itemEntityArrayList.add(itemEntity);
    }
    public Alexandria07103_ItemEntity getItemEntityArrayList(int index){
        return itemEntityArrayList.get(index);
    }
    public ArrayList <Alexandria07103_ItemEntity> dataitem(){
        return itemEntityArrayList;
    } 
}
