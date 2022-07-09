import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllInteresovanjaComponent } from './pages/all-interesovanja/all-interesovanja.component';
import { CreateInterosavenjeComponent } from './pages/create-interosavenje/create-interosavenje.component';

const routes: Routes = [
  {
    path: 'create',
    pathMatch: 'full',
    component: CreateInterosavenjeComponent,
  },
  {
    path: "all",
    pathMatch: 'full',
    component: AllInteresovanjaComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class InteresovanjeRoutingModule {}
