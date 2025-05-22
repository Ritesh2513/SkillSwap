import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private http = inject(HttpClient);
  private BASE_URL = 'http://localhost:8080/api/users';

  getUser(id: number): Observable<any> {
    return this.http.get(`${this.BASE_URL}/${id}`);
  }
}
