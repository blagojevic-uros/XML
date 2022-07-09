import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HeaderComponent } from './components/header/header.component';
import { MatToolbarModule } from '@angular/material/toolbar';

@NgModule({ 
  declarations: [HeaderComponent],
  imports: [CommonModule, MatToolbarModule,BrowserModule],
  exports: [HeaderComponent],
})
export class SharedModule {}
