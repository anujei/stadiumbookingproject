import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumUserlistComponent } from './stadium-userlist.component';

describe('StadiumUserlistComponent', () => {
  let component: StadiumUserlistComponent;
  let fixture: ComponentFixture<StadiumUserlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StadiumUserlistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StadiumUserlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
