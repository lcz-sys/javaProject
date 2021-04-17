package cn.gdcp.aop;

public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("userDao save...");
    }
}
