import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { saveAs } from 'file-saver';
@Injectable({
  providedIn: 'root'
})
export class SertifikatService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any[]> {
    return this.http.get<any[]>(
      'http://localhost:9090/api/sertifikat/all'
    );
  }
  downloadPDF(id:any): any {
    var mediaType = 'application/pdf';
    this.http.get('http://localhost:9090/api/sertifikat/generisiPdf/'+id, { responseType: 'blob' }).subscribe(
        (response) => {
            var blob = new Blob([response], { type: mediaType });
            saveAs(blob, 'report.pdf');
        },
    );
}
downloadXhtml(id:any): any {
  var mediaType = '"text/html"';
  this.http.get('http://localhost:9090/api/sertifikat/generisiXhtml/'+id, { responseType: 'blob' }).subscribe(
      (response) => {
          var blob = new Blob([response], { type: mediaType });
          saveAs(blob, 'report.html');
      },
  );
}
}
