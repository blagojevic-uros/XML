import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PotvrdaRoutingModule } from './potvrda-routing.module';
import { PotvrdaFormComponent } from './components/potvrda-form/potvrda-form.component';
import { PotvrdaComponent } from './pages/potvrda/potvrda.component';


@NgModule({
  declarations: [
    PotvrdaFormComponent,
    PotvrdaComponent
  ],
  imports: [
    CommonModule,
    PotvrdaRoutingModule
  ]
})
export class PotvrdaModule { }
