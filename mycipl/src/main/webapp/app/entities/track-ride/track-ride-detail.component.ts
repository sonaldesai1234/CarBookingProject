import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITrackRide } from 'app/shared/model/track-ride.model';

@Component({
  selector: 'jhi-track-ride-detail',
  templateUrl: './track-ride-detail.component.html'
})
export class TrackRideDetailComponent implements OnInit {
  trackRide: ITrackRide;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ trackRide }) => {
      this.trackRide = trackRide;
    });
  }

  previousState() {
    window.history.back();
  }
}
