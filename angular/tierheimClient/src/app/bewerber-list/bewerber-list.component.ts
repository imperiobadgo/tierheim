import {Component, OnInit} from '@angular/core';
import {Bewerber} from "../model/bewerber";
import {BewerberService} from "../service/bewerber.service";

@Component({
  selector: 'app-bewerber-list',
  templateUrl: './bewerber-list.component.html',
  styleUrls: ['./bewerber-list.component.css']
})
export class BewerberListComponent implements OnInit {

  bewerber: Bewerber[];

  constructor(private bewerberService: BewerberService) {
    this.bewerber = [];
  }

  ngOnInit(): void {
    this.bewerberService.findAll().subscribe(data => {
        this.bewerber = data;
      }
    );
  }

}
