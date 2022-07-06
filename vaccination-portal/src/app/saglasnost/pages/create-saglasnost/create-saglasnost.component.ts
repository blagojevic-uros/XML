import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SaglasnostService } from '../../service/saglasnost.service';

@Component({
  selector: 'app-create-saglasnost',
  templateUrl: './create-saglasnost.component.html',
  styleUrls: ['./create-saglasnost.component.scss']
})
export class CreateSaglasnostComponent implements OnInit {
  saglasnostForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private saglasnostService: SaglasnostService,
    private _snackBar: MatSnackBar
  ) {
    this.saglasnostForm = this.fb.group({
      licniPodaci: this.fb.group({
        // drzavljanstvo: this.fb.group({
        //   value: ['', Validators.required],
        // }),
        jmbg: this.fb.group({
          value: [''],
        }),

        brPasosa: this.fb.group({
          valueStrani: [''],
          valueBrPasosa: [''],
        }),
        prezime: ['', Validators.required],
        ime: ['', Validators.required],
        imeRoditelja: ['', Validators.required],
        pol: ['', Validators.required],
        datumRodjenja: ['', Validators.required],
        mestoRodjenja: ['', Validators.required],
        adresa: this.fb.group({
          ulicaBroj: ['', Validators.required],
          mestoNaselje: ['', Validators.required],
          opstinaGrad: ['', Validators.required],
        }),
        fiksniBroj: [''],
        mobilniBroj: ['', Validators.required],
        email: ['', Validators.required],
        radniStatus: ['', Validators.required],
        zanimanjeZaposlenog: ['', Validators.required],
        // radniStatus: this.fb.group({
        //   value: ['']
        // }),
        // zanimanjeZaposlenog: this.fb.group({
        //   value: ['']
        // }),
        korisnikSocZastite: this.fb.group({
          value: [''],
        }),
      }),

    })
  }

  ngOnInit(): void {
    this.saglasnostService
      .checkIfExist("2894536f-4c48-4843-a5a3-0a3b1a52e1f8")
      .subscribe((res: string) => {
        console.log(res)
      });
  }
  onSubmit() {
    this.saglasnostService
      .save(this.saglasnostForm.value)
      .subscribe((res: string) => {
        this._snackBar.open(res, 'Close');
      });
  }

}
