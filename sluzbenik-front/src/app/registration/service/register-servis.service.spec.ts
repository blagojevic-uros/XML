import { TestBed } from '@angular/core/testing';

import { RegisterServisService } from './register-servis.service';

describe('RegisterServisService', () => {
  let service: RegisterServisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterServisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
