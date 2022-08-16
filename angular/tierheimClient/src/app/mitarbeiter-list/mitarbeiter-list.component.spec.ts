import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MitarbeiterListComponent } from './mitarbeiter-list.component';

describe('MitarbeiterListComponent', () => {
  let component: MitarbeiterListComponent;
  let fixture: ComponentFixture<MitarbeiterListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MitarbeiterListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MitarbeiterListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
