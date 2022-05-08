package com.example.nacosprovider.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/")
@Slf4j
public class SampleController {



    @ApiOperation(value = "测试")
    @GetMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {

        try {
            InetAddress addr = InetAddress.getLocalHost();
            log.info("IP地址：" + addr.getHostAddress() + "，主机名：" + addr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return "Hello Nacos Discovery " + string;
    }

}