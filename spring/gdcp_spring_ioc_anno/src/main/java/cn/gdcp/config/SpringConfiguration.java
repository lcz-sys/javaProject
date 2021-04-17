package cn.gdcp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cn.gdcp")
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
