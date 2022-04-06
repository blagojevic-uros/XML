import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from 'src/app/shared/model/login';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss'],
})
export class LoginPageComponent implements OnInit {
  loginForm!: FormGroup;
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  ngOnInit(): void {}
  submit() {
    const auth: Login = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password,
    };

    this.authService.login(auth).subscribe(
      (result) => {
        localStorage.setItem('user', JSON.stringify(result));
        this.router.navigate(['/']);
      },
      (error) => {}
    );
  }
}
