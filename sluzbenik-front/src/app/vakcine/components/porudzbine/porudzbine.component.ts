import { Component, Input, OnInit } from '@angular/core';
import { VakcineService } from '../../service/vakcine.service';

@Component({
  selector: 'app-porudzbine',
  templateUrl: './porudzbine.component.html',
  styleUrls: ['./porudzbine.component.scss']
})
export class PorudzbineComponent implements OnInit {
  @Input() porudzbina!: any;
  constructor(private vakcineService:VakcineService) { }

  ngOnInit(): void {
  }

  finishPorudzbina(id:any){
    this.vakcineService.finishPorudzbina(id).subscribe((res)=>{

    });

  }
}
