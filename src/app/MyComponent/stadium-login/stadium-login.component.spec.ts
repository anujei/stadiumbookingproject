import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumLoginComponent } from './stadium-login.component';

describe('StadiumLoginComponent', () => {
  let component: StadiumLoginComponent;
  let fixture: ComponentFixture<StadiumLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StadiumLoginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StadiumLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
