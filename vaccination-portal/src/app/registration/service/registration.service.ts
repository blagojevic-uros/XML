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
export class RegistrationService {

  constructor(private http: HttpClient) { }

  save(register: any){
    return this.http.post(
      'http://localhost:9090/api/registrovanje/save',
      register,
      { responseType: 'text' }
    );
  }

}
