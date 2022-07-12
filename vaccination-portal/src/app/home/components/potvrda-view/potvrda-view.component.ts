import { Component, Input, OnInit } from '@angular/core';
import { PotvrdaService } from 'src/app/potvrda/service/potvrda.service';

@Component({
  selector: 'app-potvrda-view',
  templateUrl: './potvrda-view.component.html',
  styleUrls: ['./potvrda-view.component.scss']
})
export class PotvrdaViewComponent implements OnInit {

  constructor(private potvrdaService:PotvrdaService) { }
  @Input() potvrde!: any[];
  ngOnInit(): void {
  }

  getPdf(id:any){
    this.potvrdaService.downloadPDF(id).subscribe(() =>{
      
    });
  }
  getXhtml(id:any){
    this.potvrdaService.downloadXhtml(id).subscribe(() =>{
      
    });
  }
}
