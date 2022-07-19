import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumAdminHeaderComponent } from './stadium-admin-header.component';

describe('StadiumAdminHeaderComponent', () => {
  let component: StadiumAdminHeaderComponent;
  let fixture: ComponentFixture<StadiumAdminHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StadiumAdminHeaderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StadiumAdminHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
