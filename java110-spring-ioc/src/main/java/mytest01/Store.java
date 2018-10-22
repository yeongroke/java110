package mytest01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Store {
    
    private int count;
    private String locati;
    private String goods;
    
    private List<String> goodname;
    
    private Comp comp;
    
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getLocati() {
        return locati;
    }
    public void setLocati(String locati) {
        this.locati = locati;
    }
    public String getGoods() {
        return goods;
    }
    public void setGoods(String goods) {
        this.goods = goods;
    }
    
    public Comp getComp() {
        return comp;
    }
    @Autowired
    public void setComp(Comp comp) {
        this.comp = comp;
    }
    
    public List<String> getGoodname() {
        return goodname;
    }
    public void setGoodname(List<String> goodname) {
        this.goodname = goodname;
    }
    @Override
    public String toString() {
        return "Store [count=" + count + ", locati=" + locati + ", goods=" + goods + ", goodname=" + goodname
                + ", comp=" + comp + "]";
    }
}
