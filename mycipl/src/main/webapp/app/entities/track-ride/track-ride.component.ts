import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ITrackRide } from 'app/shared/model/track-ride.model';
import { AccountService } from 'app/core';
import { TrackRideService } from './track-ride.service';

@Component({
  selector: 'jhi-track-ride',
  templateUrl: './track-ride.component.html'
})
export class TrackRideComponent implements OnInit, OnDestroy {
  trackRides: ITrackRide[];
  currentAccount: any;
  eventSubscriber: Subscription;

  constructor(
    protected trackRideService: TrackRideService,
    protected jhiAlertService: JhiAlertService,
    protected eventManager: JhiEventManager,
    protected accountService: AccountService
  ) {}

  loadAll() {
    this.trackRideService
      .query()
      .pipe(
        filter((res: HttpResponse<ITrackRide[]>) => res.ok),
        map((res: HttpResponse<ITrackRide[]>) => res.body)
      )
      .subscribe(
        (res: ITrackRide[]) => {
          this.trackRides = res;
        },
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  ngOnInit() {
    this.loadAll();
    this.accountService.identity().then(account => {
      this.currentAccount = account;
    });
    this.registerChangeInTrackRides();
  }

  ngOnDestroy() {
    this.eventManager.destroy(this.eventSubscriber);
  }

  trackId(index: number, item: ITrackRide) {
    return item.id;
  }

  registerChangeInTrackRides() {
    this.eventSubscriber = this.eventManager.subscribe('trackRideListModification', response => this.loadAll());
  }

  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}
