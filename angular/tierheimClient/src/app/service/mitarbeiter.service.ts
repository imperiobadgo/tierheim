import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Mitarbeiter} from "../model/mitarbeiter";

@Injectable()
export class MitarbeiterService {

  private readonly usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/mitarbeiter';
  }

  public findAll(): Observable<Mitarbeiter[]> {
    return this.http.get<Mitarbeiter[]>(this.usersUrl);
  }

  public save(user: Mitarbeiter) {
    return this.http.post<Mitarbeiter>(this.usersUrl, user);
  }
}
