import { Component, OnInit } from '@angular/core';
import {Mitarbeiter} from "../model/mitarbeiter";
import {MitarbeiterService} from "../service/mitarbeiter.service";

@Component({
  selector: 'app-mitarbeiter-list',
  templateUrl: './mitarbeiter-list.component.html',
  styleUrls: ['./mitarbeiter-list.component.css']
})
export class MitarbeiterListComponent implements OnInit {

  mitarbeiter: Mitarbeiter[];

  constructor(private mitarbeiterService: MitarbeiterService) {
    this.mitarbeiter = [];
  }

  ngOnInit(): void {
    this.mitarbeiterService.findAll().subscribe(data => {
      this.mitarbeiter = data;
    })
  }

}
