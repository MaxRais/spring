package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/bobsaget")
    public String bobsaget() {
        return "I am bob saget!";
    }

    @RequestMapping("/double/{num}")
    public String getDouble(@PathVariable("num") int num) {
        return Integer.toString(num*2);
    }

}
