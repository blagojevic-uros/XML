import { TestBed } from '@angular/core/testing';

import { ZahtevZaSertifikatService } from './zahtev-za-sertifikat.service';

describe('ZahtevZaSertifikatService', () => {
  let service: ZahtevZaSertifikatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZahtevZaSertifikatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
