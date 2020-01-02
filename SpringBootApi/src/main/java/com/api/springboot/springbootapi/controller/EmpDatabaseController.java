package com.api.springboot.springbootapi.controller;

import com.api.springboot.springbootapi.model.EmpDatabase;

import com.api.springboot.springbootapi.model.emppoints;
import com.api.springboot.springbootapi.repository.EmpDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.query;

@Component
@Controller
@RestController
public class EmpDatabaseController {

    @Autowired
    private EmpDatabaseRepository empDatabaseRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping(value = "/Api/getallemployeedata" ,method = RequestMethod.GET)
    public List getAllEmp_database(){
    return empDatabaseRepository.findAll();
    }
    @RequestMapping(value = "Api/{id}", method = RequestMethod.GET)
    public EmpDatabase getEmp_databaseById(@PathVariable("id")String id) {
    return empDatabaseRepository.findBy_id(id);
    }
    @RequestMapping(value = "/Api/between",method = RequestMethod.GET)
    public List getpointvalueBetween(){
    return empDatabaseRepository.findByPointValueBetweenQuery(1000,3000);
    }
    @RequestMapping(value = "/Api/greaterthan5000",method = RequestMethod.GET)
    public List getpointvalueGreaterThan(){
    return empDatabaseRepository.findByPointValueGreaterThanQuery(5000);
    }
    @RequestMapping(value = "/Api/lesserthan3000",method = RequestMethod.GET)
    public List getpointvalueLesserThan(){
    return empDatabaseRepository.findByPointValueLessThanQuery(3000);empDatabaseRepository.findAll();
    }
    

//    public List <emppoints>findBypointvalueBetween(int start,int end) {
//        int query = new Query();
//        query(Criteria.where("pointvalue").lt(8000).gt(2000));
//        return empDatabaseRepository.findBypointvalueBetween(query, emppoints.class);
//    }

    }

//

//    Query query=new Query();
//    Criteria between=Criteria.where("point_Value").gt(2000).lt(8000);
//    List<EmpDatabase> result=mongoOps.find(query(between),EmpDatabase.class);

//    @RequestMapping(value = "/between",method = RequestMethod.GET)
//    public List<EmpDatabase> getAllPoints() {
//
//    }

//    @RequestMapping(value = "/subdoc",method = RequestMethod.GET)
//     public List<EmpDatabase> obtainpoint_ValueGreaterThan(){
//        Query query=new Query(Criteria(where("Points.point_Value").gt(5000),EmpDatabase.class));
//         }

    

//    @RequestMapping(value = "/btw",method = RequestMethod.GET)
//    public EmpDatabase getEmp_PointsBtw(){
//        Criteria between = where("point_Value").gt(5000).lt(7000);
//        return .(query(between), EmpDatabase.class);
//    }

//    @RequestMapping(value = "/lesser",method = RequestMethod.GET)
//    public Emp_Database getByPoint_ValueLessThan(){
//        Query query=new Query();
//        List <Emp_Database> emp_databases= (List<Emp_Database>) this.empDatabaseRepository.findByPoint_ValueLessThan(query(where("point_Value").gt(5000).lt(7000)));
//        return (Emp_Database) emp_databases;
//    }

//    @RequestMapping(value = "/above" ,method=RequestMethod.GET)
//    public List getfindByPointsGreaterThan(){
//        return findBypoint_ValueGreaterThan(query(where("point_Value").gt(7000)),Emp_Database.class);
//
//    }
//
//



//    @RequestMapping(value = "/between",method = RequestMethod.GET)
//    public List getBypoint_Value(int from,int to){ public (DBCollection collection){
////        BasicDBObject getQuery=new BasicDBObject();
////        getQuery.put("point_Value",new BasicDBObject("$gt",2000).append("$lt",5));
////        DBCursor cursor=collection.find(getQuery);
////        while(cursor.hasNext()){
////
////        }
////    }
//        Query query=new Query();
//        List <Emp_Database> emp_databases=this.empDatabaseRepository.findBypoint_ValueBetween(query(where("point_Value").gt(5000).lt(7000)));
//        return emp_databases;
//
//    }
//     @RequestMapping(value = "/price/{maxpoint}")
//     public List<Emp_Database> getBypoint_Value(@PathVariable("maxpoint")int maxpoint){
//        List<Emp_Database> emp_databases=this.empDatabaseRepository.findBypoint_ValueLessThan(maxpoint);
//        return emp_databases;
//
//     }




//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public void modifyEmp_DatabaseById(@PathVariable("id") ObjectId id, @Valid @RequestBody Emp_Database emp_database) {
//        emp_database.set_id(id);
//        empDatabaseRepository.save(emp_database);
//    }
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Emp_Database createEmp_Database(@Valid @RequestBody Emp_Database emp_database) {
//        emp_database.set_id(ObjectId.get());
//        empDatabaseRepository.save(emp_database);
//        return emp_database;
//    }
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable ObjectId id) {
//        empDatabaseRepository.delete(empDatabaseRepository.findBy_id(id));
//    }
}




