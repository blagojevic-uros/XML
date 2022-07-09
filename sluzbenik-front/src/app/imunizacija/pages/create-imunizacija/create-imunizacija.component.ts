import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ImunizacijaService } from '../../service/imunizacija.service';

@Component({
  selector: 'app-create-imunizacija',
  templateUrl: './create-imunizacija.component.html',
  styleUrls: ['./create-imunizacija.component.scss']
})
export class CreateImunizacijaComponent implements OnInit {
  imunizacijaForm!: FormGroup;
  currentDate: string = new Date().toISOString().split('T')[0];
  constructor(
    private fb: FormBuilder,
    private imunizacijaService: ImunizacijaService,
    private _snackBar: MatSnackBar
  ) {
    this.imunizacijaForm = this.fb.group({
      licniPodaci: this.fb.group({
        jmbg: [{value: '',disabled:true}],
        imePacijenta: [{value: '',disabled:true}],
        prezimePacijenta: [{value: '',disabled:true}],
        imeRoditelja: [{value: '',disabled:true}],
        mestoRodjenja:[{value: '',disabled:true}],
        ulica: [{value: '',disabled:true}],
        naselje:[{value: '',disabled:true}],
        opstina: [{value: '',disabled:true}],
        fiksni:[{value: '',disabled:true}],
        mobilni: [{value: '',disabled:true}],
        email:[{value: '',disabled:true}],
        radniStatus: [{value: '',disabled:true}],
        zanimanje:[{value: '',disabled:true}],
      }),
      zdravstvenaUstanova: this.fb.group({
        value: ['', Validators.required],
        punkt: ['', Validators.required],
      }),
      informacijeLekara: this.fb.group({
        ime: ['', Validators.required],
        prezime: ['', Validators.required],
        faksmil: ['', Validators.required],
        fiksniTelefon: ['', Validators.required],
      }),
    });
  }
  onSubmit() {
    this.imunizacijaService
      .save(this.imunizacijaForm.value)
      .subscribe((res: string) => {
        this._snackBar.open(res, 'Close');
      });
  }
  ngOnInit(): void {}
}




























































































































































































































































































































































