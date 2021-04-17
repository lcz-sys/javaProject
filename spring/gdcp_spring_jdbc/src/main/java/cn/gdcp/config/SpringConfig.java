package cn.gdcp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("cn.gdcp")
@Import({JdbcTemplateConfig.class,DataSourceConfig.class})
public class SpringConfig {

}
