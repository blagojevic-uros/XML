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

  getPdf(){
    this.interesovanjeService.downloadPDF().subscribe(() =>{
      
    });
  }
  getXhtml(){
    this.interesovanjeService.downloadXhtml().subscribe(() =>{
      
    });
  }
}
