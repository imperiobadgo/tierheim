import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MitarbeiterListComponent } from './mitarbeiter-list/mitarbeiter-list.component';
import {BewerberListComponent} from "./bewerber-list/bewerber-list.component";

const routes: Routes = [
  { path: 'mitarbeiter', component: MitarbeiterListComponent },
  { path: 'bewerber', component: BewerberListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
