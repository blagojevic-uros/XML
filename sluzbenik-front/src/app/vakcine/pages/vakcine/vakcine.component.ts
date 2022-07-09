import { Component, OnInit } from '@angular/core';
import { VakcineService } from '../../service/vakcine.service';

@Component({
  selector: 'app-vakcine',
  templateUrl: './vakcine.component.html',
  styleUrls: ['./vakcine.component.scss']
})
export class VakcineComponent implements OnInit {

  vakcine!: any[];
  porudzbine!: any[];
  constructor(private vakcineService: VakcineService) {
    vakcineService.getAll().subscribe((res)=>{
      this.vakcine = res;
    })
    vakcineService.getAllPorudzine().subscribe((res)=>{
      this.porudzbine = res;
    })
   }

  ngOnInit(): void {
  }

}
