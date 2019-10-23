import { TestBed } from '@angular/core/testing';

import { SeviceCompteService } from './sevice-compte.service';

describe('SeviceCompteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SeviceCompteService = TestBed.get(SeviceCompteService);
    expect(service).toBeTruthy();
  });
});
