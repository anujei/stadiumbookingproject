import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumRegComponent } from './stadium-reg.component';

describe('StadiumRegComponent', () => {
  let component: StadiumRegComponent;
  let fixture: ComponentFixture<StadiumRegComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StadiumRegComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StadiumRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
