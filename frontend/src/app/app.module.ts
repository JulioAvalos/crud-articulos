import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './material/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ArticuloComponent } from './pages/articulo/articulo.component';
import { HttpClientModule } from '@angular/common/http';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ArticuloEdicionComponent } from './pages/articulo/articulo-edicion/articulo-edicion.component';
import { ArticuloDialogoComponent } from './pages/articulo/articulo-dialogo/articulo-dialogo.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './pages/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    ArticuloComponent,
    ArticuloEdicionComponent,
    ArticuloDialogoComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    AppRoutingModule,
    MaterialModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [ArticuloDialogoComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
