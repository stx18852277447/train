package top.stx.train.batch.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.stx.train.batch.feign.BusinessFeign;

@RestController
@Slf4j
public class Testcontroller {
    @Resource
    private BusinessFeign businessFeign;

    @GetMapping("/hello")
    public String hello() {
        String businessHello = businessFeign.hello();
        log.info("businessHello: {0}",businessHello);
        return "Hello";
    }
}
