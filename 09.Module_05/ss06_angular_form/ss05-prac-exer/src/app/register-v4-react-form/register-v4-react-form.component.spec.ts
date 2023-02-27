import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterV4ReactFormComponent } from './register-v4-react-form.component';

describe('RegisterV4ReactFormComponent', () => {
  let component: RegisterV4ReactFormComponent;
  let fixture: ComponentFixture<RegisterV4ReactFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterV4ReactFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterV4ReactFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
