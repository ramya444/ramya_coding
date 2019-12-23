package com.api.springboot.springbootapi.repository;


import com.api.springboot.springbootapi.model.EmpDatabase;
import com.api.springboot.springbootapi.model.emppoints;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface EmpDatabaseRepository extends MongoRepository<EmpDatabase,String> {
    EmpDatabase findBy_id(Object _id);

    @org.springframework.data.mongodb.repository.Query(value="{'emppoints.pointvalue':{$gt:?0,$lt:?1}}")
    List findByPointValueBetweenQuery(int start,int end);

    @org.springframework.data.mongodb.repository.Query(value="{'emppoints.pointvalue':{$gt:?0}}")
    List findByPointValueGreaterThanQuery(int Gtvalue );

    @org.springframework.data.mongodb.repository.Query(value="{'emppoints.pointvalue':{$lt:?0}}")
    List findByPointValueLessThanQuery(int Ltvalue );




//  Emp_Database  findByPoint_ValueLessThan(int Point_Value);
//   List findByPoint_ValueLessThan(Query point_value);
}
