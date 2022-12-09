package com.nest.ReportComplaint.dao;

import com.nest.ReportComplaint.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserModel,Integer> {
}
