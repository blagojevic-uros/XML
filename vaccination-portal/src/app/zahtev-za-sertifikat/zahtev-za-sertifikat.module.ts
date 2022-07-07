import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ZahtevZaSertifikatRoutingModule } from './zahtev-za-sertifikat-routing.module';
import { ZahtevFormComponent } from './components/zahtev-form/zahtev-form.component';
import { ZahtevPageComponent } from './pages/zahtev-page/zahtev-page.component';


@NgModule({
  declarations: [
    ZahtevFormComponent,
    ZahtevPageComponent
  ],
  imports: [
    CommonModule,
    ZahtevZaSertifikatRoutingModule
  ]
})
export class ZahtevZaSertifikatModule { }
