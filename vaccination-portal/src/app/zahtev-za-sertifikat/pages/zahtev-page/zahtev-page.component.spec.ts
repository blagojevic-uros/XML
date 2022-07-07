import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZahtevPageComponent } from './zahtev-page.component';

describe('ZahtevPageComponent', () => {
  let component: ZahtevPageComponent;
  let fixture: ComponentFixture<ZahtevPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZahtevPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZahtevPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
