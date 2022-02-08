import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RootLayoutComponent } from './routing/pages/root-layout/root-layout.component';
import { SharedModule } from './shared/shared.module';
const routes: Routes = [
  {
    path: '',
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
];

@NgModule({
  imports: [RouterModule.forRoot(routes), SharedModule],
  exports: [RouterModule],
})
export class AppRoutingModule {}
