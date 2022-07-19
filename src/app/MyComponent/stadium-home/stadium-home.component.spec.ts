import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumHomeComponent } from './stadium-home.component';

describe('StadiumHomeComponent', () => {
  let component: StadiumHomeComponent;
  let fixture: ComponentFixture<StadiumHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StadiumHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StadiumHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
