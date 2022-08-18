import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BewerberEditComponent } from './bewerber-edit.component';

describe('BewerberEditComponent', () => {
  let component: BewerberEditComponent;
  let fixture: ComponentFixture<BewerberEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BewerberEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BewerberEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
