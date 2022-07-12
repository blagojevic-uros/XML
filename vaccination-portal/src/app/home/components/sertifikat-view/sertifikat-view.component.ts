import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-sertifikat-view',
  templateUrl: './sertifikat-view.component.html',
  styleUrls: ['./sertifikat-view.component.scss']
})
export class SertifikatViewComponent implements OnInit {

  @Input() sertifikati!: any[];
  constructor() { }

  ngOnInit(): void {
  }
  getPdf(id:any){
    // this.interesovanjeService.downloadPDF(id).subscribe(() =>{
      
    // });
  }
  getXhtml(id:any){
    // this.interesovanjeService.downloadXhtml(id).subscribe(() =>{
      
    // });
  }
}
