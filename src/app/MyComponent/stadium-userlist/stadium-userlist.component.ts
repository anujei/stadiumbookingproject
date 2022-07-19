import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/MyModel/User';
import { JwtClientService } from 'src/app/MyService/jwt-client.service';

@Component({
  selector: 'app-stadium-userlist',
  templateUrl: './stadium-userlist.component.html',
  styleUrls: ['./stadium-userlist.component.css']
})
export class StadiumUserlistComponent implements OnInit {
  user: User=new User();
  data!: Observable<User[]>;
  constructor(private service:JwtClientService) { }

  ngOnInit(): void {
    this.viewUserDetails();
  }
  public viewUserDetails(){
    // this.service.welcome().subscribe(data=>console.log(data));
    // this.service.welcome().subscribe(response =>this.data = response);
    this.data=this.service.welcome();

  }
}
