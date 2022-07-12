import { Component, Input, OnInit } from '@angular/core';
import { InteresovanjeService } from 'src/app/interesovanje/service/interesovanje.service';

@Component({
  selector: 'app-interesovanje-view',
  templateUrl: './interesovanje-view.component.html',
  styleUrls: ['./interesovanje-view.component.scss']
})
export class InteresovanjeViewComponent implements OnInit {


  @Input() interesovanje: any;
  
  constructor(private interesovanjeService: InteresovanjeService) { }

  ngOnInit(): void {
  }

  getPdf(id:any){
    this.interesovanjeService.downloadPDF(id).subscribe(() =>{
      
    });
  }
  getXhtml(id:any){
    this.interesovanjeService.downloadXhtml(id).subscribe(() =>{
      
    });
  }
}
