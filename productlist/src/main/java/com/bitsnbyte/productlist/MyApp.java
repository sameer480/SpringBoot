package com.bitsnbyte.productlist;

import org.springframework.stereotype.Component;

@Component
public class MyApp {
    private MyComponent myComponent;
    MyApp(MyComponent myComponent){
        this.myComponent=myComponent;
    }
    public void run(){
        myComponent.getMessage();
    }
}
