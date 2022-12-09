package com.nest.ReportComplaint.Controller;

import com.nest.ReportComplaint.dao.UserDao;
import com.nest.ReportComplaint.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserDao udao;

    @GetMapping("/")
    public String Homepage(){
        return "welcome to my website";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/userReg",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserRegistration(@RequestBody UserModel um){
        System.out.println(um.getName().toString());
        udao.save(um);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<UserModel> viewAll(){
        return (List<UserModel>) udao.findAll();
    }
}
