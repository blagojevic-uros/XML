import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-potvrda-form',
  templateUrl: './potvrda-form.component.html',
  styleUrls: ['./potvrda-form.component.scss']
})
export class PotvrdaFormComponent implements OnInit {

  @Input() potvrdaForm!: FormGroup;
  @Output() submitFormEvent = new EventEmitter();
  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {}

  onSubmit() {
    this.submitFormEvent.emit();
  }

}
