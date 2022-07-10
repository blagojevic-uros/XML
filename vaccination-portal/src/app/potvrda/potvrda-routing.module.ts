import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PotvrdaComponent } from './pages/potvrda/potvrda.component';

const routes: Routes = [
  {
    path: "create",
    pathMatch: "full",
    component: PotvrdaComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PotvrdaRoutingModule { }
