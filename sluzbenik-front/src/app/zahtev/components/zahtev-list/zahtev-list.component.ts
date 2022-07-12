import { Component, Input, OnInit, Output,EventEmitter } from '@angular/core';
import { ZahtevService } from '../../service/zahtev.service';

@Component({
  selector: 'app-zahtev-list',
  templateUrl: './zahtev-list.component.html',
  styleUrls: ['./zahtev-list.component.scss']
})
export class ZahtevListComponent implements OnInit {

  razlog: any = '';
  @Input() zahtevi!: any[];
  @Output() zahtevChangeEvent = new EventEmitter();
  constructor(private zahtevService:ZahtevService) { }

  ngOnInit(): void {
  }
  prihvatiZahtev(zahtevId:string){
    this.zahtevChangeEvent.emit();
    this.zahtevService.acceptZahtev(zahtevId).subscribe((res)=>{
      this.zahtevChangeEvent.emit();
      alert(res);

    });
  }
  odbiZahtev(zahtevId:string){
    this.zahtevService.declineZahtev(zahtevId,this.razlog).subscribe((res)=>{
      this.zahtevChangeEvent.emit();
      alert(res);

    });
  }
}
