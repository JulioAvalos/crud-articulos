import { Articulo } from './../../../_model/articulo.model';
import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-articulo-dialogo',
  templateUrl: './articulo-dialogo.component.html',
  styleUrls: ['./articulo-dialogo.component.scss']
})
export class ArticuloDialogoComponent implements OnInit {

  articulo: Articulo;

  defaultImage: string = 'assets/img/img-placeholder.png';

  constructor(
    private dialogRef: MatDialogRef<ArticuloDialogoComponent>,
    @Inject(MAT_DIALOG_DATA) private data: Articulo
  ) { }

  ngOnInit() {
    this.articulo = new Articulo();
    this.articulo = { ...this.data };
  }

  operar() { }

  cancelar() {
    this.dialogRef.close();
  }

}
