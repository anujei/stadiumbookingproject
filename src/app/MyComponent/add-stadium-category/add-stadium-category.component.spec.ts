import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStadiumCategoryComponent } from './add-stadium-category.component';

describe('AddStadiumCategoryComponent', () => {
  let component: AddStadiumCategoryComponent;
  let fixture: ComponentFixture<AddStadiumCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddStadiumCategoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddStadiumCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
