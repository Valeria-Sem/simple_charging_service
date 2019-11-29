export class User {
  id: string;
  login: string;
  password: string;
  role: Role;

  constructor(login: string, password: string, role: Role) {
    this.login = login;
    this.password = password;
    this.role = role;
  }

  // static cloneBase(user: User): User{
  //   const cloneUser: User = new User();
  //   cloneUser.id = user.id;
  //   cloneUser.login = user.login;
  //   cloneUser.password = user.password;
  //   cloneUser.role = user.role;
  //   return cloneUser;
  // }
}

export enum Role {
  CUSTOMER,
  ORGANIZATION
}

export class OrganisationStr{

}
