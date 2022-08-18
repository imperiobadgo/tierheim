import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Mitarbeiter} from "../model/mitarbeiter";

@Injectable()
export class MitarbeiterService {

  private readonly url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/api/mitarbeiter';
  }

  public findAll(): Observable<Mitarbeiter[]> {
    return this.http.get<Mitarbeiter[]>(this.url);
  }

  public getById(id: string): Observable<Mitarbeiter> {
    return this.http.get<Mitarbeiter>(this.url + "/" + id);
  }

  public edit(input: Mitarbeiter){
    return this.http.put<Mitarbeiter>(this.url + "/" + input.id, input);
  }

  public save(input: Mitarbeiter) {
    return this.http.post<Mitarbeiter>(this.url, input);
  }
}
