/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { Observable, of } from 'rxjs';

import { MyciplTestModule } from '../../../test.module';
import { TrackRideUpdateComponent } from 'app/entities/track-ride/track-ride-update.component';
import { TrackRideService } from 'app/entities/track-ride/track-ride.service';
import { TrackRide } from 'app/shared/model/track-ride.model';

describe('Component Tests', () => {
  describe('TrackRide Management Update Component', () => {
    let comp: TrackRideUpdateComponent;
    let fixture: ComponentFixture<TrackRideUpdateComponent>;
    let service: TrackRideService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [MyciplTestModule],
        declarations: [TrackRideUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(TrackRideUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(TrackRideUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(TrackRideService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new TrackRide('123');
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new TrackRide();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
