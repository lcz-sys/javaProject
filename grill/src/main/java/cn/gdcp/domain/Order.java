package cn.gdcp.domain;

import java.util.Date;
import java.util.List;

public class Order {
    /*订单状态--未付款*/
    public static final byte STATUS_UNPAY = 1;
    /*订单状态--已付款*/
    public static final byte STATUS_PAYED = 2;
    /*订单状态--配送中*/
    public static final byte STATUS_SEND = 3;
    /*订单状态--已完成*/
    public static final byte STATUS_FINISH = 4;

    /*支付方式--微信*/
    public static final byte PAYTYPE_WECHAT = 1;
    /*支付方式--支付宝*/
    public static final byte PAYTYPE_ALIPAY = 2;
    /*支付方式--线下*/
    public static final byte PAYTYPE_OFFLINE = 3;


    private int id;//           编号
    private int total;//		订单金额
    private int amount;//		商品总数
    private byte status;//		订单状态(1未付款/2已付款/3已发货/4已完成)
    private byte paytype;//		支付方式 (1微信/2支付宝)
    private String name;//		收货人
    private String phone;//		收货电话
    private String address;//   收货地址
    private Date systime;//		下单时间
    private int userId;//	    下单用户ID
    private User user;
    private List<Item> itemList;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", amount=" + amount +
                ", status=" + status +
                ", paytype=" + paytype +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", systime=" + systime +
                ", userId=" + userId +
                ", user=" + user +
                ", itemList=" + itemList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getPaytype() {
        return paytype;
    }

    public void setPaytype(byte paytype) {
        this.paytype = paytype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSystime() {
        return systime;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
