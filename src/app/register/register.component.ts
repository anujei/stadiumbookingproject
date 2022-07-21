import { Component, OnInit } from '@angular/core';
import { state } from '../model/states-data';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public states:any = state;
 
  constructor() { }

  ngOnInit(): void {
  }
  
}
