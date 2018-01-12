package cn.bdqn.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
public class Stock {
    private int id;
    private int productid;
    private int count;
    private Date changdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getChangdate() {
        return changdate;
    }

    public void setChangdate(Date changdate) {
        this.changdate = changdate;
    }
}
