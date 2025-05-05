import { ActivatedRoute } from '@angular/router';
import { Capitulo } from '../capitulo'; 
import { CapituloService } from '../capitulo.service'; 
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-capitulos-libro',
  templateUrl: './capitulos-libro.component.html',
})
export class CapitulosLibroComponent implements OnInit {
  capitulos: Capitulo[] = [];
  libroId!: number;

  constructor(
    private route: ActivatedRoute,
    private capituloService: CapituloService
  ) {}

  ngOnInit(): void {
    this.libroId = Number(this.route.snapshot.paramMap.get('id'));
    this.capituloService.obtenerCapitulosPorLibro(this.libroId).subscribe(
      data => this.capitulos = data,
      err => console.error('Error al obtener capítulos', err)
    );
  }
}
