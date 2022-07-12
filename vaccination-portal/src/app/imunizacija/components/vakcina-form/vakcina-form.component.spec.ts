import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VakcinaFormComponent } from './vakcina-form.component';

describe('VakcinaFormComponent', () => {
  let component: VakcinaFormComponent;
  let fixture: ComponentFixture<VakcinaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VakcinaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VakcinaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
