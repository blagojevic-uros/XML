import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegistrationService } from '../../service/registration.service';


@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.scss'],
})
export class RegistrationFormComponent implements OnInit {
  registracijaForm!: FormGroup;
  @Output() submitFormEvent = new EventEmitter();
  constructor(private fb: FormBuilder, private registrovanjeService: RegistrationService) 
  {
    (this.registracijaForm = this.fb.group({
      ime: ['', Validators.required],
      prezime: ['', Validators.required],
      datumRodjenja: ['', Validators.required],
      jmbg: ['', Validators.required],
      brojPasosa: ['', Validators.required],
      email: ['', Validators.required],
      mobilniTelefon: ['', Validators.required],
      fiksniTelefon: ['', Validators.required],
      adresa: ['', Validators.required],
      postanskiBroj: ['', Validators.required],
      mesto: ['', Validators.required],
      opstina: ['', Validators.required],
      sifra: ['', Validators.required]
    }));
  }

  ngOnInit(): void {}
  onSubmit() {

    this.registrovanjeService
      .save(this.registracijaForm.value)
      .subscribe((res: string) => {
      });

  }
}