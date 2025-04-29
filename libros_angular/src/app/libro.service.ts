import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Libro } from './libro';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibroService {
  // Cambia las URLs para usar el nombre del servicio backend
  private urlGet = 'http://backend:8080/libros';
  private urlPost = 'http://backend:8080/guardar';

  constructor(private clientHttp: HttpClient) { }

  listarLibros(): Observable<Libro[]> {
    return this.clientHttp.get<Libro[]>(this.urlGet);
  }

  agregarLibro(libro: Libro): Observable<Object> {
    return this.clientHttp.post(this.urlPost, libro, { responseType: 'text' });
  }

  obtenerLibroPorId(id: number): Observable<Libro> {
    const urlGetId = `http://backend:8080/libros/${id}`;
    return this.clientHttp.get<Libro>(urlGetId);
  }

  editarLibro(id: number, libro: Libro): Observable<Object> {
    const urlPut = `http://backend:8080/actualizar/${id}`;
    return this.clientHttp.put(urlPut, libro, { responseType: 'text' });
  }

  borrarLibro(id: number): Observable<Object> {
    const urlDelete = `http://backend:8080/borrar/${id}`;
    return this.clientHttp.delete(urlDelete, { responseType: 'text' });
  }
}
