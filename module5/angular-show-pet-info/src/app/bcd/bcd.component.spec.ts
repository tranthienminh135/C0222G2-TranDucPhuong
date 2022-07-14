import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BcdComponent } from './bcd.component';

describe('BcdComponent', () => {
  let component: BcdComponent;
  let fixture: ComponentFixture<BcdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BcdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BcdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
