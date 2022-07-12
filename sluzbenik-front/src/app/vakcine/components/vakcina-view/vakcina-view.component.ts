import { Component, Input, OnInit } from '@angular/core';
import { VakcineService } from '../../service/vakcine.service';

@Component({
  selector: 'app-vakcina-view',
  templateUrl: './vakcina-view.component.html',
  styleUrls: ['./vakcina-view.component.scss']
})
export class VakcinaViewComponent implements OnInit {


  @Input() vakcina!: any;
  
  constructor(private vakcinaService:VakcineService) { }

  ngOnInit(): void {
  }
  updateKolicina(naziv:any,kolicina:any){
    this.vakcinaService.updateKolicinaVakcina(naziv,kolicina).subscribe((res)=>{
      
    })
  }
}
