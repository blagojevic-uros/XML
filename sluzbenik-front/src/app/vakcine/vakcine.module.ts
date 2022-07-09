import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VakcineRoutingModule } from './vakcine-routing.module';
import { VakcineComponent } from './pages/vakcine/vakcine.component';
import { VakcinaViewComponent } from './components/vakcina-view/vakcina-view.component';
import { PorudzbineComponent } from './components/porudzbine/porudzbine.component';


@NgModule({
  declarations: [
    VakcineComponent,
    VakcinaViewComponent,
    PorudzbineComponent
  ],
  imports: [
    CommonModule,
    VakcineRoutingModule
  ]
})
export class VakcineModule { }
