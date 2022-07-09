import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpResponse,
} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ZahtevZaSertifikatService {

  constructor(private http: HttpClient) {}
  save(zahtev: any) {
    return this.http.post(
      'http://localhost:9090/api/zahtev/save',
      zahtev,
      { responseType: 'text' }
    );
  }
}
