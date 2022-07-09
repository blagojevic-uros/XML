import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-vakcina-view',
  templateUrl: './vakcina-view.component.html',
  styleUrls: ['./vakcina-view.component.scss']
})
export class VakcinaViewComponent implements OnInit {


  @Input() vakcina!: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
