import { Component, OnInit } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { SharedModule } from 'src/app/shared/shared.module';

@Component({
  selector: 'app-pacient-home',
  templateUrl: './pacient-home.component.html',
  styleUrls: ['./pacient-home.component.scss'],
})
export class PacientHomeComponent implements OnInit {
  router: any;
  ngOnInit(): void {}

  logout() {
    localStorage.removeItem('user');
    
    location.reload();
    this.router.navigate(['/123']);
  }
}
