import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
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
  searchInput: string = '1707999850111'; 
  constructor(
    private fb: FormBuilder,
    private imunizacijaService: ImunizacijaService,
    private _snackBar: MatSnackBar,
    private http: HttpClient
  ) {
    this.imunizacijaForm = this.fb.group({
      evidencijaOVakcinaciji: this.fb.group({
        vakcinijskiPunkt: ['', Validators.required],
        zdravstvenaUstanova: ['',Validators.required],
      }),
      lekar: this.fb.group({
        ime: ['', Validators.required],
        prezime: ['', Validators.required],
        faksmil: ['', Validators.required],
        brojTelefona: ['', Validators.required],
      }),
      tabelaVakcinisanja: this.fb.array([])
    });
  }

  get tabelaVakcinisanja(){
    return this.imunizacijaForm.controls["tabelaVakcinisanja"] as FormArray;
  }

  addVakcina(){
    const vakcina = this.fb.group({
      nazivVakcine: this.fb.group({
        tipVakcine: this.fb.group({
          value: ['', Validators.required],
        }),
      }),
      nacinDavanja: ['', Validators.required],
      ekstremitet: ['', Validators.required],
      serijaVakcine: ['', Validators.required],
      proizvodjac: this.fb.group({
        value: ['', Validators.required],
      }),
      nezeljenaReakcija: ['', Validators.required],
      potpisLekara: ['', Validators.required],
      privremeneKontraindikacije: this.fb.group({
        datum: ['', Validators.required],
        dijagnoza: ['', Validators.required],
      }),
      odlukaKomisije: ['', Validators.required],
    })

    this.tabelaVakcinisanja.push(vakcina)
  }

  deleteVakcina(vakcinaIndex: number){
    this.tabelaVakcinisanja.removeAt(vakcinaIndex);
  }

  onSubmit() {
    console.log(this.imunizacijaForm.value)
    // this.imunizacijaService
      // .save(this.imunizacijaForm.value,this.searchInput)
      // .subscribe((res : any) => {
      //   this._snackBar.open(res, 'Close');
      // });
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




























































































































































































































































































































































