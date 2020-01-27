/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MyciplTestModule } from '../../../test.module';
import { TrackRideDetailComponent } from 'app/entities/track-ride/track-ride-detail.component';
import { TrackRide } from 'app/shared/model/track-ride.model';

describe('Component Tests', () => {
  describe('TrackRide Management Detail Component', () => {
    let comp: TrackRideDetailComponent;
    let fixture: ComponentFixture<TrackRideDetailComponent>;
    const route = ({ data: of({ trackRide: new TrackRide('123') }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MyciplTestModule],
        declarations: [TrackRideDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(TrackRideDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(TrackRideDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.trackRide).toEqual(jasmine.objectContaining({ id: '123' }));
      });
    });
  });
});
