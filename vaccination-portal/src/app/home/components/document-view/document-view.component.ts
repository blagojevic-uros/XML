import { Component, OnInit } from '@angular/core';
import { InteresovanjeService } from 'src/app/interesovanje/service/interesovanje.service';
import { SertifikatService } from 'src/app/sertifikat/service/sertifikat.service';

@Component({
  selector: 'app-document-view',
  templateUrl: './document-view.component.html',
  styleUrls: ['./document-view.component.scss']
})
export class DocumentViewComponent implements OnInit {

  interesovanje!: any;
  saglasnost!: any;
  sertifikati!: any[];
  constructor(private interesovanjeService: InteresovanjeService,private sertifikatService:SertifikatService) { 
    interesovanjeService.getAll().subscribe((res) => {
      this.interesovanje = res;
    })
    sertifikatService.getAll().subscribe((res) =>{
      this.sertifikati = res;
    })

  }

  ngOnInit(): void {
  }

}
