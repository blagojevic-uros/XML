import { TestBed } from '@angular/core/testing';

import { ImunizacijaService } from './imunizacija.service';

describe('ImunizacijaService', () => {
  let service: ImunizacijaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImunizacijaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
