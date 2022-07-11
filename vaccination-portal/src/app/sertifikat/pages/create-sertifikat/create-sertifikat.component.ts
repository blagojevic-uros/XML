import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SertifikatService } from '../../service/sertifikat.service';

@Component({
  selector: 'app-create-sertifikat',
  templateUrl: './create-sertifikat.component.html',
  styleUrls: ['./create-sertifikat.component.scss']
})
export class CreateSertifikatComponent implements OnInit {
  sertifikatForm!: FormGroup;
  constructor(
    private fb: FormBuilder,
    private sertifikatService: SertifikatService,
  ) {
    this.sertifikatForm = this.fb.group({
      datumIzdavanja: this.fb.group({
        value: ['', Validators.required],
      }),
      qrCode: ['', Validators.required],
      brojSertifikata:  ['', Validators.required],
      licniPodaci: this.fb.group({
        imePrezime: this.fb.group({
          ime: ['', Validators.required],
          prezime: ['', Validators.required],
        }),
        jmbg: ['', Validators.required],
        pol:  ['', Validators.required],
        brojPasosa: ['', Validators.required],
      }),
      izdavacSertifikata: this.fb.group({
        value: ['', Validators.required],
      }),
      prelezana: this.fb.group({
        datumPozitivnog: ['', Validators.required],
        laboratorija: ['', Validators.required],
      }),
      potvrdaOVakcinisanju: ['', Validators.required],
      zahtevZaSertifikat:  ['', Validators.required],
    });
  }
  

  ngOnInit(): void {
  }
  logout() {
    localStorage.removeItem('user');
    location.reload();
  }
  onSubmit() {
    console.log(this.sertifikatForm.value)
  }
}
