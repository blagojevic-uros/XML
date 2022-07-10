import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-imunizacija-form',
  templateUrl: './imunizacija-form.component.html',
  styleUrls: ['./imunizacija-form.component.scss']
})
export class ImunizacijaFormComponent implements OnInit {

  @Input() imunizacijaForm!: FormGroup;
  @Input() saglasnost: any;
  @Input() searchInput: string = '';
  @Output() submitFormEvent = new EventEmitter();
  @Output() searchEvent = new EventEmitter();
  tabelaVakcinisanja: FormGroup;
  constructor(private fb: FormBuilder) {

    this.tabelaVakcinisanja = this.fb.group({  
      name: '',  
      quantities: this.fb.array([]) ,  
    });
    // this.imunizacijaForm.addControl(this.tabelaVakcinisanja);
  }

  ngOnInit(): void {}

  searchJmbg(){
    this.searchEvent.emit(this.searchInput);
  }
  onSubmit() {
    this.submitFormEvent.emit();
  }

  




  quantities() : FormArray {  
    return this.tabelaVakcinisanja.get("quantities") as FormArray  
  }  
     
  newQuantity(): FormGroup {  
    return this.fb.group({  
      qty: '',  
      price: '',  
    })  
  }  
     
  addQuantity() {  
    this.quantities().push(this.newQuantity());  
  }  
     
  removeQuantity(i:number) {  
    this.quantities().removeAt(i);  
  }  
}
