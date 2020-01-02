import React, { Component } from 'react';
import './App.css';
import Empdatabetween from './components/Empdatabetween';
import Greater from './components/Greater';
import Lesser from './components/Lesser';

class App extends Component {constructor(props)
  {super(props);
    this.state = {employee: [],
    isLoaded:false      
  };    
}

componentDidMount(){
  fetch('http://localhost:8080/Api/getallemployeedata')      
  .then(res=>res.json())      
  .then(json=>
    {this.setState({isLoaded:true,
    employee:json,      
  })      
});      
}
render(){
  var {employee}=
  this.state;
  return(<div className="App">
  <h1>Employee Details</h1>
  <Empdatabetween />
  <Greater/>
  <Lesser/>
  <div class="container"> 
  <button type="button1" class="" data-toggle="modal" data-target="#myModal1">All Employee  <span class="glyphicon glyphicon-user"></span></button>
  <button type="button2" class="" data-toggle="modal" data-target="#myModal2">Empdatabetween</button>
  <button type="button3" class="" data-toggle="modal" data-target="#myModal3">Greater</button>
  <button type="button4" class="" data-toggle="modal" data-target="#myModal4">Lesser</button>
  </div>
 

<div class="modal fade" id="myModal1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-body-center">
      <center>
        <table>
          <thead>
            <tr>
              <th>EmployeeNo</th>
              <th>EmployeeName</th>
              <th>PointValue</th>
              <th>PointDonated</th>
              <th>PointReceived</th>
              <th>PointExpired</th>
              <th>LastTimestamp</th>
              </tr>{employee.map((employees)=><tr>
                 <td>{employees.emp_no}</td>  
                 <td>{employees.emp_name}</td>   
                 {employees.emppoints.map((sub)=>
 <td>{sub.pointvalue}</td>  
 )} {employees.emppoints.map((sub)=>
<td>{sub.pointdonated}</td>
)}{employees.emppoints.map((sub)=>
<td>{sub.pointreceived}</td>
)}{employees.emppoints.map((sub)=>
<td>{sub.pointexpired}</td>
)}{employees.emppoints.map((sub)=>
<td>{sub.lasttimestamp}</td>
)}</tr>
)}

</thead>
<div class="modal-footer">
  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
  </div>
  </table>
  </center>
  </div>
  </div>
  </div>
  </div>        
  )        
}}
export default App;
