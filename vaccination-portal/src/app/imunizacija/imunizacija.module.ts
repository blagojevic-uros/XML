import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ImunizacijaRoutingModule } from './imunizacija-routing.module';
import { CreateImunizacijaComponent } from './pages/create-imunizacija/create-imunizacija.component';
import { ImunizacijaFormComponent } from './components/imunizacija-form/imunizacija-form.component';
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
@NgModule({
  declarations: [CreateImunizacijaComponent, ImunizacijaFormComponent],
  imports: [
    CommonModule,
    ImunizacijaRoutingModule,
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
  ],
})
export class ImunizacijaModule {}
