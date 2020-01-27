export interface IUserProfile {
  id?: string;
}

export class UserProfile implements IUserProfile {
  constructor(public id?: string) {}
}
