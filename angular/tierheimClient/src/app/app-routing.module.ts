import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MitarbeiterListComponent } from './mitarbeiter-list/mitarbeiter-list.component';
import {BewerberListComponent} from "./bewerber-list/bewerber-list.component";
import {BewerberEditComponent} from "./bewerber-edit/bewerber-edit.component";

const routes: Routes = [
  { path: 'mitarbeiter', component: MitarbeiterListComponent },
  { path: 'bewerber', component: BewerberListComponent },
  { path: 'bewerber/:id', component: BewerberEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
