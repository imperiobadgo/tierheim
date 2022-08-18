import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BewerberListComponent } from './bewerber-list.component';

describe('BewerberListComponent', () => {
  let component: BewerberListComponent;
  let fixture: ComponentFixture<BewerberListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BewerberListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BewerberListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
