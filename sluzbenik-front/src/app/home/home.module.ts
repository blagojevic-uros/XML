import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { PacientHomeComponent } from './pages/pacient-home/pacient-home.component';
import { DocumentViewComponent } from './components/document-view/document-view.component';
import { XmlPipe } from './pipes/xml.pipe';

@NgModule({
  declarations: [
    PacientHomeComponent,
    DocumentViewComponent,
    XmlPipe
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
  ]
})
export class HomeModule { }
