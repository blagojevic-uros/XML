import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormBuilder, Validators } from '@angular/forms';
import {ZahtevZaSertifikatService} from '../../service/zahtev-za-sertifikat.service'

@Component({
  selector: 'app-zahtev-page',
  templateUrl: './zahtev-page.component.html',
  styleUrls: ['./zahtev-page.component.scss']
})
export class ZahtevPageComponent implements OnInit {
  zahtevForm!: FormGroup;
  currentDate: string = new Date().toISOString().split('T')[0];
  constructor(
    private fb: FormBuilder,
    private zahtevService: ZahtevZaSertifikatService,
  ) {
    this.zahtevForm = this.fb.group({
      licniPodaci: this.fb.group({
        imePrezime: this.fb.group({
            ime: ['', Validators.required],
            prezime: ['', Validators.required],
        }),
        datumRodjenja: ['', Validators.required],
        pol:  ['M', Validators.required],
        jmbg: this.fb.group({
          value: ['', Validators.required],
        }),
        brojPasosa: ['', Validators.required],
      }),
      razlogZaZahtev:  ['', Validators.required],
      mesto: this.fb.group({
        value: ['', Validators.required],
      }),
      datum:  [this.currentDate],
      potpis: ['', Validators.required]
    });
  }
  onSubmit() {
    this.zahtevService
      .save(this.zahtevForm.value)
      .subscribe((res: string) => {
      });
  }
  ngOnInit(): void {
  }

}
