import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
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
    PotvrdaRoutingModule,
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
export class PotvrdaModule { }
