import type {HMSMessage, HMSRole, HMSSDK} from '@100mslive/react-native-hms';
import type {PeerTrackNode, PipModes} from '../../utils/types';
import actionTypes from '../actionTypes';

export const addMessage = (data: HMSMessage) => ({
  type: actionTypes.ADD_MESSAGE.REQUEST,
  payload: data,
});

export const addPinnedMessage = (data: string | null) => ({
  type: actionTypes.ADD_PINNED_MESSAGE.REQUEST,
  payload: data,
});

export const clearMessageData = () => ({
  type: actionTypes.CLEAR_MESSAGE_DATA.REQUEST,
});

export const setPeerState = (data: {peerState: PeerTrackNode[]}) => ({
  type: actionTypes.SET_PEER_STATE,
  payload: data,
});

export const changePipModeStatus = (pipModeStatus: PipModes) => ({
  type: actionTypes.CHANGE_PIP_MODE_STATUS,
  payload: {pipModeStatus},
});

export const clearPeerData = () => ({
  type: actionTypes.CLEAR_PEER_DATA.REQUEST,
});

export const saveUserData = (data: {
  userName?: String;
  roomID?: String;
  roomCode?: String;
  hmsInstance?: HMSSDK;
  isHLSFlow?: boolean;
  roles?: HMSRole[];
}) => ({
  type: actionTypes.SAVE_USER_DATA.REQUEST,
  payload: data,
});

export const clearHmsReference = () => ({
  type: actionTypes.CLEAR_HMS_INSTANCE,
});

export const resetJoinConfig = () => ({type: actionTypes.RESET_JOIN_CONFIG});

export const changeJoinAudioMuted = (value: boolean) => ({
  type: actionTypes.CHANGE_JOIN_AUDIO_MUTED,
  payload: {mutedAudio: value},
});

export const changeJoinVideoMuted = (value: boolean) => ({
  type: actionTypes.CHANGE_JOIN_VIDEO_MUTED,
  payload: {mutedVideo: value},
});

export const changeMirrorCamera = (value: boolean) => ({
  type: actionTypes.CHANGE_MIRROR_CAMERA,
  payload: {mirrorCamera: value},
});

export const changeJoinSkipPreview = (value: boolean) => ({
  type: actionTypes.CHANGE_JOIN_SKIP_PREVIEW,
  payload: {skipPreview: value},
});

export const changeAudioMixer = (value: boolean) => ({
  type: actionTypes.CHANGE_AUDIO_MIXER,
  payload: {audioMixer: value},
});

export const changeShowStats = (value: boolean) => ({
  type: actionTypes.CHANGE_SHOW_STATS,
  payload: {showStats: value},
});

export const changeSoftwareDecoder = (value: boolean) => ({
  type: actionTypes.CHANGE_SOFTWARE_DECODER,
  payload: {softwareDecoder: value},
});

export const changeAutoResize = (value: boolean) => ({
  type: actionTypes.CHANGE_AUTO_RESIZE,
  payload: {autoResize: value},
});
