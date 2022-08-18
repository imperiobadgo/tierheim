import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {MitarbeiterListComponent} from "./mitarbeiter-list/mitarbeiter-list.component";
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {MitarbeiterService} from "./service/mitarbeiter.service";
import { BewerberListComponent } from './bewerber-list/bewerber-list.component';
import {BewerberService} from "./service/bewerber.service";
import { BewerberEditComponent } from './bewerber-edit/bewerber-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    MitarbeiterListComponent,
    BewerberListComponent,
    BewerberEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    MitarbeiterService,
    BewerberService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
