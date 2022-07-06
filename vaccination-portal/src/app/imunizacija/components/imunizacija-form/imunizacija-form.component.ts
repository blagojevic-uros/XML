import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-imunizacija-form',
  templateUrl: './imunizacija-form.component.html',
  styleUrls: ['./imunizacija-form.component.scss']
})
export class ImunizacijaFormComponent implements OnInit {

  @Input() imunizacijaForm!: FormGroup;
  @Output() submitFormEvent = new EventEmitter();
  productForm: FormGroup;
  constructor(private fb: FormBuilder) {
    this.productForm = this.fb.group({  
      name: '',  
      quantities: this.fb.array([]) ,  
    }); 
  }

  ngOnInit(): void {}

  onSubmit() {
    this.submitFormEvent.emit();
  }
  quantities() : FormArray {  
    return this.productForm.get("quantities") as FormArray  
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
