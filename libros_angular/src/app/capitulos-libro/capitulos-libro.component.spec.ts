import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CapitulosLibroComponent } from './capitulos-libro.component';

describe('CapitulosLibroComponent', () => {
  let component: CapitulosLibroComponent;
  let fixture: ComponentFixture<CapitulosLibroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CapitulosLibroComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CapitulosLibroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
