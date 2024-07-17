package project.example.springapp;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class Checkobj {

    public String objcheck(){
        return("IoC will be working");
    }


}
