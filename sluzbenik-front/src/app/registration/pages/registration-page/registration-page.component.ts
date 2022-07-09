import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RegisterServisService } from '../../service/register-servis.service';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.scss'],
})
export class RegistrationPageComponent implements OnInit {
  registracijaForm!: FormGroup;
  constructor(
    private fb: FormBuilder,
    private registrationService : RegisterServisService,
    private _snackBar: MatSnackBar
  ) {
    this,
      (this.registracijaForm = this.fb.group({
        ime: ['', Validators.required],
        prezime: ['', Validators.required],
        username: ['', Validators.required],
        password: ['', Validators.required],
        jmbg: ['', Validators.required],
        passportNumber: ['', Validators.required],
      }));
  }
  onSubmit() { 
    console.log("CLICK")
    this.registrationService
      .save(this.registracijaForm.value)
      .subscribe((res: string) => {
        this._snackBar.open(res, 'Close');
      });
  }
  ngOnInit(): void {}
}
