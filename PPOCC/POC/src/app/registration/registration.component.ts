import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registerForm: FormGroup;
  loading = false;
  submitted = false;
  id: any;

  constructor(
      private formBuilder: FormBuilder,
      private router: Router,
    private userService: RegistrationService,
     private activatedRouter: ActivatedRoute
      ) { }

  ngOnInit() {
    this.id = this.activatedRouter.snapshot.params['id']; 
    console.log("===================>",this.id);
      this.registerForm = this.formBuilder.group({
        City: ['', Validators.required],
        Pincode: ['', Validators.required],
        Email: ['', Validators.required],
        phoneNumber: ['', Validators.required],
          username: ['', Validators.required],
          password: ['', [Validators.required, Validators.minLength(6)]]
      });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }
  createUser(request){
    let user ={
 
      "userLogin":{
        
          "userName":request.username,
          "password":request.password
       
      },
      "address":[
          {
            
              "city":request.City,
              "pincode":request.Pincode
          }
      ],
      "emailId":request.Email,
      "mobileNo":request.phoneNumber
         
      }
    this.userService.createUser(user).subscribe((res) =>{
      if(res["statusCode"] == "200"){
        alert(res["statusMessage"]);
        this.router.navigate([""]);
      }
      else{
        alert(res["statusMessage"]);
      }
    })
  }

}
