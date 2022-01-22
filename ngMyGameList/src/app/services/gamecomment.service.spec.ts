import { TestBed } from '@angular/core/testing';

import { GamecommentService } from './gamecomment.service';

describe('GamecommentService', () => {
  let service: GamecommentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GamecommentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
