import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStadiumEventComponent } from './add-stadium-event.component';

describe('AddStadiumEventComponent', () => {
  let component: AddStadiumEventComponent;
  let fixture: ComponentFixture<AddStadiumEventComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddStadiumEventComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddStadiumEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
