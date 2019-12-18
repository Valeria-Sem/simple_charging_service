export class Organisation {
  idOrganisation: string;
  name: string;
  eMail: string;
  linkOfSite: string;
  phone: string;

  constructor(name: string, eMail: string,
              linkOfSite: string, phone: string) {
    this.name = name;
    this.eMail = eMail;
    this.linkOfSite = linkOfSite;
    this.phone = phone;

  }
}

export class OrganisationStr{

}
