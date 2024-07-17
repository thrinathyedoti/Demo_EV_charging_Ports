package project.example.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Checking {

    @GetMapping("/check")
    public String check() {
        return "Checking the page";
    }

    @Autowired
    Checkobj checkobj;

    @GetMapping("/objectChecking")
    public String getObjCheck() {
        return checkobj.objcheck();
    }
}



