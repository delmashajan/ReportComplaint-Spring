package com.nest.ReportComplaint.Controller;

import com.nest.ReportComplaint.dao.complaintDao;
import com.nest.ReportComplaint.model.Complaints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class ComplaintController {

    @Autowired
    private complaintDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addComplaint",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addComplaint(@RequestBody Complaints c){
        HashMap<String,String> map =  new HashMap<>();
        dao.save(c);
        map.put("status","success");

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewMyComplaint",consumes = "application/json",produces = "application/json")
    public List<Complaints> viewMy(@RequestBody Complaints c){
        System.out.println(c.getUserId());
        return (List<Complaints>) dao.viewMyComplaint(c.getUserId());
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewAllComplaint",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> viewAll(){
        return (List<Map<String, String>>) dao.complaints();


    }

}
