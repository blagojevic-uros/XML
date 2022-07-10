import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpResponse,
} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PotvrdaService {

  constructor(private http: HttpClient) {}
  save(potvrda: any) {
    return this.http.post(
      'http://localhost:9090/api/potvrda/save',
      potvrda,
      { responseType: 'text' }
    );
  }
}
