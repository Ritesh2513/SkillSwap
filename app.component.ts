import { Component, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    RouterLink,
    RouterLinkActive,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule
  ],
  template: `
    <div class="app-container">
      <mat-toolbar color="primary" class="toolbar" [@fadeInDown]>
        <button mat-icon-button (click)="toggleSidenav()">
          <mat-icon>menu</mat-icon>
        </button>
        <span>SkillSwap</span>
        <span class="toolbar-spacer"></span>
        <button mat-button routerLink="/auth/login" *ngIf="!isLoggedIn">
          <mat-icon>login</mat-icon>
          Login
        </button>
        <button mat-button routerLink="/auth/signup" *ngIf="!isLoggedIn">
          <mat-icon>person_add</mat-icon>
          Sign Up
        </button>
        <button mat-button routerLink="/profile" *ngIf="isLoggedIn">
          <mat-icon>account_circle</mat-icon>
          Profile
        </button>
      </mat-toolbar>

      <mat-sidenav-container class="sidenav-container">
        <mat-sidenav #sidenav mode="side" [@slideInOut]>
          <mat-nav-list>
            <a mat-list-item routerLink="/" routerLinkActive="active" [routerLinkActiveOptions]="{exact: true}">
              <mat-icon>home</mat-icon>
              <span>Home</span>
            </a>
            <a mat-list-item routerLink="/skills" routerLinkActive="active">
              <mat-icon>school</mat-icon>
              <span>Skills</span>
            </a>
            <a mat-list-item routerLink="/chat" routerLinkActive="active">
              <mat-icon>chat</mat-icon>
              <span>Chat</span>
            </a>
            <a mat-list-item routerLink="/feedback" routerLinkActive="active">
              <mat-icon>videocam</mat-icon>
              <span>Video Feedback</span>
            </a>
            <a mat-list-item routerLink="/about" routerLinkActive="active">
              <mat-icon>info</mat-icon>
              <span>About</span>
            </a>
            <mat-divider></mat-divider>
            <a mat-list-item routerLink="/dashboard" routerLinkActive="active" *ngIf="isLoggedIn">
              <mat-icon>dashboard</mat-icon>
              <span>Dashboard</span>
            </a>
            <a mat-list-item routerLink="/profile" routerLinkActive="active" *ngIf="isLoggedIn">
              <mat-icon>person</mat-icon>
              <span>Profile</span>
            </a>
          </mat-nav-list>
        </mat-sidenav>

        <mat-sidenav-content>
          <div class="content" [@fadeIn]>
            <router-outlet></router-outlet>
          </div>
        </mat-sidenav-content>
      </mat-sidenav-container>
    </div>
  `,
  styles: [`
    .app-container {
      height: 100vh;
      display: flex;
      flex-direction: column;
    }

    .toolbar {
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      z-index: 2;
    }

    .toolbar-spacer {
      flex: 1 1 auto;
    }

    .sidenav-container {
      flex: 1;
      margin-top: 64px;
    }

    mat-sidenav {
      width: 250px;
      padding-top: 0px;
    }

    .content {
      height: 100%;
    }

    mat-nav-list {
      a {
        display: flex;
        align-items: center;
        gap: 10px;
        height: 48px;

        mat-icon {
          margin-right: 10px;
        }

        &.active {
          background-color: rgba(107, 115, 255, 0.1);
          color: #6B73FF;

          mat-icon {
            color: #6B73FF;
          }
        }
      }
    }
  `],
//   animations: [
//     trigger('fadeIn', [
//       transition(':enter', [
//         style({ opacity: 0 }),
//         animate('0.3s ease-out', style({ opacity: 1 }))
//       ])
//     ]),
//     trigger('fadeInDown', [
//       transition(':enter', [
//         style({ opacity: 0, transform: 'translateY(-20px)' }),
//         animate('0.3s ease-out', style({ opacity: 1, transform: 'translateY(0)' }))
//       ])
//     ]),
//     trigger('slideInOut', [
//       transition(':enter', [
//         style({ transform: 'translateX(-100%)' }),
//         animate('0.3s ease-out', style({ transform: 'translateX(0)' }))
//       ]),
//       transition(':leave', [
//         animate('0.3s ease-out', style({ transform: 'translateX(-100%)' }))
//       ])
//     ])
//   ]
// })
// export class AppComponent {
//   @ViewChild('sidenav') sidenav!: MatSidenav;
//   title = 'skillswap';
//   isLoggedIn = false; // TODO: Implement actual auth state management

//   toggleSidenav() {
//     this.sidenav.toggle();
//   }
// 

//   animations: [
//     trigger('fadeIn', [
//       transition(':enter', [
//         style({ opacity: 0 }),
//         animate('0.3s ease-out', style({ opacity: 1 }))
//       ])
//     ]),
//     trigger('fadeInDown', [
//       transition(':enter', [
//         style({ opacity: 0, transform: 'translateY(-20px)' }),
//         animate('0.3s ease-out', style({ opacity: 1, transform: 'translateY(0)' }))
//       ])
//     ]),
//     trigger('slideInOut', [
//       transition(':enter', [
//         style({ transform: 'translateX(-100%)' }),
//         animate('0.3s ease-out', style({ transform: 'translateX(0)' }))
//       ]),
//       transition(':leave', [
//         animate('0.3s ease-out', style({ transform: 'translateX(-100%)' }))
//       ])
//     ])
//   ]
 })
export class AppComponent {
  @ViewChild('sidenav') sidenav!: MatSidenav;
  title = 'skillswap';
  isLoggedIn = false; // TODO: Implement actual auth state management

  toggleSidenav() {
    this.sidenav.toggle();
  }
}
