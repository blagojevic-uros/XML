import { Component, OnInit } from '@angular/core';
import { ZahtevService } from '../../service/zahtev.service';

@Component({
  selector: 'app-zahtev',
  templateUrl: './zahtev.component.html',
  styleUrls: ['./zahtev.component.scss']
})
export class ZahtevComponent implements OnInit {

  zahtevi: any[] = [];
  searchInput: any = '';
  constructor(private zahtevService: ZahtevService) { 
  }

  ngOnInit(): void {
  }

  searchJmbg(){
    this.zahtevService.getByJmbg(this.searchInput).subscribe((res) =>{
      this.zahtevi = res;
    })
  }
}
