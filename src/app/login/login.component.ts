import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from '../_services/user-auth.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private userService : UserService,
    private userAuthService : UserAuthService,
    private router:Router
    ) 
    { }

  ngOnInit(): void {
  }
  login(loginForm : NgForm){
   
    this.userService.login(loginForm.value).subscribe(
    (responsedata : any)=>{
     
      console.log(responsedata.jwtToken);
      console.log(responsedata.user.role);
      this.userAuthService.setRoles(responsedata.user.role);
      this.userAuthService.setToken(responsedata.jwtToken);

      const role = responsedata.user.role[0].roleName;
      if(role === 'User')
          this.router.navigate(['/user']);
      else
          this.router.navigate(['/admin']);
      
      
    },
    (error)=>{
      console.log(error);
    }
      
    );
  }

}
 