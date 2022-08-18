import { TestBed } from '@angular/core/testing';

import { BewerberService } from './bewerber.service';

describe('BewerberService', () => {
  let service: BewerberService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BewerberService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
