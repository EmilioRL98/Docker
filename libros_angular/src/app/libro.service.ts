import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Libro } from './libro';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibroService {
  private urlGet = '/api/libros';
  private urlPost = '/api/guardar';

  constructor(private clientHttp: HttpClient) { }

  listarLibros(): Observable<Libro[]> {
    return this.clientHttp.get<Libro[]>(this.urlGet);
  }

  agregarLibro(libro: Libro): Observable<Object> {
    return this.clientHttp.post(this.urlPost, libro, { responseType: 'text' });
  }

  obtenerLibroPorId(id: number): Observable<Libro> {
    const urlGetId = `/api/libros/${id}`;
    return this.clientHttp.get<Libro>(urlGetId);
  }

  editarLibro(id: number, libro: Libro): Observable<Object> {
    const urlPut = `/api/actualizar/${id}`;
    return this.clientHttp.put(urlPut, libro, { responseType: 'text' });
  }

  borrarLibro(id: number): Observable<Object> {
    const urlDelete = `/api/borrar/${id}`;
    return this.clientHttp.delete(urlDelete, { responseType: 'text' });
  }
}
