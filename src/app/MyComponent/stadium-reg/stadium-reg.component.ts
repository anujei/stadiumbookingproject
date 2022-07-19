import { Component, OnInit } from '@angular/core';
import { JwtClientService } from 'src/app/MyService/jwt-client.service';
import { User } from 'src/app/MyModel/User';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-stadium-reg',
  templateUrl: './stadium-reg.component.html',
  styleUrls: ['./stadium-reg.component.css']
})
export class StadiumRegComponent implements OnInit {

  user: User=new User();
  message:any;

  constructor(private service:JwtClientService) { }

  ngOnInit(): void{


  }

  public registerNow(){
    console.log(this.user)
    let resp=this.service.doRegister(this.user);
    resp.subscribe((data)=>this.message=data);
  }
}
