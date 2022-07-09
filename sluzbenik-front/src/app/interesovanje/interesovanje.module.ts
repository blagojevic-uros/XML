import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InteresovanjeRoutingModule } from './interesovanje-routing.module';
import { CreateInterosavenjeComponent } from './pages/create-interosavenje/create-interosavenje.component';
import { InteresovanjeFormComponent } from './components/interesovanje-form/interesovanje-form.component';
import { ReactiveFormsModule } from '@angular/forms';
//material
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { AllInteresovanjaComponent } from './pages/all-interesovanja/all-interesovanja.component';
@NgModule({
  declarations: [CreateInterosavenjeComponent, InteresovanjeFormComponent, AllInteresovanjaComponent],
  imports: [
    CommonModule,
    InteresovanjeRoutingModule,
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
  ],
})
export class InteresovanjeModule {}
