import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ZahtevPageComponent } from './pages/zahtev-page/zahtev-page.component';



const routes: Routes = [
  {
    path: 'create',
    pathMatch: 'full',
    component: ZahtevPageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ZahtevZaSertifikatRoutingModule { }
