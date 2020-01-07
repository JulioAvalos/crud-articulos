import { LoginComponent } from './pages/login/login.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArticuloComponent } from './pages/articulo/articulo.component';
import { ArticuloEdicionComponent } from './pages/articulo/articulo-edicion/articulo-edicion.component';

const routes: Routes = [
  {
    path: 'articulo', component: ArticuloComponent, children: [
      { path: 'nuevo', component: ArticuloEdicionComponent },
      { path: 'edicion/:id', component: ArticuloEdicionComponent }
    ]
  },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
