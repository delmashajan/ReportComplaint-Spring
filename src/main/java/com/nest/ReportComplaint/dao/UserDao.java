package com.nest.ReportComplaint.dao;

import com.nest.ReportComplaint.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `user` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<UserModel> UserLogin(@Param("username")String username,@Param("password")String password);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `user` WHERE `username`= :username",nativeQuery = true)
    List<UserModel> FindUser(@Param("username")String username);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `user` WHERE `id` = :id",nativeQuery = true)
    List<UserModel> profileView(@Param("id") Integer id);
}

