import { Component, Input, OnInit } from '@angular/core';
import { SaglasnostService } from 'src/app/saglasnost/service/saglasnost.service';

@Component({
  selector: 'app-saglasnost-view',
  templateUrl: './saglasnost-view.component.html',
  styleUrls: ['./saglasnost-view.component.scss']
})
export class SaglasnostViewComponent implements OnInit {

  @Input() saglasnost: any;
  constructor(private saglasnostService:SaglasnostService) { }

  ngOnInit(): void {
  }

  getPdf(){
    this.saglasnostService.downloadPDF();
  }
  getXhtml(){
    this.saglasnostService.downloadXhtml();
  }

}
