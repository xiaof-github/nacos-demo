package com.example.nacosconsumer.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
@Slf4j
public class SampleController {

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "测试")
    @GetMapping("/")
    String home() {
        return "Hello World!";
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://demo1/echo/" + str, String.class);
    }

}