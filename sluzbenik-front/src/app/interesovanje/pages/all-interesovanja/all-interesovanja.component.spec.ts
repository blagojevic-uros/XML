import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllInteresovanjaComponent } from './all-interesovanja.component';

describe('AllInteresovanjaComponent', () => {
  let component: AllInteresovanjaComponent;
  let fixture: ComponentFixture<AllInteresovanjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllInteresovanjaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllInteresovanjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
