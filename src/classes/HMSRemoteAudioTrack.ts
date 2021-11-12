import { NativeModules } from 'react-native';
import type { HMSTrackType } from './HMSTrackType';
import { HMSAudioTrack } from './HMSAudioTrack';

const {
  /**
   * @ignore
   */
  HmsManager,
} = NativeModules;

export class HMSRemoteAudioTrack extends HMSAudioTrack {
  /**
   * Switches Audio of remote user on/off depending upon the value of playbackAllowed
   *
   * @param {boolean} playbackAllowed
   * @memberof HMSRemoteAudioTrack
   */
  setPlaybackAllowed(playbackAllowed: boolean) {
    HmsManager.setPlaybackAllowed({
      id: this.id,
      trackId: this.trackId,
      playbackAllowed,
    });
  }

  isPlaybackAllowed = async () => {
    try {
      const val = await HmsManager.isPlaybackAllowed({
        id: this.id,
        trackId: this.trackId,
      });
      return val;
    } catch (e) {
      return true;
    }
  };

  constructor(params: {
    trackId: string;
    source?: number | string;
    isMute?: boolean;
    trackDescription?: string;
    playbackAllowed?: boolean;
    id: string;
    type?: HMSTrackType;
  }) {
    super(params);
  }
}
