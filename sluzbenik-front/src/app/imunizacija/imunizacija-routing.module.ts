import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateImunizacijaComponent } from './pages/create-imunizacija/create-imunizacija.component';

const routes: Routes = [
  {
    path: 'create',
    pathMatch: 'full',
    component: CreateImunizacijaComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ImunizacijaRoutingModule {}
