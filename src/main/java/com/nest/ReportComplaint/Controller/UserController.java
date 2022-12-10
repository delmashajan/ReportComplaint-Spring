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

    @CrossOrigin(origins = "*")

    @GetMapping("/")
    public String Homepage(){
        return "welcome to my website";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/userReg",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserRegistration(@RequestBody UserModel um){

        HashMap<String,String> map=new HashMap<>();
        List<UserModel> result= (List<UserModel>) udao.FindUser(um.getUsername());
        if(result.size()!=0){
            map.put("status","failed");

        }else{
            udao.save(um);
            map.put("status","success");
        }
        return map;
    }

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/userlogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserLogin(@RequestBody UserModel um){

       List<UserModel> result= (List<UserModel>) udao.UserLogin(um.getUsername(),um.getPassword());
        HashMap<String,String> map=new HashMap<>();
        if(result.size()==0){
            map.put("status","failed");
        }
        else{
            map.put("status","success");
            map.put("userId",String.valueOf(result.get(0).getId()));
        }
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/profileview",consumes = "application/json",produces = "application/json")
    public List<UserModel> ProfileView(@RequestBody UserModel um){
        return (List<UserModel>) udao.profileView(um.getId());
    }

}
