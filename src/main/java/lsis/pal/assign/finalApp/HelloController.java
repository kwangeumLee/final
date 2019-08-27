package lsis.pal.assign.finalApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String helloMsg;

    @GetMapping("/")
    public String sayHello() {
        //return "hello";
        return helloMsg;
    }
}
