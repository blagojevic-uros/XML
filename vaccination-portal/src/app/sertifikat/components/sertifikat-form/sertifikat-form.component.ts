import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-sertifikat-form',
  templateUrl: './sertifikat-form.component.html',
  styleUrls: ['./sertifikat-form.component.scss']
})
export class SertifikatFormComponent implements OnInit {
  @Input() sertifikatForm!: FormGroup;
  @Output() submitFormEvent = new EventEmitter();
  router: any;
  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
  }
  onSubmit() {
    this.submitFormEvent.emit();
  }
}
