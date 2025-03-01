package com.reactnativehmssdk

import android.app.Activity
import android.app.Application
import android.app.PendingIntent
import android.app.PictureInPictureParams
import android.app.RemoteAction
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.util.Rational
import androidx.annotation.RequiresApi
import com.facebook.react.bridge.*
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.modules.core.DeviceEventManagerModule
import com.reactnativehmssdk.HMSManager.Companion.REACT_CLASS
import java.util.UUID

@ReactModule(name = REACT_CLASS)
class HMSManager(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext), Application.ActivityLifecycleCallbacks {
  companion object {
    const val REACT_CLASS = "HMSManager"
    var hmsCollection = mutableMapOf<String, HMSRNSDK>()
  }

  override fun getName(): String {
    return "HMSManager"
  }

  fun getHmsInstance(): MutableMap<String, HMSRNSDK> {
    return hmsCollection
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun build(data: ReadableMap?, callback: Promise?) {
    val hasItem = hmsCollection.containsKey("12345")
    if (hasItem) {
      val uuid = UUID.randomUUID()
      val randomUUIDString = uuid.toString()
      val sdkInstance = HMSRNSDK(data, this, randomUUIDString, reactApplicationContext)

      hmsCollection[randomUUIDString] = sdkInstance

      callback?.resolve(randomUUIDString)
    } else {
      val randomUUIDString = "12345"
      val sdkInstance = HMSRNSDK(data, this, randomUUIDString, reactApplicationContext)

      hmsCollection[randomUUIDString] = sdkInstance

      callback?.resolve(randomUUIDString)
    }
  }

  @ReactMethod
  fun preview(credentials: ReadableMap) {
    val hms = HMSHelper.getHms(credentials, hmsCollection)

    hms?.preview(credentials)
  }

  @ReactMethod
  fun join(credentials: ReadableMap) {
    val hms = HMSHelper.getHms(credentials, hmsCollection)

    hms?.join(credentials)
  }

  @ReactMethod
  fun setLocalMute(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.setLocalMute(data)
  }

  @ReactMethod
  fun setLocalVideoMute(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.setLocalVideoMute(data)
  }

  @ReactMethod
  fun switchCamera(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.switchCamera()
  }

  @ReactMethod
  fun leave(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.leave(callback)
  }

  @ReactMethod
  fun sendBroadcastMessage(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.sendBroadcastMessage(data, callback)
  }

  @ReactMethod
  fun sendGroupMessage(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.sendGroupMessage(data, callback)
  }

  @ReactMethod
  fun sendDirectMessage(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.sendDirectMessage(data, callback)
  }

  @kotlin.Deprecated("Use #Function changeRoleOfPeer instead")
  @ReactMethod
  fun changeRole(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.changeRole(data, callback)
  }

  @ReactMethod
  fun changeRoleOfPeer(data: ReadableMap, promise: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.changeRoleOfPeer(data, promise)
  }

  @ReactMethod
  fun changeRoleOfPeersWithRoles(data: ReadableMap, promise: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.changeRoleOfPeersWithRoles(data, promise)
  }

  @ReactMethod
  fun changeTrackState(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.changeTrackState(data, callback)
  }

  @ReactMethod
  fun changeTrackStateForRoles(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.changeTrackStateForRoles(data, callback)
  }

  @ReactMethod
  fun isMute(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.isMute(data, callback)
  }

  @ReactMethod
  fun removePeer(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.removePeer(data, callback)
  }

  @ReactMethod
  fun isPlaybackAllowed(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.isPlaybackAllowed(data, callback)
  }

  @ReactMethod
  fun getRoom(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.getRoom(callback)
  }

  @ReactMethod
  fun getLocalPeer(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.getLocalPeer(callback)
  }

  @ReactMethod
  fun getRemotePeers(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.getRemotePeers(callback)
  }

  @ReactMethod
  fun getRoles(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.getRoles(callback)
  }

  @ReactMethod
  fun setPlaybackAllowed(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.setPlaybackAllowed(data)
  }

  @ReactMethod
  fun endRoom(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.endRoom(data, callback)
  }

  @ReactMethod
  fun acceptRoleChange(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.acceptRoleChange(callback)
  }

  @ReactMethod
  fun setVolume(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.setVolume(data)
  }

  @ReactMethod
  fun getVolume(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.getVolume(data, callback)
  }

  @ReactMethod
  fun setPlaybackForAllAudio(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.setPlaybackForAllAudio(data)
  }

  @ReactMethod
  fun remoteMuteAllAudio(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.remoteMuteAllAudio(callback)
  }

  @ReactMethod
  fun changeMetadata(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.changeMetadata(data, callback)
  }

  @ReactMethod
  fun startScreenshare(data: ReadableMap, callback: Promise?) {
    currentActivity?.application?.registerActivityLifecycleCallbacks(this)
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.startScreenshare(callback)
  }

  @ReactMethod
  fun isScreenShared(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.isScreenShared(callback)
  }

  @ReactMethod
  fun stopScreenshare(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    currentActivity?.application?.unregisterActivityLifecycleCallbacks(this)
    hms?.stopScreenshare(callback)
  }

  @ReactMethod
  fun startAudioshare(data: ReadableMap, callback: Promise?) {
    currentActivity?.application?.registerActivityLifecycleCallbacks(this)
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.startAudioshare(data, callback)
  }

  @ReactMethod
  fun isAudioShared(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.isAudioShared(callback)
  }

  @ReactMethod
  fun stopAudioshare(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    currentActivity?.application?.unregisterActivityLifecycleCallbacks(this)
    hms?.stopAudioshare(callback)
  }

  @ReactMethod
  fun getAudioMixingMode(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    callback?.resolve(hms?.getAudioMixingMode()?.name)
  }

  @ReactMethod
  fun setAudioMixingMode(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.setAudioMixingMode(data, callback)
  }

  @ReactMethod
  fun startRTMPOrRecording(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.startRTMPOrRecording(data, callback)
  }

  @ReactMethod
  fun stopRtmpAndRecording(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.stopRtmpAndRecording(callback)
  }

  @ReactMethod
  fun startHLSStreaming(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.startHLSStreaming(data, callback)
  }

  @ReactMethod
  fun stopHLSStreaming(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.stopHLSStreaming(callback)
  }

  @ReactMethod
  fun resetVolume(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.resetVolume()
  }

  @ReactMethod
  fun changeName(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.changeName(data, callback)
  }

  @ReactMethod
  fun destroy(data: ReadableMap, callback: Promise?) {
    val id = data.getString("id")
    hmsCollection.remove(id)
    val result: WritableMap = Arguments.createMap()
    result.putBoolean("success", true)
    result.putString("message", "$id removed")
    callback?.resolve(result)
  }

  @ReactMethod
  fun enableRTCStats(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.enableRTCStats()
  }

  @ReactMethod
  fun disableRTCStats(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.disableRTCStats()
  }

  @ReactMethod
  fun enableNetworkQualityUpdates(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.enableNetworkQualityUpdates()
  }

  @ReactMethod
  fun disableNetworkQualityUpdates(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.disableNetworkQualityUpdates()
  }

  @ReactMethod
  fun getAudioDevicesList(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.getAudioDevicesList(callback)
  }

  @ReactMethod
  fun getAudioOutputRouteType(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.getAudioOutputRouteType(callback)
  }

  @ReactMethod
  fun switchAudioOutput(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.switchAudioOutput(data)
  }

  @ReactMethod
  fun setAudioMode(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.setAudioMode(data)
  }

  @ReactMethod
  fun setAudioDeviceChangeListener(data: ReadableMap) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.setAudioDeviceChangeListener()
  }

  @ReactMethod
  fun setSessionMetaData(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.setSessionMetaData(data, callback)
  }

  @ReactMethod
  fun getSessionMetaData(data: ReadableMap, callback: Promise?) {
    val hms = HMSHelper.getHms(data, hmsCollection)

    hms?.getSessionMetaData(callback)
  }

  // region Person-In-Person Mode Action handing
  private val pipReceiver by lazy {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      PipActionReceiver(
        toggleLocalAudio = {
          toggleLocalAudio()
          updatePIPRemoteActions(PipActionReceiver.PIPActions.localAudio.requestCode)
        },
        toggleLocalVideo = {
          toggleLocalVideo()
          updatePIPRemoteActions(PipActionReceiver.PIPActions.localVideo.requestCode)
        },
        endMeeting = {
          endMeeting()
        }
      )
    } else {
      null
    }
  }

  private var pipRemoteActionsList: MutableList<RemoteAction> = mutableListOf()

  @RequiresApi(Build.VERSION_CODES.O)
  private fun toggleLocalAudio() {
    val hmssdk = getHmsInstance()[PipActionReceiver.sdkIdForPIP!!]?.hmsSDK

    val localAudioTrack = hmssdk?.getLocalPeer()?.audioTrack
    val isMuted = localAudioTrack?.isMute

    if (isMuted !== null) {
      localAudioTrack?.setMute(!isMuted)
    }
  }

  @RequiresApi(Build.VERSION_CODES.O)
  private fun toggleLocalVideo() {
    val hmssdk = getHmsInstance()[PipActionReceiver.sdkIdForPIP!!]?.hmsSDK

    val localVideoTrack = hmssdk?.getLocalPeer()?.videoTrack
    val isMuted = localVideoTrack?.isMute

    if (isMuted !== null) {
      localVideoTrack?.setMute(!isMuted)
    }
  }

  @RequiresApi(Build.VERSION_CODES.O)
  private fun endMeeting() {
    val hms = getHmsInstance()[PipActionReceiver.sdkIdForPIP!!]

    hms?.leave(callback = null, fromPIP = true)
  }

  @RequiresApi(Build.VERSION_CODES.O)
  private fun updatePIPRemoteActions(code: Int) {
    val activity = currentActivity

    if (activity !== null) {
      val hmssdk = getHmsInstance()[PipActionReceiver.sdkIdForPIP!!]?.hmsSDK

      when (code) {
        PipActionReceiver.PIPActions.localAudio.requestCode -> {
          val audioActionIdx = pipRemoteActionsList.indexOfFirst { it.title == PipActionReceiver.PIPActions.localAudio.title }
          if (audioActionIdx >= 0) {
            pipRemoteActionsList[audioActionIdx] = RemoteAction(
              Icon.createWithResource(
                reactApplicationContext,
                if (hmssdk?.getLocalPeer()?.audioTrack?.isMute === true) R.drawable.ic_mic_off_24 else R.drawable.ic_mic_24
              ),
              PipActionReceiver.PIPActions.localAudio.title,
              PipActionReceiver.PIPActions.localAudio.description,
              PendingIntent.getBroadcast(
                reactApplicationContext,
                PipActionReceiver.PIPActions.localAudio.requestCode,
                Intent(PipActionReceiver.PIP_INTENT_ACTION).putExtra(PipActionReceiver.PIPActions.localAudio.title, PipActionReceiver.PIPActions.localAudio.requestCode),
                PendingIntent.FLAG_IMMUTABLE
              )
            )
          }
        }
        PipActionReceiver.PIPActions.localVideo.requestCode -> {
          val videoActionIdx = pipRemoteActionsList.indexOfFirst { it.title == PipActionReceiver.PIPActions.localVideo.title }
          if (videoActionIdx >= 0) {
            pipRemoteActionsList[videoActionIdx] = RemoteAction(
              Icon.createWithResource(
                reactApplicationContext,
                if (hmssdk?.getLocalPeer()?.videoTrack?.isMute === true) R.drawable.ic_camera_toggle_off else R.drawable.ic_camera_toggle_on
              ),
              PipActionReceiver.PIPActions.localVideo.title,
              PipActionReceiver.PIPActions.localVideo.description,
              PendingIntent.getBroadcast(
                reactApplicationContext,
                PipActionReceiver.PIPActions.localVideo.requestCode,
                Intent(PipActionReceiver.PIP_INTENT_ACTION).putExtra(PipActionReceiver.PIPActions.localVideo.title, PipActionReceiver.PIPActions.localVideo.requestCode),
                PendingIntent.FLAG_IMMUTABLE
              )
            )
          }
        }
      }

      val pipParams = PictureInPictureParams.Builder().let {
        it.setActions(pipRemoteActionsList)
        it.build()
      }

      activity.setPictureInPictureParams(pipParams)
    }
  }
  // endregion

  private data class PipParamConfig(
    val aspectRatio: Pair<Int, Int>?,
    val showEndButton: Boolean,
    val showVideoButton: Boolean,
    val showAudioButton: Boolean
  )

  @ReactMethod
  fun handlePipActions(action: String, data: ReadableMap, promise: Promise?) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
      promise?.reject(Throwable("PIP mode is not supported!"))
      return
    }

    if (!data.hasKey("id")) {
      promise?.reject(Throwable("HMS Instance Id is required!"))
      return
    }

    try {
      PipActionReceiver.sdkIdForPIP = data.getString("id")

      when (action) {
        "isPipModeSupported" -> {
          val result = isPipModeSupported()
          promise?.resolve(result)
        }
        "enablePipMode" -> {
          val result = enablePipMode(data)
          promise?.resolve(result)
        }
        "setPictureInPictureParams" -> {
          val result = setPictureInPictureParams(data)
          promise?.resolve(result)
        }
      }
    } catch (e: Exception) {
      promise?.reject(e)
    }
  }

  @RequiresApi(Build.VERSION_CODES.O)
  private fun getPIPRemoteActions(endAction: Boolean = false, audioAction: Boolean = false, videoAction: Boolean = false): MutableList<RemoteAction> {
    val hmssdk = getHmsInstance()[PipActionReceiver.sdkIdForPIP!!]?.hmsSDK

    pipRemoteActionsList.clear()

    val localPeer = hmssdk?.getLocalPeer()
    val allowedPublishing = localPeer?.hmsRole?.publishParams?.allowed

    if (audioAction && allowedPublishing?.contains("audio") === true) {
      pipRemoteActionsList.add(
        RemoteAction(
          Icon.createWithResource(
            reactApplicationContext,
            if (localPeer?.audioTrack?.isMute === true) R.drawable.ic_mic_off_24 else R.drawable.ic_mic_24
          ),
          PipActionReceiver.PIPActions.localAudio.title,
          PipActionReceiver.PIPActions.localAudio.description,
          PendingIntent.getBroadcast(
            reactApplicationContext,
            PipActionReceiver.PIPActions.localAudio.requestCode,
            Intent(PipActionReceiver.PIP_INTENT_ACTION).putExtra(PipActionReceiver.PIPActions.localAudio.title, PipActionReceiver.PIPActions.localAudio.requestCode),
            PendingIntent.FLAG_IMMUTABLE
          )
        )
      )
    }

    if (endAction) {
      pipRemoteActionsList.add(
        RemoteAction(
          Icon.createWithResource(reactApplicationContext, R.drawable.ic_call_end_24),
          PipActionReceiver.PIPActions.endMeet.title,
          PipActionReceiver.PIPActions.endMeet.description,
          PendingIntent.getBroadcast(
            reactApplicationContext,
            PipActionReceiver.PIPActions.endMeet.requestCode,
            Intent(PipActionReceiver.PIP_INTENT_ACTION).putExtra(
              PipActionReceiver.PIPActions.endMeet.title,
              PipActionReceiver.PIPActions.endMeet.requestCode
            ),
            PendingIntent.FLAG_IMMUTABLE
          )
        )
      )
    }

    if (videoAction && allowedPublishing?.contains("video") === true) {
      pipRemoteActionsList.add(
        RemoteAction(
          Icon.createWithResource(
            reactApplicationContext,
            if (localPeer?.videoTrack?.isMute === true) R.drawable.ic_camera_toggle_off else R.drawable.ic_camera_toggle_on
          ),
          PipActionReceiver.PIPActions.localVideo.title,
          PipActionReceiver.PIPActions.localVideo.description,
          PendingIntent.getBroadcast(
            reactApplicationContext,
            PipActionReceiver.PIPActions.localVideo.requestCode,
            Intent(PipActionReceiver.PIP_INTENT_ACTION).putExtra(
              PipActionReceiver.PIPActions.localVideo.title,
              PipActionReceiver.PIPActions.localVideo.requestCode
            ),
            PendingIntent.FLAG_IMMUTABLE
          )
        )
      )
    }

    return pipRemoteActionsList
  }

  // Builds and returns PictureInPictureParams as per given config
  @RequiresApi(Build.VERSION_CODES.O)
  private fun buildPipParams(config: PipParamConfig): PictureInPictureParams {
    val pipParams = PictureInPictureParams.Builder().let {
      if (config.aspectRatio !== null) {
        it.setAspectRatio(
          Rational(
            config.aspectRatio.first,
            config.aspectRatio.second
          )
        )
      }

//      TODO:= We need compileSdkVersion >= 31 for autoEnterEnabled
//      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && config.autoEnterEnabled !== null)
//        it.setAutoEnterEnabled(config.autoEnterEnabled)
//      }

      it.setActions(
        getPIPRemoteActions(
          endAction = config.showEndButton,
          audioAction = config.showAudioButton,
          videoAction = config.showVideoButton
        )
      )

      it.build()
    }

    return pipParams
  }

  @RequiresApi(Build.VERSION_CODES.O)
  private fun readableMapToPipParamConfig(data: ReadableMap?): PipParamConfig {
    var aspectRatio: Pair<Int, Int> = Pair(16, 9)
    var showEndButton = false
    var showAudioButton = false
    var showVideoButton = false

//    TODO:= We need compileSdkVersion >= 31 for autoEnterEnabled
//    var autoEnterEnabled: Boolean? = null;

    if (data !== null) {
      if (data.hasKey("aspectRatio")) {
        val aspectRatioArray = data.getArray("aspectRatio")

        if (aspectRatioArray !== null) {
          val firstItemType = aspectRatioArray.getType(0)
          var firstItem: Int? = null
          if (firstItemType === ReadableType.Number) {
            firstItem = aspectRatioArray.getInt(0)
          }

          val secondItemType = aspectRatioArray.getType(1)
          var secondItem: Int? = null
          if (secondItemType === ReadableType.Number) {
            secondItem = aspectRatioArray.getInt(1)
          }

          if (firstItem !== null && secondItem !== null) {
            aspectRatio = Pair(firstItem, secondItem)
          }
        }
      }

      if (data.hasKey("endButton")) {
        showEndButton = data.getBoolean("endButton")
      }

      if (data.hasKey("audioButton")) {
        showAudioButton = data.getBoolean("audioButton")
      }

      if (data.hasKey("videoButton")) {
        showVideoButton = data.getBoolean("videoButton")
      }

//      TODO:= We need compileSdkVersion >= 31 for autoEnterEnabled
//      if (data.hasKey("autoEnterEnabled")) {
//        val autoEnterEnabledType = data.getType("autoEnterEnabled")
//
//        if (autoEnterEnabledType === ReadableType.Boolean) {
//          autoEnterEnabled = data.getBoolean("autoEnterEnabled")
//        }
//      }
    }

    return PipParamConfig(
      aspectRatio = aspectRatio,
      showEndButton = showEndButton,
      showAudioButton = showAudioButton,
      showVideoButton = showVideoButton
    )
  }

  @RequiresApi(Build.VERSION_CODES.O)
  private fun setPictureInPictureParams(data: ReadableMap): Boolean {
    try {
      if (!isPipModeSupported()) {
        throw Throwable(message = "PIP Mode is not supported!")
      }

      val activity = currentActivity

      if (activity !== null) {
        val pipParamConfig = readableMapToPipParamConfig(data)
        val pipParams = buildPipParams(pipParamConfig)

        activity.setPictureInPictureParams(pipParams)
        return true
      }

      return false
    } catch (e: Exception) {
      throw e
    }
  }

  @RequiresApi(Build.VERSION_CODES.O)
  private fun isPipModeSupported(): Boolean {
    return reactApplicationContext.packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)
  }

  @RequiresApi(Build.VERSION_CODES.O)
  private fun enablePipMode(data: ReadableMap): Boolean {
    try {
      if (!isPipModeSupported()) {
        throw Throwable(message = "PIP Mode is not supported!")
      }

      val activity = currentActivity

      if (activity !== null) {
        val pipParamConfig = readableMapToPipParamConfig(data)
        val pipParams = buildPipParams(pipParamConfig)

        pipReceiver?.register(activity)
        val entered = activity.enterPictureInPictureMode(pipParams)
        if (entered === false) {
          pipReceiver?.unregister(activity)
        }
        return entered
      }

      return false
    } catch (e: Exception) {
      throw e
    }
  }

  fun emitEvent(event: String, data: WritableMap) {
    reactApplicationContext
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
      .emit(event, data)
  }

  override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

  override fun onActivityStarted(activity: Activity) {}

  override fun onActivityResumed(activity: Activity) {}

  override fun onActivityPaused(activity: Activity) {}

  override fun onActivityStopped(activity: Activity) {}

  override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

  override fun onActivityDestroyed(activity: Activity) {
    try {
      if (activity.componentName.shortClassName == ".MainActivity") {
        for (key in hmsCollection.keys) {
          val hmsLocalPeer = hmsCollection[key]?.hmsSDK?.getLocalPeer()
          if (hmsLocalPeer != null) {
            hmsCollection[key]?.leave(null)
          }
        }
        currentActivity?.application?.unregisterActivityLifecycleCallbacks(this)
        hmsCollection = mutableMapOf()
        // unregistering pip actions on activity destroy.
        if (pipReceiver !== null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
          pipReceiver?.unregister(activity)
        }
      }
    } catch (e: Exception) {
      //      Log.d("error", e.message)
    }
  }
}
