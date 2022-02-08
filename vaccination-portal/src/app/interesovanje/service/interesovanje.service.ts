import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpResponse,
} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class InteresovanjeService {
  constructor(private http: HttpClient) {}
  save(interesovanje: any) {
    return this.http.post(
      'http://localhost:9090/api/interesovanje/save',
      interesovanje,
      { responseType: 'text' }
    );
  }
}
