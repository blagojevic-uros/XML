import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSaglasnostComponent } from './create-saglasnost.component';

describe('CreateSaglasnostComponent', () => {
  let component: CreateSaglasnostComponent;
  let fixture: ComponentFixture<CreateSaglasnostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateSaglasnostComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSaglasnostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
