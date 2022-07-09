import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImunizacijaService {
  constructor(private http: HttpClient) {}
  save(interesovanje: any) {
    return this.http.post(
      'http://localhost:9090/api/interesovanje/save',
      interesovanje,
      { responseType: 'text' }
    );
  }
  getSaglasnost(jmbg : string | number){
  const params = new HttpParams().append('jmbg', jmbg);
    return this.http.get(
      'http://localhost:9090/api/saglasnost',
      { responseType: 'text',params }
    );
  }
}
