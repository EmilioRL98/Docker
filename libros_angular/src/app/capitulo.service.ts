import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Capitulo } from './capitulo';

@Injectable({
  providedIn: 'root'
})
export class CapituloService {
  private baseUrl = '/api/capitulos'; // Esto se redirigirá a backend vía Nginx

  constructor(private http: HttpClient) {}

  obtenerCapitulosPorLibro(libroId: number): Observable<Capitulo[]> {
    return this.http.get<Capitulo[]>(`${this.baseUrl}/libro/${libroId}`);
  }
}
