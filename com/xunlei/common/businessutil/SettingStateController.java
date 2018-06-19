package com.xunlei.common.businessutil;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xunlei.common.XLCommonModule;

public class SettingStateController {
    private static final boolean DEFAULT_STATE_AUTO_APK_DELETE = false;
    private static final boolean DEFAULT_STATE_AUTO_APK_INSTALL = true;
    private static final boolean DEFAULT_STATE_AUTO_HIGH_SPEED_CHANNEL = true;
    private static final boolean DEFAULT_STATE_SOUND = true;
    private static final int DEFAULT_STORAGE = 1;
    private static final String NAME_AUTO_SYNC_TO_LIXIAN_SPACE = "name_auto_sync_to_lixian_space";
    private static final String NAME_FIRST_CREATE_TASK = "name_first_create_task";
    private static final String NAME_REAL_PRIMARY_DOWNLOAD_PATH = "name_real_primary_download_path";
    private static final String NAME_REAL_SLAVE_DOWNLOAD_PATH = "name_real_slave_download_path";
    private static final String NAME_STATE_AUTO_APK_DELETE = "remove";
    private static final String NAME_STATE_HIGH_SPEED_CHANNEL = "high_speed_channel";
    private static final String NAME_STATE_INSTALL = "install";
    private static final String NAME_STATE_LAST_TORRENT_OPEN_PATH = "last_torrent_open_path";
    private static final String NAME_STATE_SOUND = "sound_onoff";
    private static final String NAME_STATE_SPEED_LIMIT = "speed_limit";
    private static final String NAME_STATE_SPEED_LIMIT_VALUE = "speed_limit_value";
    private static final String NAME_STATE_STORAGE = "storage_of_download_dir";
    private static final String NAME_STATE_TASK_NUM = "downtask_num";
    private static final String PREFERENCES_NAME_SETTINGSTATE = "settingstate";
    public static final int STATE_STORAGE_PRIMARY = 1;
    public static final int STATE_STORAGE_SLAVE = 2;
    private static final String TAG = "SettingStateController";
    private static volatile SettingStateController sInstance;
    private final Object mLock = new Object();
    private SharedPreferences mSharedPreferences;

    private SettingStateController() {
    }

    public static synchronized SettingStateController getInstance() {
        SettingStateController settingStateController;
        synchronized (SettingStateController.class) {
            if (sInstance == null) {
                sInstance = new SettingStateController();
            }
            settingStateController = sInstance;
        }
        return settingStateController;
    }

    private SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences != null) {
            return this.mSharedPreferences;
        }
        synchronized (this.mLock) {
            if (this.mSharedPreferences != null) {
                SharedPreferences sharedPreferences = this.mSharedPreferences;
                return sharedPreferences;
            }
            this.mSharedPreferences = XLCommonModule.getInstance().getContext().getSharedPreferences(PREFERENCES_NAME_SETTINGSTATE, 0);
            return this.mSharedPreferences;
        }
    }

    public void setDownloadDirStorage(int i) {
        Editor edit = getSharedPreferences().edit();
        edit.putInt(NAME_STATE_STORAGE, i);
        edit.apply();
    }

    public void setAutoApkInstallState(boolean z) {
        Editor edit = getSharedPreferences().edit();
        edit.putBoolean(NAME_STATE_INSTALL, z);
        edit.apply();
    }

    public boolean getAutoHighSpeedChannel() {
        return getSharedPreferences().getBoolean(NAME_STATE_HIGH_SPEED_CHANNEL, true);
    }

    public void setAutoHighSpeedChannel(boolean z) {
        Editor edit = getSharedPreferences().edit();
        edit.putBoolean(NAME_STATE_HIGH_SPEED_CHANNEL, z);
        edit.apply();
    }

    public int getDownloadDirStorage() {
        return getSharedPreferences().getInt(NAME_STATE_STORAGE, 1);
    }

    public int getDownloadDirStorage(int i) {
        return getSharedPreferences().getInt(NAME_STATE_STORAGE, i);
    }

    public boolean getAutoApkInstall() {
        return getSharedPreferences().getBoolean(NAME_STATE_INSTALL, true);
    }

    public boolean getAutoApkDelete() {
        return getSharedPreferences().getBoolean("remove", false);
    }

    public void setAutoApkDelete(boolean z) {
        Editor edit = getSharedPreferences().edit();
        edit.putBoolean("remove", z);
        edit.apply();
    }

    public void setHadCreateTask() {
        Editor edit = getSharedPreferences().edit();
        edit.putBoolean(NAME_FIRST_CREATE_TASK, false);
        edit.apply();
    }

    public boolean isSoundOn() {
        return XLCommonModule.getInstance().getContext().getSharedPreferences(PREFERENCES_NAME_SETTINGSTATE, 4).getBoolean(NAME_STATE_SOUND, true);
    }

    public void setSound(boolean z) {
        Editor edit = getSharedPreferences().edit();
        edit.putBoolean(NAME_STATE_SOUND, z);
        edit.commit();
    }

    public boolean isSpeedLimit() {
        return getSharedPreferences().getBoolean(NAME_STATE_SPEED_LIMIT, false);
    }

    public int getTaskNum() {
        return getSharedPreferences().getInt(NAME_STATE_TASK_NUM, 3);
    }

    public void setTaskNum(int i) {
        Editor edit = getSharedPreferences().edit();
        edit.putInt(NAME_STATE_TASK_NUM, i);
        edit.apply();
    }

    public int getSpeedValue() {
        return getSharedPreferences().getInt(NAME_STATE_SPEED_LIMIT_VALUE, 512);
    }

    public String getLastTorrentOpenPath() {
        return getSharedPreferences().getString(NAME_STATE_LAST_TORRENT_OPEN_PATH, null);
    }

    public void setLastTorrentOpenPath(String str) {
        Editor edit = getSharedPreferences().edit();
        edit.putString(NAME_STATE_LAST_TORRENT_OPEN_PATH, str);
        edit.apply();
    }

    public boolean getBoolean(String str) {
        return getSharedPreferences().getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return getSharedPreferences().getBoolean(str, z);
    }

    public void setBoolean(String str, Boolean bool) {
        Editor edit = getSharedPreferences().edit();
        edit.putBoolean(str, bool.booleanValue());
        edit.apply();
    }

    public int getInt(String str) {
        return getSharedPreferences().getInt(str, -1);
    }

    public String getString(String str) {
        return getSharedPreferences().getString(str, null);
    }

    public void setString(String str, String str2) {
        Editor edit = getSharedPreferences().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    final String getRealPrimaryDownloadPath(String str) {
        return getSharedPreferences().getString(NAME_REAL_PRIMARY_DOWNLOAD_PATH, str);
    }

    final String setRealPrimaryDownloadPath(String str) {
        getSharedPreferences().edit().putString(NAME_REAL_PRIMARY_DOWNLOAD_PATH, str).apply();
        return str;
    }

    final String getRealSlaveDownloadPath(String str) {
        return getSharedPreferences().getString(NAME_REAL_SLAVE_DOWNLOAD_PATH, str);
    }

    final String setRealSlaveDownloadPath(String str) {
        getSharedPreferences().edit().putString(NAME_REAL_SLAVE_DOWNLOAD_PATH, str).apply();
        return str;
    }

    public boolean getAutoSyncToLixianSpaceFlag() {
        return getSharedPreferences().getBoolean(NAME_AUTO_SYNC_TO_LIXIAN_SPACE, true);
    }

    public boolean setAutoSyncToLixianSpaceFlag(boolean z) {
        getSharedPreferences().edit().putBoolean(NAME_AUTO_SYNC_TO_LIXIAN_SPACE, z).apply();
        return z;
    }
}
