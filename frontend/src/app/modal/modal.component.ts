import {Component, TemplateRef} from "@angular/core";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html'
})
export class ModalComponent {
  modalRef: BsModalRef;

  constructor(private modalService: BsModalService) {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
}
