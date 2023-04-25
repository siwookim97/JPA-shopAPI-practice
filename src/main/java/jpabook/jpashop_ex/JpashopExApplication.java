package jpabook.jpashop_ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopExApplication {

    public static void main(String[] args) {

        Hello hello = new Hello();
        hello.setData("hello") ;
        System.out.println(hello.getData());
        SpringApplication.run(JpashopExApplication.class, args);
    }

}
