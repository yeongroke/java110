package mytest01;

public class StoreFactory {
    public Store create(String goods) {
        
        Store s = new Store();
        
        switch(goods) {
        case "ramen":
            s.setGoods("ramen");
            s.setCount(100);
            s.setLocati("s1");
        break;
            
        case "meat":
            s.setGoods("meat");
            s.setCount(40);
            s.setLocati("s2");
        break;
        
        case "juice":
            s.setGoods("juice");
            s.setCount(500);
            s.setLocati("s3");
        break;
        
        case "chicken":
            s.setGoods("chicken");
            s.setCount(20);
            s.setLocati("s4");
        break;
        
        default:
            s.setGoods("bye");
            s.setCount(0);
            s.setLocati("noooooooo");
        }
        
        return s;
    }
}
