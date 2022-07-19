import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumHeaderComponent } from './stadium-header.component';

describe('StadiumHeaderComponent', () => {
  let component: StadiumHeaderComponent;
  let fixture: ComponentFixture<StadiumHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StadiumHeaderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StadiumHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
