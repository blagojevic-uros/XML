import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SertifikatRoutingModule } from './sertifikat-routing.module';
import { SertifikatFormComponent } from './components/sertifikat-form/sertifikat-form.component';
import { CreateSertifikatComponent } from './pages/create-sertifikat/create-sertifikat.component';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    SertifikatFormComponent,
    CreateSertifikatComponent
  ],
  imports: [
    CommonModule,
    SertifikatRoutingModule,
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    FormsModule,
    MatNativeDateModule,
    MatTooltipModule,
    MatIconModule,
    MatCheckboxModule,
  ]
})
export class SertifikatModule { }
