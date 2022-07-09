import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ZahtevZaSertifikatRoutingModule } from './zahtev-za-sertifikat-routing.module';
import { ZahtevFormComponent } from './components/zahtev-form/zahtev-form.component';
import { ZahtevPageComponent } from './pages/zahtev-page/zahtev-page.component';

import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox';


@NgModule({
  declarations: [
    ZahtevFormComponent,
    ZahtevPageComponent
  ],
  imports: [
    CommonModule,
    ZahtevZaSertifikatRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatTooltipModule,
    MatIconModule,
    MatCheckboxModule,
  ]
})
export class ZahtevZaSertifikatModule { }
