import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidateListingComponent } from './candidate-listing.component';

describe('CandidateListingComponent', () => {
  let component: CandidateListingComponent;
  let fixture: ComponentFixture<CandidateListingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CandidateListingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidateListingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
