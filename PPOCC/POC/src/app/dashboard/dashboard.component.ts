import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  registerForm: FormGroup;
  userList:any;
  address:any;
  user:any;
  id: any;
  City: any;
  Pincode: any;
  Email: any;
  phoneNumber: any;
  username: any;
  password: any;
  addId: any;
  userId: any;
  result: any = [];
  data: any;
  constructor(private service:RegistrationService,private formBuilder: FormBuilder, private myRoute: Router) {
    
   }

  ngOnInit(): void {

    this.registerForm = this.formBuilder.group({
      city: ['', Validators.required],
      pinCode: ['', Validators.required],
      EmailId: ['', Validators.required],
      mobileNumber: ['', Validators.required],
        userName: ['', Validators.required],
        Password: ['', [Validators.required, Validators.minLength(6)]]
    });
    this.getAllUser();
  }

  getAllUser(){
    this.service.getAllUsers().subscribe((res) => {
      console.log(res);
      this.userList = res["userRegistration"];
      // for(let i = 0; i< res["userRegistration"].length;i++){
      //   this.result.push(this.userList[i]["address"]);
      //   this.data = this.result[i];
      // }
      // this.address = res["userRegistration"][0]["address"];
      // console.log("gjhgjhgjkgjkgkg",this.address);
      // this.user = res["userRegistration"][0]["userLogin"];
    })

    
}

  editUser(request){
    this.id = request.id;
  
    this.addId = request["address"][0]["id"]; 
  
    this.City= request["address"][0]["city"];
 
    this.Pincode=request["address"][0]["pincode"];
    
    this.Email=request.emailId;
    
    this.phoneNumber= request.mobileNo;
  
    this.userId = request["userLogin"]["id"];
   
    this.username= request["userLogin"]["userName"];
    
    this.password= request["userLogin"]["password"];
  }
  
  updateUser(request){
    
    let userRequest = {
      "id":this.id,
      "userLogin":{
          "id":this.userId,
          "userName":request["userName"],
          "password":request["Password"]
       
      },
      "address":[
          {
            "id": this.addId,
              "city":request["city"],
              "pincode":request["pinCode"]
          }
      ],
      "emailId":request.EmailId,
      "mobileNo":request.mobileNumber
         
      }
     
      this.service.updateUser(userRequest).subscribe((res) =>{
        alert(res["statusMessage"]);
        this.getAllUser();
      })
  }


  deleteUser(request){
    this.service.deleteUser(request).subscribe((res) =>{
      if(res["statusCode"] == "200"){
        alert(res["statusMessage"]);
        this.getAllUser();
      }
      else{
        alert(res["statusMessage"])
      }
    })
  }
}