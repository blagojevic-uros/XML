import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.scss'],
})
export class RegistrationFormComponent implements OnInit {
  @Input() registracijaForm!: FormGroup;
  @Output() submitFormEvent = new EventEmitter();
  constructor(private fb: FormBuilder) 
  {
    this.registracijaForm = this.fb.group({
      licniPodaci: this.fb.group({
        ime: this.fb.group({
          value: ['', Validators.required],
        }),
        prezime: this.fb.group({
          value: ['', Validators.required],
        }),
        datumRodjenja: this.fb.group({
          value: ['', Validators.required],
        }),
        jmbg: this.fb.group({
          value: ['', Validators.required],
        }),
        brojPasosa: this.fb.group({
          value: ['', Validators.required],
        }),
        email: this.fb.group({
          value: ['', Validators.required],
        }),
        brojTelefona: this.fb.group({
          value: ['', Validators.required],
        }),
        fiksniTelefon: this.fb.group({
          value: ['', Validators.required],
        }),
      }),
    });
  }

  ngOnInit(): void {}
  onSubmit() {}
}