import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bewerber} from "../model/bewerber";

@Injectable({
  providedIn: 'root'
})
export class BewerberService {

  private readonly usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/bewerber';
  }

  public findAll(): Observable<Bewerber[]> {
    return this.http.get<Bewerber[]>(this.usersUrl);
  }

  public save(user: Bewerber) {
    return this.http.post<Bewerber>(this.usersUrl, user);
  }
}
