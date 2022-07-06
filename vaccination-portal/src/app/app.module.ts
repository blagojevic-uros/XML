import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RootLayoutComponent } from './routing/pages/root-layout/root-layout.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { SharedModule } from './shared/shared.module';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { NotFoundPageComponent } from './routing/pages/not-found-page/not-found-page.component';
@NgModule({
  declarations: [AppComponent, RootLayoutComponent, NotFoundPageComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatSnackBarModule,
    SharedModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
