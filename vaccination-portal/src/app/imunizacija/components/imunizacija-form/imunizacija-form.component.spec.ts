import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImunizacijaFormComponent } from './imunizacija-form.component';

describe('ImunizacijaFormComponent', () => {
  let component: ImunizacijaFormComponent;
  let fixture: ComponentFixture<ImunizacijaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImunizacijaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImunizacijaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
