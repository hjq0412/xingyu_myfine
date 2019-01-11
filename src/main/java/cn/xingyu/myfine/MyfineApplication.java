package cn.xingyu.myfine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("cn.xingyu.myfine")
public class MyfineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyfineApplication.class, args);
    }

}

