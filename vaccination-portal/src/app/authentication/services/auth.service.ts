import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from 'src/app/shared/model/login';
import { Token } from 'src/app/shared/model/token';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) {}

  login(auth: Login): Observable<Token> {
    return this.http.post<Token>('http://localhost:9090/auth/login', auth, {
      headers: this.headers,
      responseType: 'json',
    });
  }

  logout(): Observable<string> {
    return this.http.get('http://localhost:9090/auth/logOut', {
      headers: this.headers,
      responseType: 'text',
    });
  }

  isLoggedIn(): boolean {
    if (!localStorage.getItem('user')) {
      return false;
    }
    return true;
  }
}
