import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-zahtev-form',
  templateUrl: './zahtev-form.component.html',
  styleUrls: ['./zahtev-form.component.scss']
})
export class ZahtevFormComponent implements OnInit {

  @Input() zahtevForm!: FormGroup;
  @Output() submitFormEvent = new EventEmitter();
  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {}

  onSubmit() {
    this.submitFormEvent.emit();
  }
}
