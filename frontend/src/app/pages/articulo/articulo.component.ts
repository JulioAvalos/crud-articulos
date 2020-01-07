import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatDialog, MatSnackBar } from '@angular/material';
import { Articulo } from './../../_model/articulo.model';
import { ArticuloService } from './../../_service/articulo.service';
import { ArticuloDialogoComponent } from './articulo-dialogo/articulo-dialogo.component';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-articulo',
  templateUrl: './articulo.component.html',
  styleUrls: ['./articulo.component.scss']
})
export class ArticuloComponent implements OnInit {

  dataSource: MatTableDataSource<Articulo>;
  displayedColumns = ['idArticulo', 'descripcion', 'ultimoCosto', 'acciones'];

  constructor(
    private articuloService: ArticuloService,
    private dialog: MatDialog,
    private snack: MatSnackBar,
    public route: ActivatedRoute) { }

  ngOnInit() {
    this.articuloService.listar().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
    });

    this.articuloService.articuloCambio.subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
    });

    this.articuloService.mensajeCambio.subscribe(data => {
      this.snack.open(data, 'Aviso', {
        duration: 2000
      });
    });
  }

  mostrarArticulo(articulo?: Articulo) {
    const art = articulo != null ? articulo : new Articulo();
    this.dialog.open(ArticuloDialogoComponent, {
      width: '350px',
      data: art
    });
  }

  clickMethod(articulo: Articulo) {
    if (confirm(`Desea borrar el articulo: ${articulo.descripcion}?`)) {
      this.eliminar(articulo.idArticulo);
    }
  }

  eliminar(id: number) {
    this.articuloService.eliminar(id).pipe(switchMap(() => {
      return this.articuloService.listar();
    })).subscribe(data => {
      this.articuloService.articuloCambio.next(data);
      this.articuloService.mensajeCambio.next('Se elimino articulo!');
    });
  }

}
