import { Component, OnInit } from '@angular/core';
import {Bewerber} from "../model/bewerber";
import {ActivatedRoute, Router} from "@angular/router";
import {BewerberService} from "../service/bewerber.service";

@Component({
  selector: 'app-bewerber-edit',
  templateUrl: './bewerber-edit.component.html',
  styleUrls: ['./bewerber-edit.component.css']
})
export class BewerberEditComponent implements OnInit {

  bewerber: Bewerber;
  id: string;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bewerberService: BewerberService) {
    this.bewerber = <Bewerber>{};
    this.id = "";
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.bewerberService.getById(this.id).subscribe(data => {
        this.bewerber = data;
      });
    });
  }

  onSubmit() {
    this.bewerberService.edit(this.bewerber).subscribe(() => this.gotoBewerberList());
  }

  gotoBewerberList() {
    this.router.navigate(['/bewerber']);
  }

}
