import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateSaglasnostComponent } from './pages/create-saglasnost/create-saglasnost.component';

const routes: Routes = [
    {
        path: 'create',
        pathMatch: 'full',
        component: CreateSaglasnostComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class SaglasnostRoutingModule { }
