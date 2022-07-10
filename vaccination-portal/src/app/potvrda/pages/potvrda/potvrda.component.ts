import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormBuilder, Validators } from '@angular/forms';
import {PotvrdaService} from '../../service/potvrda.service'

@Component({
  selector: 'app-potvrda',
  templateUrl: './potvrda.component.html',
  styleUrls: ['./potvrda.component.scss']
})
export class PotvrdaComponent implements OnInit {
  potvrdaForm!: FormGroup;
  currentDate: string = new Date().toISOString().split('T')[0];
  constructor(
    private fb: FormBuilder,
    private potvrdaService: PotvrdaService,
  ) {
    this.potvrdaForm = this.fb.group({
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
      }),
      informacijaVakcinacije: this.fb.group({
        informacijeODozi: this.fb.group({  
          nazivVakcije: ['', Validators.required],
          datumDoze: ['', Validators.required],
          brojSerije: ['', Validators.required],
          brojDoze: ['', Validators.required],
          zdravstvenaUstanova: ['', Validators.required],
          }),
        }),
      datumIzdavanjaPotvrde:  [this.currentDate],
      zdravstvenaUstanova: ['', Validators.required],
      //qr: ['', Validators.required]
    });
  }
  logout() {
    localStorage.removeItem('user');
    // alert("123")
    // this.router.navigate(['/123']);
    location.reload();
  }
  onSubmit() {
    this.potvrdaService
      .save(this.potvrdaForm.value)
      .subscribe((res: string) => {
      });
  }
  ngOnInit(): void {
  }

}
