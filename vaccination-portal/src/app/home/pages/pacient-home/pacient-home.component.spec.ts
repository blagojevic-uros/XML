import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PacientHomeComponent } from './pacient-home.component';

describe('PacientHomeComponent', () => {
  let component: PacientHomeComponent;
  let fixture: ComponentFixture<PacientHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PacientHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PacientHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
