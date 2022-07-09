import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginGuard } from './authentication/guards/login/login.guard';
import { NotFoundPageComponent } from './routing/pages/not-found-page/not-found-page.component';
import { RootLayoutComponent } from './routing/pages/root-layout/root-layout.component';
import { SharedModule } from './shared/shared.module';
const routes: Routes = [
  {
    path: '',
    component: RootLayoutComponent,
    loadChildren: () => import('./home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'login',
    component: RootLayoutComponent,
    loadChildren: () =>
      import('./authentication/authentication.module').then(
        (m) => m.AuthenticationModule
      ),
  },
  {
    path: 'vakcine',
    component: RootLayoutComponent,
    loadChildren: () =>
      import('./vakcine/vakcine.module').then(
        (m) => m.VakcineModule
      ),
  },
  {
    path: 'izvestaj',
    component: RootLayoutComponent,
    loadChildren: () =>
      import('./izvestaj/izvestaj.module').then(
        (m) => m.IzvestajModule
      ),
  },
  {
    path: '**',
    component: NotFoundPageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes), SharedModule],
  exports: [RouterModule],
})
export class AppRoutingModule { }
