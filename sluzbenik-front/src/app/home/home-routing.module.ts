import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginGuard } from '../authentication/guards/login/login.guard';
import { RoleGuard } from '../authentication/guards/role/role.guard';
import { PacientHomeComponent } from './pages/pacient-home/pacient-home.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    canActivate: [LoginGuard, RoleGuard],
    component: PacientHomeComponent,
    data: { expectedRoles: 'ROLE_PACIJENT' },
  },
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HomeRoutingModule {}
