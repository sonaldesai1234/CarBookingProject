/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MyciplTestModule } from '../../../test.module';
import { TrackRideComponent } from 'app/entities/track-ride/track-ride.component';
import { TrackRideService } from 'app/entities/track-ride/track-ride.service';
import { TrackRide } from 'app/shared/model/track-ride.model';

describe('Component Tests', () => {
  describe('TrackRide Management Component', () => {
    let comp: TrackRideComponent;
    let fixture: ComponentFixture<TrackRideComponent>;
    let service: TrackRideService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MyciplTestModule],
        declarations: [TrackRideComponent],
        providers: []
      })
        .overrideTemplate(TrackRideComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(TrackRideComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(TrackRideService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new TrackRide('123')],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.trackRides[0]).toEqual(jasmine.objectContaining({ id: '123' }));
    });
  });
});
