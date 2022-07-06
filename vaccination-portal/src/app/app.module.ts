import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RootLayoutComponent } from './routing/pages/root-layout/root-layout.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { SharedModule } from './shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NotFoundPageComponent } from './routing/pages/not-found-page/not-found-page.component';
import { ImunizacijaFormComponent } from './imunizacija/components/imunizacija-form/imunizacija-form.component';
import { CreateImunizacijaComponent } from './imunizacija/pages/create-imunizacija/create-imunizacija.component';
@NgModule({
  declarations: [AppComponent, RootLayoutComponent, NotFoundPageComponent, ImunizacijaFormComponent, CreateImunizacijaComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatSnackBarModule,
    SharedModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
