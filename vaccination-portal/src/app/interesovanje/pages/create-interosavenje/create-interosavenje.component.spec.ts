import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateInterosavenjeComponent } from './create-interosavenje.component';

describe('CreateInterosavenjeComponent', () => {
  let component: CreateInterosavenjeComponent;
  let fixture: ComponentFixture<CreateInterosavenjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateInterosavenjeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateInterosavenjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
