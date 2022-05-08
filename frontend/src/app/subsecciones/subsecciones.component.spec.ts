import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubseccionesComponent } from './subsecciones.component';

describe('SubseccionesComponent', () => {
  let component: SubseccionesComponent;
  let fixture: ComponentFixture<SubseccionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubseccionesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubseccionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
