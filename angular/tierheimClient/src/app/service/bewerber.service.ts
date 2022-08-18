import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Bewerber} from "../model/bewerber";

@Injectable({
  providedIn: 'root'
})
export class BewerberService {

  private readonly url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/api/bewerber';
  }

  public findAll(): Observable<Bewerber[]> {
    return this.http.get<Bewerber[]>(this.url);
  }

  public getById(id: string): Observable<Bewerber> {
    return this.http.get<Bewerber>(this.url + "/" + id);
  }

  public edit(input: Bewerber){
    return this.http.put<Bewerber>(this.url + "/" + input.id, input);
  }

  public save(input: Bewerber) {
    return this.http.post<Bewerber>(this.url, input);
  }

  public delete(input: Bewerber) {
    return this.http.delete<Bewerber>(this.url + "/" + input.id);
  }

}
