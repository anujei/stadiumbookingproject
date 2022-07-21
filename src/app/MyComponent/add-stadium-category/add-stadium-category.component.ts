import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from 'src/app/MyModel/Category';
import { JwtClientService } from 'src/app/MyService/jwt-client.service';

@Component({
  selector: 'app-add-stadium-category',
  templateUrl: './add-stadium-category.component.html',
  styleUrls: ['./add-stadium-category.component.css']
})
export class AddStadiumCategoryComponent implements OnInit {
  category: Category=new Category();
  message:any;
  data!: Observable<Event[]>;
  constructor(private service:JwtClientService) { }

  ngOnInit(): void {
    this.viewUserDetails();
  }
  public viewUserDetails(){
    this.service.viewevent().subscribe(data=>console.log(data[0].title));
  }
  public addcategory(){
    console.log(this.category)
    let resp=this.service.registerevent(this.category);
    resp.subscribe((data)=>this.message=data);
  }
}
