export interface ITrackRide {
  id?: string;
}

export class TrackRide implements ITrackRide {
  constructor(public id?: string) {}
}
