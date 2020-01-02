import React, { Component } from 'react';
 class Empdatabetween extends Component {
     constructor(props){
         super(props);
         this.state = {
             employee2: [],
             isLoaded:false    
            };  
        }

componentDidMount(){
    fetch('http://localhost:8080/between')    
    .then(res=>res.json())    
    .then(json=>{
        this.setState({
        isLoaded:true,
        employee2:json,
        })    
    });    
}

render() {
    return (<div>
        <div class="modal fade" id="myModal2" role="dialog">
            <div class="modal-dialog">
                <div class="modal-body-center">
                    <center>
                        <table>
                            <thead>
                                <tr>
                                    <th>EmployeeNo</th>
                                    <th>EmployeeName</th>
                                    <th>PointValue</th>
                                    <th>PointDonate</th>
                                    <th>PointReceived</th>
                                    <th>PointExpired</th>
                                    <th>LastTimestamp</th>
                                    </tr>{this.state.employee2.map((employees)=><tr>
                                         <td>{employees.emp_no}</td>  
                                         <td>{employees.emp_name}</td>   
                                         {employees.emppoints.map((sub)=>
                                            <td>{sub.pointvalue}</td>  
                                            )} 
                                            {employees.emppoints.map((sub)=>
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
    ); 
 }} 
 export default Empdatabetween;