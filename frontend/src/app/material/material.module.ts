import { NgModule } from '@angular/core';
// import { CommonModule } from '@angular/common';

import {
  MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule, MatCardModule, MatButtonModule,
  MatMenuModule, MatFormFieldModule, MatTableModule, MatPaginatorModule, MatDialogModule, MatInputModule, 
  MatGridListModule, MatSnackBarModule
} from '@angular/material';

@NgModule({
  imports: [
    // CommonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    MatMenuModule,
    MatFormFieldModule,
    MatTableModule,
    MatPaginatorModule,
    MatDialogModule,
    MatInputModule,
    MatGridListModule,
    MatSnackBarModule
  ],
  exports: [
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    MatMenuModule,
    MatFormFieldModule,
    MatTableModule,
    MatPaginatorModule,
    MatDialogModule,
    MatInputModule,
    MatGridListModule,
    MatSnackBarModule
  ]
})
export class MaterialModule { }
