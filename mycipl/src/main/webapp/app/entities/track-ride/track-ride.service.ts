import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITrackRide } from 'app/shared/model/track-ride.model';

type EntityResponseType = HttpResponse<ITrackRide>;
type EntityArrayResponseType = HttpResponse<ITrackRide[]>;

@Injectable({ providedIn: 'root' })
export class TrackRideService {
  public resourceUrl = SERVER_API_URL + 'api/track-rides';

  constructor(protected http: HttpClient) {}

  create(trackRide: ITrackRide): Observable<EntityResponseType> {
    return this.http.post<ITrackRide>(this.resourceUrl, trackRide, { observe: 'response' });
  }

  update(trackRide: ITrackRide): Observable<EntityResponseType> {
    return this.http.put<ITrackRide>(this.resourceUrl, trackRide, { observe: 'response' });
  }

  find(id: string): Observable<EntityResponseType> {
    return this.http.get<ITrackRide>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ITrackRide[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: string): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
