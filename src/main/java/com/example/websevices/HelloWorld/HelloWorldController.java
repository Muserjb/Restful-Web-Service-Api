package com.example.websevices.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String HelloWord(){

        return "Hello World";
    }


    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean hello(){
       return new HelloWorldBean("Hello World bean");
    }

//path parameters
    //  /users/id/todos/{id} => /user/2/todos/200
    // /hello-world/path-variable/{name}
    // /hello-world/path-variable/musa

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWordPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s ", name));
    }


}