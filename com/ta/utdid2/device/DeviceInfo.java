package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.android.utils.PhoneInfoUtils;
import com.ta.utdid2.android.utils.StringUtils;
import java.util.zip.Adler32;

public class DeviceInfo {
    static final Object CREATE_DEVICE_METADATA_LOCK = new Object();
    static String HMAC_KEY = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
    static final byte UTDID_VERSION_CODE = (byte) 1;
    private static Device mDevice;

    static long getMetadataCheckSum(Device device) {
        if (device != null) {
            device = String.format("%s%s%s%s%s", new Object[]{device.getUtdid(), device.getDeviceId(), Long.valueOf(device.getCreateTimestamp()), device.getImsi(), device.getImei()});
            if (!StringUtils.isEmpty(device)) {
                Adler32 adler32 = new Adler32();
                adler32.reset();
                adler32.update(device.getBytes());
                return adler32.getValue();
            }
        }
        return 0;
    }

    private static Device _initDeviceMetadata(Context context) {
        if (context != null) {
            Device device = new Device();
            synchronized (CREATE_DEVICE_METADATA_LOCK) {
                String value = UTUtdid.instance(context).getValue();
                if (!StringUtils.isEmpty(value)) {
                    if (value.endsWith("\n")) {
                        value = value.substring(0, value.length() - 1);
                    }
                    Device device2 = new Device();
                    long currentTimeMillis = System.currentTimeMillis();
                    String imei = PhoneInfoUtils.getImei(context);
                    context = PhoneInfoUtils.getImsi(context);
                    device2.setDeviceId(imei);
                    device2.setImei(imei);
                    device2.setCreateTimestamp(currentTimeMillis);
                    device2.setImsi(context);
                    device2.setUtdid(value);
                    device2.setCheckSum(getMetadataCheckSum(device2));
                    return device2;
                }
            }
        }
        return null;
    }

    public static synchronized Device getDevice(Context context) {
        synchronized (DeviceInfo.class) {
            if (mDevice != null) {
                context = mDevice;
                return context;
            } else if (context != null) {
                context = _initDeviceMetadata(context);
                mDevice = context;
                return context;
            } else {
                return null;
            }
        }
    }
}
