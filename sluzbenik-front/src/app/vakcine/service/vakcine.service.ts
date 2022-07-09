import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VakcineService {

  constructor(private http: HttpClient) { }


  getAll(): Observable<any[]> {
    return this.http.get<any[]>(
      'http://localhost:9091/vakcine/all'
    );
  }
  getAllPorudzine(): Observable<any[]> {
    return this.http.get<any[]>(
      'http://localhost:9091/vakcine/porudzbine'
    );
  }
}
