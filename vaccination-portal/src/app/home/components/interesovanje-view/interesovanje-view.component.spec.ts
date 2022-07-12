import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InteresovanjeViewComponent } from './interesovanje-view.component';

describe('InteresovanjeViewComponent', () => {
  let component: InteresovanjeViewComponent;
  let fixture: ComponentFixture<InteresovanjeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InteresovanjeViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InteresovanjeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
