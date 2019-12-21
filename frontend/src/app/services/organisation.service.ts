import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Organisation} from "../modules/organisation";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OrganisationService {

  constructor(private http : HttpClient) { }

  getOrganisation(id: number): Observable<Organisation>{
    return this.http.get<Organisation>('/api/organisation/' + id);
  }
}
