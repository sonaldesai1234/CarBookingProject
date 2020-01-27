import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITrackRide } from 'app/shared/model/track-ride.model';
import { TrackRideService } from './track-ride.service';

@Component({
  selector: 'jhi-track-ride-delete-dialog',
  templateUrl: './track-ride-delete-dialog.component.html'
})
export class TrackRideDeleteDialogComponent {
  trackRide: ITrackRide;

  constructor(protected trackRideService: TrackRideService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: string) {
    this.trackRideService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'trackRideListModification',
        content: 'Deleted an trackRide'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-track-ride-delete-popup',
  template: ''
})
export class TrackRideDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ trackRide }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(TrackRideDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.trackRide = trackRide;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/track-ride', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/track-ride', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          }
        );
      }, 0);
    });
  }

  ngOnDestroy() {
    this.ngbModalRef = null;
  }
}
