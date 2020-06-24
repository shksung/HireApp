import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidateEditorComponent } from './candidate-editor.component';

describe('CandidateEditorComponent', () => {
  let component: CandidateEditorComponent;
  let fixture: ComponentFixture<CandidateEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CandidateEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidateEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
