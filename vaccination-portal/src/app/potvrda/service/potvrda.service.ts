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
export class PotvrdaService {

  constructor(private http: HttpClient) {}
  save(potvrda: any) {
    return this.http.post(
      'http://localhost:9090/api/potvrda/save',
      potvrda,
      { responseType: 'text' }
    );
  }
  getByJmbg():Observable<any>{
    return this.http.get('http://localhost:9090/api/potvrda/jmbg');
  }
  
  downloadPDF(id:any): any {
    var mediaType = 'application/pdf';
    this.http.get('http://localhost:9090/api/potvrda/generisiPdf/'+id, { responseType: 'blob' }).subscribe(
        (response) => {
            var blob = new Blob([response], { type: mediaType });
            saveAs(blob, 'report.pdf');
        },
    );
}
downloadXhtml(id:any): any {
  var mediaType = '"text/html"';
  this.http.get('http://localhost:9090/api/potvrda/generisiXhtml/'+id, { responseType: 'blob' }).subscribe(
      (response) => {
          var blob = new Blob([response], { type: mediaType });
          saveAs(blob, 'report.html');
      },
  );
}


}
