import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) { };

  
  // url = "http://localhost:8080/user/";

  getAllUsers(){
    return this.http.get("http://192.168.2.159:8080/user/getAllUsers");
  }

  createUser(userRequest){
    return this.http.post("http://192.168.2.159:8080/user/createUser",userRequest);
  }

  updateUser(userRequest){
    return this.http.post("http://192.168.2.159:8080/user/updateUser",userRequest);
  }

  deleteUser(userRequest){
    return this.http.delete("http://192.168.2.159:8080/user/deleteUser/"+ userRequest);
  }

  userLogin(userRequest){
    return this.http.post("http://192.168.2.159:8080/user/login",userRequest);
  }
}