import {Component, OnInit} from "@angular/core";
import {Role} from "../../../modules/user";
import {Status} from "../../../modules/wallet";
import {RegistrationService} from "../../../services/registration.service";
import {OrgRegistration} from "../../../modules/orgRegistration";

@Component({
  selector: "app-orgReg",
  templateUrl: "./org.registration.component.html",
  styleUrls: ['./org.registration.component.css']
})
export class OrganisationRegComponent implements OnInit{
  information: OrgRegistration;
  public login: string;
  public password: string;
  public name: string;
  public eMail: string;
  public linkOfSite: string;
  public phone: string;
  public balance: number = 0;
  public walletStatus: Status = Status.ACTIVE;
  public role: Role = Role.ORGANISATION;

  constructor(private regService : RegistrationService) {
  }

  ngOnInit(){
  }

  public saveAll(information): void {
    this.information = new OrgRegistration(this.name,this.eMail, this.linkOfSite, this.phone, this.balance,
      this.walletStatus, this.login, this.password, this.role);
    this.regService.saveOrganisation(this.information).subscribe();
  }
}
