/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MyciplTestModule } from '../../../test.module';
import { TrackRideDeleteDialogComponent } from 'app/entities/track-ride/track-ride-delete-dialog.component';
import { TrackRideService } from 'app/entities/track-ride/track-ride.service';

describe('Component Tests', () => {
  describe('TrackRide Management Delete Component', () => {
    let comp: TrackRideDeleteDialogComponent;
    let fixture: ComponentFixture<TrackRideDeleteDialogComponent>;
    let service: TrackRideService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MyciplTestModule],
        declarations: [TrackRideDeleteDialogComponent]
      })
        .overrideTemplate(TrackRideDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(TrackRideDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(TrackRideService);
      mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
      mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete('123');
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith('123');
          expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));
    });
  });
});
