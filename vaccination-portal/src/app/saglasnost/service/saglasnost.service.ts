import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpResponse,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { saveAs } from 'file-saver';
@Injectable({
  providedIn: 'root'
})
export class SaglasnostService {

  constructor(private http: HttpClient) { }

  checkIfExist(id: string): Observable<any> {
    return this.http.get<any>("http://localhost:9090/api/interesovanje/" + id
    )
  }
  save(saglasnost: any) {
    return this.http.post(
      'http://localhost:9090/api/saglasnost/save',
      saglasnost,
      { responseType: 'text' }
    );
  }
  getSaglasnost(): Observable<any> {
    return this.http.get<any>("http://localhost:9090/api/saglasnost/jmbg")
  }
  downloadPDF(): any {
    var mediaType = 'application/pdf';
    this.http.get('http://localhost:9090/api/saglasnost/generisiPdf/123', { responseType: 'blob' }).subscribe(
        (response) => {
            var blob = new Blob([response], { type: mediaType });
            saveAs(blob, 'report.pdf');
        },
        e => { throwError(e); }
    );
  }
  downloadXhtml(): any {
    var mediaType = '"text/html"';
    this.http.get('http://localhost:9090/api/saglasnost/generisiXhtml/123', { responseType: 'blob' }).subscribe(
        (response) => {
            var blob = new Blob([response], { type: mediaType });
            saveAs(blob, 'report.html');
        },
        e => { throwError(e); }
    );
  }
}
