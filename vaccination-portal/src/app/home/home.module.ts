import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { HomeRoutingModule } from './home-routing.module';
import { PacientHomeComponent } from './pages/pacient-home/pacient-home.component';
import { DocumentViewComponent } from './components/document-view/document-view.component';
import { XmlPipe } from './pipes/xml.pipe';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox';
import {MatStepperModule} from '@angular/material/stepper'

import { ReactiveFormsModule } from '@angular/forms';
import { InteresovanjeViewComponent } from './components/interesovanje-view/interesovanje-view.component';
import { SaglasnostViewComponent } from './components/saglasnost-view/saglasnost-view.component';
import { PotvrdaViewComponent } from './components/potvrda-view/potvrda-view.component';
import { SertifikatViewComponent } from './components/sertifikat-view/sertifikat-view.component';
@NgModule({
  declarations: [
    PacientHomeComponent,
    DocumentViewComponent,
    XmlPipe,
    InteresovanjeViewComponent,
    SaglasnostViewComponent,
    PotvrdaViewComponent,
    SertifikatViewComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,MatInputModule,
    ReactiveFormsModule,
    MatStepperModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTooltipModule,
    MatIconModule,
    MatCheckboxModule,
  ]
})
export class HomeModule { }
