import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
import { Options } from 'selenium-webdriver';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private host:string="http://localhost:8080"
  //private headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','');
  constructor(private httpClient:HttpClient) { }

  login(user:User){
    //const userr = {username: user.username, password: user.password}
   return this.httpClient.post(this.host+"/login",user,{observe:'response'})
  }
  saveToken(jwt:string){
    localStorage.setItem('token',jwt)
  }
}
