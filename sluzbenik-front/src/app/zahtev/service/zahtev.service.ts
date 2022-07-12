import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {
  headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
  constructor(private http: HttpClient) { }

  getByJmbg(jmbg:any): Observable<any> {
    return this.http.get<any>(
      'http://localhost:9091/zahtev/pending/'+jmbg
    );
  }

  acceptZahtev(id:any): Observable<string> {
    return this.http.get('http://localhost:9091/zahtev/accept/'+id, {
      headers: this.headers,
      responseType: 'text',
    });
  }
  declineZahtev(id:any,razlog: any): Observable<string> {
    return this.http.get('http://localhost:9091/zahtev/decline/'+id + "/" + razlog, {
      headers: this.headers,
      responseType: 'text',
    });
  }
  // declineZahtev(id:any): Observable<string> {
  //   return this.http.get(
  //     'http://localhost:9091/zahtev/decline/'+id);
  // }
}
