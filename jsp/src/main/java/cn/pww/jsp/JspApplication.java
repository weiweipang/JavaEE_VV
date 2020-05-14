package cn.pww.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})

public class JspApplication {
    public static void main(String[] args) {
        SpringApplication.run(JspApplication.class);
    }
}
