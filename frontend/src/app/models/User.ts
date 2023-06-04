export class User{
  /* --------- Properties (based on the API) --------- */
  id!:number;
  roleType!:string;
  firstName!:string;
  lastName!:string;
  email!:string;
  password!:string;
  isAdmin!:boolean;
  isLoggedIn!:boolean;
}
