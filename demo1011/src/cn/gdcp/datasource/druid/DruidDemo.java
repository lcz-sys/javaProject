package cn.gdcp.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {

    public static void main(String[] args) throws Exception {

        Properties pro = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

        pro.load(is);

        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        Connection conn = null;

        for (int i = 0; i < 10; i++) {
            conn = ds.getConnection();

            System.out.println(conn);
        }


    }

}
