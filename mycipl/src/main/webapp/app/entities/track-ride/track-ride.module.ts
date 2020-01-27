import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MyciplSharedModule } from 'app/shared';
import {
  TrackRideComponent,
  TrackRideDetailComponent,
  TrackRideUpdateComponent,
  TrackRideDeletePopupComponent,
  TrackRideDeleteDialogComponent,
  trackRideRoute,
  trackRidePopupRoute
} from './';

const ENTITY_STATES = [...trackRideRoute, ...trackRidePopupRoute];

@NgModule({
  imports: [MyciplSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    TrackRideComponent,
    TrackRideDetailComponent,
    TrackRideUpdateComponent,
    TrackRideDeleteDialogComponent,
    TrackRideDeletePopupComponent
  ],
  entryComponents: [TrackRideComponent, TrackRideUpdateComponent, TrackRideDeleteDialogComponent, TrackRideDeletePopupComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MyciplTrackRideModule {}
