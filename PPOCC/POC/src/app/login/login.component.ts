import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginForm: FormGroup;
  submitted = false;
  results: any;
  admin: any;
  
   constructor(private formBuilder: FormBuilder, private myRoute: Router,private service: RegistrationService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
     
      username: ['', Validators.required],
      password: ['', [Validators.required,]]
    });
  }

  login(request){
    let userRequest = {
      "userName" : request.username,
      "password" : request.password
    }
    this.service.userLogin(userRequest).subscribe(res=>{
      if(res["statusCode"] == "200"){
        this.myRoute.navigate(["/dashboard"]);
      }
      else{
        alert(res["statusMessage"]);
      }
    })
  }

}