import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IzvestajRoutingModule } from './izvestaj-routing.module';
import { IzvestajComponent } from './pages/izvestaj/izvestaj.component';


@NgModule({
  declarations: [
    IzvestajComponent
  ],
  imports: [
    CommonModule,
    IzvestajRoutingModule
  ]
})
export class IzvestajModule { }
