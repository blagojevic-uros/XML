import { Component, OnInit } from '@angular/core';
import { InteresovanjeService } from '../../service/interesovanje.service';

@Component({
  selector: 'app-all-interesovanja',
  templateUrl: './all-interesovanja.component.html',
  styleUrls: ['./all-interesovanja.component.scss']
})
export class AllInteresovanjaComponent implements OnInit {


  interesovanja!: any[];
  constructor(private interesovanjeService: InteresovanjeService) { 
    interesovanjeService.getAll().subscribe((res: any)=>{
      this.interesovanja = res;
    })
  }

  ngOnInit(): void {

  }

}
