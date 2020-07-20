package com.example.demo.controller;

import com.example.demo.entities.HelloRequestEntity;
import com.example.demo.entities.HelloResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 可以用以下四种方式进行注解
 * @Controller
 * @Repository
 * @Service
 * @Component
 */
//@Controller
@RestController
//@RequestMapping("/demo")
public class DemoController {
    // 映射
    @GetMapping("/demo/hello")
    @ResponseBody
    public String sayHello(@RequestParam("username") String name) {
        return "Hello," + name;
    }

    //路径传参数
    @GetMapping("/demo/{name}/WhoSayHello")
    @ResponseBody
    public String WhoSayHello(
            @PathVariable("name") String name,
            @RequestParam("age") int age
    ){
        return "Hello, " + name + ", You are "+age +" years old";
    }

    //返回值为对象
    @GetMapping("/demo/{name}/ResponseObject")
    @ResponseBody
    public HelloResponseEntity hello(
            @PathVariable("name") String name,
            @RequestParam("age") int age
    ){
        HelloResponseEntity helloResponseEntity = new HelloResponseEntity();
        helloResponseEntity.setCode(100);
        helloResponseEntity.setMessage("success");
        helloResponseEntity.setName(name);
        helloResponseEntity.setAge(age);
      return helloResponseEntity;
    }

    //参数定义一个请求实体
    @GetMapping("/demo/{name}/RequestObject")
    @ResponseBody
    public HelloResponseEntity hello(
            @PathVariable("name") String name,
            @RequestBody HelloRequestEntity helloRequestEntity
            ){
        HelloResponseEntity helloResponseEntity = new HelloResponseEntity();
        helloResponseEntity.setCode(100);
        helloResponseEntity.setMessage("success");
        helloResponseEntity.setName(name);
        helloResponseEntity.setAge(helloRequestEntity.getAge());
        helloResponseEntity.setGreeting(helloRequestEntity.getGreeting());
        return helloResponseEntity;
    }
}
