import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { from, interval } from 'rxjs';
import { Observable, throwError } from 'rxjs';



@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {
  mode:Number=0;
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }
  authentifier(data: NgForm) {
    let user = data.value
    console.log(user)
    this.authService.login(user).subscribe(resp=>{
      let jwt = resp.headers.get('authorization');
      console.log(jwt)
      //this.authService.saveToken(jwt)
      console.log(resp)
      this.router.navigate(['/listClients'])
      
    })
  }
}
