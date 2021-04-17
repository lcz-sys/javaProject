package cn.gdcp.domain;

import cn.gdcp.utils.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private int id;//id
    private String username;//用户名
    private String password;//密码
    private String name ;//收货人
    private String phone ;//收货人电话
    private String address;//收货地址
    private Date create_time;//创建时间
    private String message;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", create_time=" + create_time +
                ", message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreate_time() {
        return format.format(create_time);
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = StringUtil.strNotNullTrim(username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = StringUtil.strNotNullTrim(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtil.strNotNullTrim(name);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = StringUtil.strNotNullTrim(phone);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = StringUtil.strNotNullTrim(address);
    }
}
