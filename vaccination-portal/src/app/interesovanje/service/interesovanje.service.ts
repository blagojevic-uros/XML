import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpResponse,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { saveAs } from 'file-saver';
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
  getPdf(): Observable<any>{
    return this.http.get<any>(
      'http://localhost:9090/api/interesovanje/generisiPdf/5c3244ad-be8c-43eb-b098-8fc283a4c445'
    );
  }
  downloadPDF(id:any): any {
    var mediaType = 'application/pdf';
    this.http.get('http://localhost:9090/api/interesovanje/generisiPdf/'+id, { responseType: 'blob' }).subscribe(
        (response) => {
            var blob = new Blob([response], { type: mediaType });
            saveAs(blob, 'report.pdf');
        },
        e => { throwError(e); }
    );
}
downloadXhtml(id:any): any {
  var mediaType = '"text/html"';
  this.http.get('http://localhost:9090/api/interesovanje/generisiXhtml/'+id, { responseType: 'blob' }).subscribe(
      (response) => {
          var blob = new Blob([response], { type: mediaType });
          saveAs(blob, 'report.html');
      },
      e => { throwError(e); }
  );
}
}
