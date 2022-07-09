import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-porudzbine',
  templateUrl: './porudzbine.component.html',
  styleUrls: ['./porudzbine.component.scss']
})
export class PorudzbineComponent implements OnInit {
  @Input() porudzbina!: any;
  constructor() { }

  ngOnInit(): void {
  }

}
