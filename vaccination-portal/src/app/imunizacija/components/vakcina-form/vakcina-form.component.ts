import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ImunizacijaService } from '../../service/imunizacija.service';

@Component({
  selector: 'app-vakcina-form',
  templateUrl: './vakcina-form.component.html',
  styleUrls: ['./vakcina-form.component.scss']
})
export class VakcinaFormComponent implements OnInit {

  @Input() searchInput : any = '';
  vakcinaForm!: FormGroup; 
  constructor(private fb: FormBuilder,private imunizacijaService: ImunizacijaService) { 
    this.vakcinaForm = this.fb.group({
      nazivVakcine: this.fb.group({
        value: [''],
      }),

      datumDavanja: new Date(),
      nacinDavanja: ['',Validators.required],
      ekstremitet: ['',Validators.required],
      serijaVakcine:['',Validators.required],
      proizvodjac: ['',Validators.required],
      nezeljenaReakcija : ['',Validators.required],
      potpisLekara :['',Validators.required],
      // privremene_kontraindikacije: this.fb.group({
        
      // })
    });
  }

  ngOnInit(): void {
  }
  onSubmit() {
    this.imunizacijaService.saveVakcina(this.vakcinaForm.value,this.searchInput).subscribe((res)=>{
      
    })

    }
  }
