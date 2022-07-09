import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, CanActivate } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthService } from '../../services/auth.service';

@Injectable({
  providedIn: 'root',
})
export class RoleGuard implements CanActivate {
  constructor(public auth: AuthService, public router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const token = localStorage.getItem('user');
    const expectedRoles: string = route.data['expectedRoles'];
    if (!token) {
      this.router.navigate(['/auth/login']);
      return false;
    }
    if (!this.checkUserRole(token, expectedRoles)) {
      this.router.navigate(['/not-auth']);
      return false;
    }
    return true;
  }
  checkUserRole(token: string, expectedRoles: string) {
    const jwt: JwtHelperService = new JwtHelperService();
    const decodedToken = jwt.decodeToken(token);
    const roles: string[] = expectedRoles.split('|', 2);

    for (let i = 0; i < decodedToken.role.length; i++) {
      if (roles.indexOf(decodedToken.role[i].name) > -1) {
        console.log(decodedToken.role);
        return true;
      }
    }
    return false;
  }
}
