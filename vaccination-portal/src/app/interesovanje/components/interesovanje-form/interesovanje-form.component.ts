import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-interesovanje-form',
  templateUrl: './interesovanje-form.component.html',
  styleUrls: ['./interesovanje-form.component.scss'],
})
export class InteresovanjeFormComponent implements OnInit {
  @Input() interesovanjeForm!: FormGroup;
  @Output() submitFormEvent = new EventEmitter();
  router: any;
  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {}


  onSubmit() {
    this.submitFormEvent.emit();
  }
}
