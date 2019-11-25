package com.smartpro.mis.modular.business.apiEntity;

/**
 * Created by Mengiy on 2018/3/21.
 */
public class EvaRecordParams {
      private int uid;
    private String evaType;
    private String deviceId;
    private String startTime;
    private String endTime;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEvaType() {
        return evaType;
    }

    public void setEvaType(String evaType) {
        this.evaType = evaType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
