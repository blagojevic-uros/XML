import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterServisService {

  constructor(private http: HttpClient) {}
  save(interesovanje: any) {
    return this.http.post(
      'http://localhost:9090/auth/register',
      interesovanje,
      { responseType: 'text' }
    );
  }
}
