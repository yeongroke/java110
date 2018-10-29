package ex11.step1;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ex11.step1")
public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig() 호출됨!");
    }
}
