import { Articulo } from './../../../_model/articulo.model';
import { ArticuloService } from './../../../_service/articulo.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-articulo-edicion',
  templateUrl: './articulo-edicion.component.html',
  styleUrls: ['./articulo-edicion.component.scss']
})
export class ArticuloEdicionComponent implements OnInit {

  form: FormGroup;
  id: number;
  edicion: boolean;

  articulo: Articulo;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private articuloService: ArticuloService
  ) { }

  ngOnInit() {

    this.articulo = new Articulo();

    this.form = new FormGroup({
      'idArticulo': new FormControl(0),
      'descripcion': new FormControl(''),
      'ultimoCosto': new FormControl(0)
    });

    this.route.params.subscribe((params: Params) => {
      this.id = params['id'];
      this.edicion = params['id'] != null;
      this.initForm();
    });
  }

  initForm() {
    if (this.edicion) {
      this.articuloService.listarPorId(this.id).subscribe(data => {
        this.form = new FormGroup({
          'idArticulo': new FormControl(data.idArticulo),
          'descripcion': new FormControl(data.descripcion),
          'ultimoCosto': new FormControl(data.ultimoCosto)
        });
      });
    }
  }

  operar() {
    
    this.articulo.idArticulo = this.form.value['idArticulo'];
    this.articulo.descripcion = this.form.value['descripcion'];
    this.articulo.ultimoCosto = this.form.value['ultimoCosto'];
    console.log(this.articulo);
    if (this.articulo && this.articulo.idArticulo > 0) {

      this.articuloService.modificar(this.articulo).pipe(switchMap(() => {
        return this.articuloService.listar();
      })).subscribe(data => {
        this.articuloService.articuloCambio.next(data);
        this.articuloService.mensajeCambio.next('Se modifico!');
      });

    } else {
      this.articuloService.registrar(this.articulo).pipe(switchMap(() => {
        return this.articuloService.listar();
      })).subscribe(data => {
        this.articuloService.articuloCambio.next(data);
        this.articuloService.mensajeCambio.next('Se registro!');
      });
    }
    this.router.navigate(['articulo']);
  }

}
