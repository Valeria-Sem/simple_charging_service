export class User {
  idUser: string;
  login: string;
  password: string;
  role: Role;

  constructor(login: string, password: string, role: Role) {
    this.login = login;
    this.password = password;
    this.role = role;
  }

}

export enum Role {
  CUSTOMER,
  ORGANISATION
}

export class OrganisationStr{

}
