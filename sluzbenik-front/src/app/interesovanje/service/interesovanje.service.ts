import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpResponse,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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
  getAll(): Observable<any[]> {
    return this.http.get<any[]>(
      'http://localhost:9090/api/interesovanje/jmbg'
    );
  }
}
