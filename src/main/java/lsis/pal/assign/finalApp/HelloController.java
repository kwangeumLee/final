package lsis.pal.assign.finalApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private String message;

    public HelloController(@Value("${welcome.message}") String helloMsg) {
        this.message = helloMsg;
    }

    @GetMapping("/")
    public String sayHello() {

        return this.message;
    }
}
