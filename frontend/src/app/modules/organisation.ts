export class Organisation {
  idOrganisation: number;
  name: string;
  eMail: string;
  linkOfSite: string;
  phone: string;
  idWallet: string;

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
