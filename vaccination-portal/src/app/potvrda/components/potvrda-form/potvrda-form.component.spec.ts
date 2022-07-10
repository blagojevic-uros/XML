import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PotvrdaFormComponent } from './potvrda-form.component';

describe('PotvrdaFormComponent', () => {
  let component: PotvrdaFormComponent;
  let fixture: ComponentFixture<PotvrdaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PotvrdaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PotvrdaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
