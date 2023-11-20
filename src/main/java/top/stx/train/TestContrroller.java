package top.stx.train;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContrroller {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
