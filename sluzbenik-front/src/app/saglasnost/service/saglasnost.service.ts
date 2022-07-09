import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpResponse,
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SaglasnostService {

  constructor(private http: HttpClient) { }

  checkIfExist(id: string): Observable<any> {
    return this.http.get<any>("http://localhost:9090/api/interesovanje/" + id
    )
  }
  save(saglasnost: any) {
    return this.http.post(
      'http://localhost:9090/api/saglasnost/save',
      saglasnost,
      { responseType: 'text' }
    );
  }
}
