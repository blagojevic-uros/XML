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
import { CreateSaglasnostComponent } from './pages/create-saglasnost/create-saglasnost.component';
import { SaglasnostFormComponent } from './components/saglasnost-form/saglasnost-form.component';
import { SaglasnostRoutingModule } from './saglasnost-routing.module';
@NgModule({
    declarations: [CreateSaglasnostComponent, SaglasnostFormComponent],
    imports: [
        CommonModule,
        SaglasnostRoutingModule,
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
export class SaglasnostModule { }
