import { Component, OnInit } from '@angular/core';
import { InteresovanjeService } from 'src/app/interesovanje/service/interesovanje.service';
import { SaglasnostService } from 'src/app/saglasnost/service/saglasnost.service';
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
  constructor(private interesovanjeService: InteresovanjeService,private sertifikatService:SertifikatService,private saglasnostService: SaglasnostService) { 
    interesovanjeService.getAll().subscribe((res) => {
      this.interesovanje = res;
    })
    saglasnostService.getSaglasnost().subscribe((res)=>{
      this.saglasnost  = res;
    })
    sertifikatService.getAll().subscribe((res) =>{
      this.sertifikati = res;
    })


  }

  ngOnInit(): void {
  }

}
