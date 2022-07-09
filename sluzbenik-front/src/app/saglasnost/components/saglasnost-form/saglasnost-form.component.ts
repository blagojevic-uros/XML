import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators,
} from '@angular/forms';
@Component({
  selector: 'app-saglasnost-form',
  templateUrl: './saglasnost-form.component.html',
  styleUrls: ['./saglasnost-form.component.scss']
})
export class SaglasnostFormComponent implements OnInit {
  @Input() saglasnostForm!: FormGroup;
  @Output() submitFormEvent = new EventEmitter();
  drzavljanstvo: string = "Drzavljanin_RS";
  // pol: string = "M"
  pols: string[] = ['M', 'Z'];
  drzavljanstvoChange(value: string) {
    this.drzavljanstvo = value;
  }

  // polChange(value: string) {
  //   this.pol = value;
  // }

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitFormEvent.emit();
  }
}
