import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { catchError, Observable, throwError } from "rxjs";
import { UserAuthServiceService } from "../MyService/user-auth-service.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private userAuthService: UserAuthServiceService,
    private router:Router) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    console.log(req.headers)
    if (req.headers.get('No-Auth') == 'True') {
      return next.handle(req.clone());
    }

    const token = String(this.userAuthService.getToken() || null);
    console.log(this.userAuthService.getToken())
    console.log(req);
    req = this.addToken(req, token);
    console.log(req);

    return next.handle(req).pipe(
        catchError(
            (err:HttpErrorResponse) => {
                console.log(err.status);
                if(err.status === 401) {
                    this.router.navigate([' ']);
                } else if(err.status === 403) {
                    this.router.navigate(['/forbidden']);
                }
                return throwError("Some thing is wrong");
            }
        )
    );
  }


  private addToken(request:HttpRequest<any>, token:string) {
      return request.clone(
          {
              setHeaders: {
                  Authorization : `Bearer ${token}`
              }
          }
      );
  }
}
