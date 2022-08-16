import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MitarbeiterListComponent } from './mitarbeiter-list/mitarbeiter-list.component';

const routes: Routes = [
  { path: 'mitarbeiter', component: MitarbeiterListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
