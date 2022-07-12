import { Component, Input, OnInit } from '@angular/core';
import { SertifikatService } from 'src/app/sertifikat/service/sertifikat.service';

@Component({
  selector: 'app-sertifikat-view',
  templateUrl: './sertifikat-view.component.html',
  styleUrls: ['./sertifikat-view.component.scss']
})
export class SertifikatViewComponent implements OnInit {

  @Input() sertifikati!: any[];
  constructor(private sertifikatService:SertifikatService) { }

  ngOnInit(): void {
  }
  getPdf(id:any){
    this.sertifikatService.downloadPDF(id).subscribe(() =>{
      
    });
  }
  getXhtml(id:any){
    this.sertifikatService.downloadXhtml(id).subscribe(() =>{
      
    });
  }
}
