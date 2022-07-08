import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Token } from 'src/app/shared/model/token';
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const item = localStorage.getItem('user');
    if (item) {
      console.log(item);
      const decodedItem: Token = JSON.parse(item);

      const cloned = req.clone({
        headers: req.headers.set(
          'Authorization',
          `Bearer ${decodedItem.token}`
        ),
      });

      return next.handle(cloned);
    } else {
      return next.handle(req);
    }
  }
}