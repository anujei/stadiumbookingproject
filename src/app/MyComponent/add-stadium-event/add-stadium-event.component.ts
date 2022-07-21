import { Component, OnInit } from '@angular/core';
import { Event } from 'src/app/MyModel/Event';
import { JwtClientService } from 'src/app/MyService/jwt-client.service';
@Component({
  selector: 'app-add-stadium-event',
  templateUrl: './add-stadium-event.component.html',
  styleUrls: ['./add-stadium-event.component.css']
})
export class AddStadiumEventComponent implements OnInit {
  event: Event=new Event();
  message:any;
  constructor(private service:JwtClientService) { }
  ngOnInit(): void {
  }
  public addevent(){
    console.log(this.event)
    let resp=this.service.registercategory(this.event);
    resp.subscribe((data)=>this.message=data);
  }
}
