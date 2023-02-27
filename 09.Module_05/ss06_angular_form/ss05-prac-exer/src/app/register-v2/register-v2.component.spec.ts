import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterV2Component } from './register-v2.component';

describe('RegisterV2Component', () => {
  let component: RegisterV2Component;
  let fixture: ComponentFixture<RegisterV2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterV2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterV2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
