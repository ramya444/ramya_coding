package com.api.springboot.springbootapi.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="emp_details")
public class EmpDatabase {

    @Id
    private ObjectId _id;
    private String emp_no;
    private String emp_name;

    List emppoints=new ArrayList();


    public List getEmppoints() {
        return emppoints;
    }

    public void setEmppoints(List emppoints) {
        this.emppoints = emppoints;
    }

    public EmpDatabase(ObjectId _id, String emp_no, String emp_name) {
        this._id = _id;
        this.emp_no = emp_no;
        this.emp_name = emp_name;

    }

    public String get_id() {
        return _id.toHexString();
    }
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

}

