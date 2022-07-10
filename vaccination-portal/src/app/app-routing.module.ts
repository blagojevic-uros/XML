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
    path: 'registration',
    component: RootLayoutComponent,
    loadChildren: () =>
      import('./registration/registration.module').then(
        (m) => m.RegistrationModule
      ),
  },
  {
    path: 'interesovanje',
    component: RootLayoutComponent,
    loadChildren: () =>
      import('./interesovanje/interesovanje.module').then(
        (m) => m.InteresovanjeModule
      ),
  },
  {

    path: 'imunizacija',
    component: RootLayoutComponent,
    loadChildren: () =>
      import('./imunizacija/imunizacija.module').then(
        (m) => m.ImunizacijaModule
      ),
  },
  {
    path: 'zahtev',
    component: RootLayoutComponent,
    loadChildren: () =>
      import('./zahtev-za-sertifikat/zahtev-za-sertifikat.module').then(
        (m) => m.ZahtevZaSertifikatModule
      ),
  },
  {

    path: 'saglasnost',
    component: RootLayoutComponent,
    loadChildren: () =>
      import('./saglasnost/saglasnost.module').then(
        (m) => m.SaglasnostModule
      ),},
  {

    path: 'potvrda',
    component: RootLayoutComponent,
    loadChildren: () =>
      import('./potvrda/potvrda.module').then(
        (m) => m.PotvrdaModule
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
