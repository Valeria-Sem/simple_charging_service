export class Organisation {
  id: string;
  name: string;

  static cloneBase(organisation: Organisation): Organisation{
    const cloneOrganisation: Organisation = new Organisation();
    cloneOrganisation.id = organisation.id;
    cloneOrganisation.name = organisation.name;
    return cloneOrganisation;
  }
}

export class OrganisationStr{

}
