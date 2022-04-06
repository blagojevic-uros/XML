import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.scss'],
})
export class RegistrationPageComponent implements OnInit {
  registracijaForm!: FormGroup;
  constructor(private fb: FormBuilder) {
    this,
      (this.registracijaForm = this.fb.group({
        ime: ['', Validators.required],
        prezime: ['', Validators.required],
        email: ['', Validators.required],
        jmbg: ['', Validators.required],
      }));
  }

  ngOnInit(): void {}
}
