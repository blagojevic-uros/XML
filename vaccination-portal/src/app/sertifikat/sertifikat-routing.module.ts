import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateSertifikatComponent } from './pages/create-sertifikat/create-sertifikat.component';

const routes: Routes = [  {
  path: 'create',
  pathMatch: 'full',
  component: CreateSertifikatComponent,
},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SertifikatRoutingModule { }
