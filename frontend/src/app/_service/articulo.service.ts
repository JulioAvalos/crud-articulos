import { Articulo } from '../_model/articulo.model';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

  articuloCambio = new Subject<Articulo[]>();
  mensajeCambio = new Subject<string>();

  url: string = `${environment.HOST}/articulos`;

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Articulo[]>(this.url);
  }

  listarPorId(idArticulo: number) {
    return this.http.get<Articulo>(`${this.url}/${idArticulo}`);
  }

  registrar(articulo: Articulo) {
    return this.http.post(this.url, articulo);
  }

  modificar(articulo: Articulo) {
    return this.http.put(this.url, articulo);
  }

  eliminar(idArticulo: number) {
    return this.http.delete(`${this.url}/${idArticulo}`);
  }

}
