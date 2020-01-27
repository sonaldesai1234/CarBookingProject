import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { TrackRide } from 'app/shared/model/track-ride.model';
import { TrackRideService } from './track-ride.service';
import { TrackRideComponent } from './track-ride.component';
import { TrackRideDetailComponent } from './track-ride-detail.component';
import { TrackRideUpdateComponent } from './track-ride-update.component';
import { TrackRideDeletePopupComponent } from './track-ride-delete-dialog.component';
import { ITrackRide } from 'app/shared/model/track-ride.model';

@Injectable({ providedIn: 'root' })
export class TrackRideResolve implements Resolve<ITrackRide> {
  constructor(private service: TrackRideService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ITrackRide> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<TrackRide>) => response.ok),
        map((trackRide: HttpResponse<TrackRide>) => trackRide.body)
      );
    }
    return of(new TrackRide());
  }
}

export const trackRideRoute: Routes = [
  {
    path: '',
    component: TrackRideComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'TrackRides'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: TrackRideDetailComponent,
    resolve: {
      trackRide: TrackRideResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'TrackRides'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: TrackRideUpdateComponent,
    resolve: {
      trackRide: TrackRideResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'TrackRides'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: TrackRideUpdateComponent,
    resolve: {
      trackRide: TrackRideResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'TrackRides'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const trackRidePopupRoute: Routes = [
  {
    path: ':id/delete',
    component: TrackRideDeletePopupComponent,
    resolve: {
      trackRide: TrackRideResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'TrackRides'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
