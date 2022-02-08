import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateInterosavenjeComponent } from './pages/create-interosavenje/create-interosavenje.component';

const routes: Routes = [
  {
    path: 'create',
    pathMatch: 'full',
    component: CreateInterosavenjeComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class InteresovanjeRoutingModule {}
