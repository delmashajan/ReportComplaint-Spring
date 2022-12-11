package com.nest.ReportComplaint.dao;

import com.nest.ReportComplaint.model.Complaints;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface complaintDao extends CrudRepository<Complaints,Integer> {

    @Query(value = "SELECT  u.`address`, u.`email`, u.`name`, u.`phone`, c.complaints FROM `user` u JOIN complaints c ON c.user_id=u.id",nativeQuery = true)
    List<Map<String,String>> complaints();

    @Query(value = "SELECT `id`, `complaints`, `user_id` FROM `complaints` WHERE `user_id` =:userId",nativeQuery = true)
    List<Complaints> viewMyComplaint(@Param("userId") Integer userId);
}
