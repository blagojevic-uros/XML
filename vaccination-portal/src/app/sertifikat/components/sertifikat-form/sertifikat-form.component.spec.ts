import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SertifikatFormComponent } from './sertifikat-form.component';

describe('SertifikatFormComponent', () => {
  let component: SertifikatFormComponent;
  let fixture: ComponentFixture<SertifikatFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SertifikatFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SertifikatFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
