import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ZahtevRoutingModule } from './zahtev-routing.module';
import { ZahtevComponent } from './pages/zahtev/zahtev.component';
import { ZahtevListComponent } from './components/zahtev-list/zahtev-list.component';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    ZahtevComponent,
    ZahtevListComponent
  ],
  imports: [
    CommonModule,
    ZahtevRoutingModule,
    FormsModule,
    MatCardModule,
    MatButtonModule
  ]
})
export class ZahtevModule { }
