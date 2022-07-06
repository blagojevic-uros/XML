import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateImunizacijaComponent } from './create-imunizacija.component';

describe('CreateImunizacijaComponent', () => {
  let component: CreateImunizacijaComponent;
  let fixture: ComponentFixture<CreateImunizacijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateImunizacijaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateImunizacijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
