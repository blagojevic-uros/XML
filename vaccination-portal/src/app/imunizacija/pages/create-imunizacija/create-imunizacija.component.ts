import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ImunizacijaService } from '../../service/imunizacija.service';
import { HttpClient } from '@angular/common/http';
import { Saglasnost } from 'src/app/saglasnost/model/saglanosts';


@Component({
  selector: 'app-create-imunizacija',
  templateUrl: './create-imunizacija.component.html',
  styleUrls: ['./create-imunizacija.component.scss']
})
export class CreateImunizacijaComponent implements OnInit {
  imunizacijaForm!: FormGroup;
  currentDate: string = new Date().toISOString().split('T')[0];
  saglasnost!: Saglasnost;
  searchInput: string = ''; 
  constructor(
    private fb: FormBuilder,
    private imunizacijaService: ImunizacijaService,
    private _snackBar: MatSnackBar,
    private http: HttpClient
  ) {
    this.imunizacijaForm = this.fb.group({
        // licniPodaci: this.fb.group({
        //   pol: [{value: '',disabled:true}],
        //   datum: [{value: '',disabled:true}],
        //   drzavljanstvo: [{value: '',disabled:true}],
        //   jmbg: [{value: '',disabled:true}],
        //   imePacijenta: [{value: '',disabled:true}],
        //   prezimePacijenta: [{value: '',disabled:true}],
        //   imeRoditelja: [{value: '',disabled:true}],
        //   mestoRodjenja:[{value: '',disabled:true}],
        //   ulica: [{value: '',disabled:true}],
        //   naselje:[{value: '',disabled:true}],
        //   opstina: [{value: '',disabled:true}],
        //   fiksni:[{value: '',disabled:true}],
        //   mobilni: [{value: '',disabled:true}],
        //   email:[{value: '',disabled:true}],
        //   radniStatus: [{value: '',disabled:true}],
        //   zanimanje:[{value: '',disabled:true}],
        // }),
      zdravstvenaUstanova: 
        ['', Validators.required],
        vakcinijskiPunkt: ['', Validators.required],
        lekar: this.fb.group({
        ime: ['', Validators.required],
        prezime: ['', Validators.required],
        faksmil: ['', Validators.required],
        brojTelefona: ['', Validators.required],
      }),
    });
  }
  onSubmit() {
    this.imunizacijaService
      .save(this.imunizacijaForm.value,this.searchInput)
      .subscribe((res : any) => {
        this._snackBar.open(res, 'Close');
      });
  }
  onSearch($event: string){
    this.searchInput = $event;
    this.imunizacijaService.getSaglasnost($event).subscribe((response) => {
      this.saglasnost = response as Saglasnost;
    });
  }
  ngOnInit(): void {

  }
}




























































































































































































































































































































































