package com.api.springboot.springbootapi.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class emppoints {

    List emppoints=new ArrayList();

    public List getEmppoints() {
        return emppoints;
    }

    public void setEmppoints(List emppoints) {
        this.emppoints = emppoints;
    }

}
