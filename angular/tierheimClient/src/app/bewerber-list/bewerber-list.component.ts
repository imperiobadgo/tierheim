import {Component, OnInit} from '@angular/core';
import {Bewerber} from "../model/bewerber";
import {BewerberService} from "../service/bewerber.service";
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-bewerber-list',
  templateUrl: './bewerber-list.component.html',
  styleUrls: ['./bewerber-list.component.css']
})
export class BewerberListComponent implements OnInit {

  bewerber: Bewerber[];
  newName: string;
  routerSubscription;

  constructor(private bewerberService: BewerberService, private router: Router) {
    this.bewerber = [];
    this.newName = '';

    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.routerSubscription = this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        // Trick the Router into believing it's last link wasn't previously loaded
        this.router.navigated = false;
      }
    });
  }

  ngOnInit(): void {
    this.bewerberService.findAll().subscribe(data => {
        this.bewerber = data;
      }
    );
  }

  ngOnDestroy() {
    if (this.routerSubscription) {
      this.routerSubscription.unsubscribe();
    }
  }

  reLoad() {
    this.router.navigate([this.router.url])
  }

  onSubmit() {
    let newBewerber = new Bewerber();
    newBewerber.name = this.newName;
    this.bewerberService.save(newBewerber).subscribe(() => this.reLoad());
  }

  delete(input: Bewerber) {
    this.bewerberService.delete(input).subscribe(() => this.reLoad());
  }
}
