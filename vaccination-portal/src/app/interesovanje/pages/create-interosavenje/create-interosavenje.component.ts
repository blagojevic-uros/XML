import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { InteresovanjeService } from '../../service/interesovanje.service';

@Component({
  selector: 'app-create-interosavenje',
  templateUrl: './create-interosavenje.component.html',
  styleUrls: ['./create-interosavenje.component.scss'],
})
export class CreateInterosavenjeComponent implements OnInit {
  interesovanjeForm!: FormGroup;
  currentDate: string = new Date().toISOString().split('T')[0];
  constructor(
    private fb: FormBuilder,
    private interesovanjeService: InteresovanjeService,
    private _snackBar: MatSnackBar
  ) {
    this.interesovanjeForm = this.fb.group({
      licniPodaci: this.fb.group({
        drzavljanstvo: this.fb.group({
          value: ['', Validators.required],
        }),
        jmbg: this.fb.group({
          value: ['', Validators.required],
        }),
        ime: ['', Validators.required],
        prezime: ['', Validators.required],
        email: ['', Validators.required],
        mobilniTelefon: ['', Validators.required],
        fiksniTelefon: ['', Validators.required],
      }),
      lokacijaVakcinisanja: this.fb.group({
        value: ['', Validators.required],
      }),
      tipVakcine: this.fb.group({
        value: ['', Validators.required],
      }),
      datum: this.fb.group({
        value: [this.currentDate],
      }),
      potpis: ['', Validators.required],
      davalacKrvi: false,
      id: ['12345'],
    });
  }
  onSubmit() {
    this.interesovanjeService
      .save(this.interesovanjeForm.value)
      .subscribe((res: string) => {
        this._snackBar.open(res, 'Close');
      });
  }
  ngOnInit(): void {}
}