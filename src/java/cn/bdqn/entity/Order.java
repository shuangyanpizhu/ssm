package cn.bdqn.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
public class Order {
    private int order_id;
    private int order_no;
    private String order_status;
    private String address;
    private String orderlogistics_id;
    private Date order_time;
    private Date delivery_time;
    private int branch_id;
    private String logistics;
    private int order_detail;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderlogistics_id() {
        return orderlogistics_id;
    }

    public void setOrderlogistics_id(String orderlogistics_id) {
        this.orderlogistics_id = orderlogistics_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Date getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Date delivery_time) {
        this.delivery_time = delivery_time;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public int getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(int order_detail) {
        this.order_detail = order_detail;
    }
}
