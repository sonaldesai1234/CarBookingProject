import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ITrackRide, TrackRide } from 'app/shared/model/track-ride.model';
import { TrackRideService } from './track-ride.service';

@Component({
  selector: 'jhi-track-ride-update',
  templateUrl: './track-ride-update.component.html'
})
export class TrackRideUpdateComponent implements OnInit {
  isSaving: boolean;

  editForm = this.fb.group({
    id: []
  });

  constructor(protected trackRideService: TrackRideService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ trackRide }) => {
      this.updateForm(trackRide);
    });
  }

  updateForm(trackRide: ITrackRide) {
    this.editForm.patchValue({
      id: trackRide.id
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const trackRide = this.createFromForm();
    if (trackRide.id !== undefined) {
      this.subscribeToSaveResponse(this.trackRideService.update(trackRide));
    } else {
      this.subscribeToSaveResponse(this.trackRideService.create(trackRide));
    }
  }

  private createFromForm(): ITrackRide {
    return {
      ...new TrackRide(),
      id: this.editForm.get(['id']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ITrackRide>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}
