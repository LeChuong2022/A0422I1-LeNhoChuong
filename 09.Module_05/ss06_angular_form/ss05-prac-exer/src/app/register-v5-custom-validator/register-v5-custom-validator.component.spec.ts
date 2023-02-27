import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterV5CustomValidatorComponent } from './register-v5-custom-validator.component';

describe('RegisterV5CustomValidatorComponent', () => {
  let component: RegisterV5CustomValidatorComponent;
  let fixture: ComponentFixture<RegisterV5CustomValidatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterV5CustomValidatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterV5CustomValidatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
