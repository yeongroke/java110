package mytest01;

import java.sql.Date;

public class Comp {
    private String name;
    private String work;
    private int pay;
    private Date join;
    
    public Comp() {
        System.out.println("comp() 호출됨");
    }
    
    public Comp(String name, String work) {
        System.out.println("name,work타입 호출");
        this.name=name;
        this.work=work;
    }
    
    public Comp(String name, int pay) {
        this.name=name;
        this.pay=pay;
    }
    
    public Comp(int pay, String work) {
        this.work=work;
        this.pay=pay;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWork() {
        return work;
    }
    public void setWork(String work) {
        this.work = work;
    }
    public int getPay() {
        return pay;
    }
    public void setPay(int pay) {
        this.pay = pay;
    }
    public Date getJoin() {
        return join;
    }
    public void setJoin(Date join) {
        this.join = join;
    }
    @Override
    public String toString() {
        return "Comp [name=" + name + ", work=" + work + ", pay=" + pay + ", join=" + join + "]";
    }
}
