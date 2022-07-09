import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VakcineComponent } from './pages/vakcine/vakcine.component';

const routes: Routes = [
  {
    path:'all',
    pathMatch: 'full',
    component: VakcineComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VakcineRoutingModule { }
