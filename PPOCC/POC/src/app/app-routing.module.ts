import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {  
    path:'',
    component: LoginComponent
  },
  {
    path: 'registration/:id',
    component : RegistrationComponent
  },
  {
    path: 'registration',
    component : RegistrationComponent
  },
  {
    path: 'dashboard',
    component : DashboardComponent  
  },
  {  
    path:'**',
    component: LoginComponent
  },

  
  // {
  //   path: 'article',
  //   component: ArticleComponent,
  //   children:[
  //              {
  //                path:'article/:type', //:type is dynamic here
  //                component:ArticleComponent
  //              }
  //            ]
  // }
  ];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
