package com.smartpro.mis.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 评测记录表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-21
 */
public class Evarecord extends Model<Evarecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 评测用户编号
     */
    private Integer uid;
    /**
     * 设备编号
     */
    private Integer deviceId;
    /**
     * 评测类型，PEF、FEV1、FEV6、FVC、ACT、RQLQ
     */
    private String evaType;
    /**
     * 评测值
     */
    private String evaValue;
    /**
     * 评测时间
     */
    private String evaTime;
    /**
     * 症状描述
     */
    private String symDescription;
    /**
     * 用药记录
     */
    private String medRecord;
    /**
     * 当前位置纬度(latitude,float)
     */
    private Float latitude;
    /**
     * 当前位置经度
     */
    private Float longitude;
    /**
     * 候选域
     */
    private String altercol;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getEvaType() {
        return evaType;
    }

    public void setEvaType(String evaType) {
        this.evaType = evaType;
    }

    public String getEvaValue() {
        return evaValue;
    }

    public void setEvaValue(String evaValue) {
        this.evaValue = evaValue;
    }

    public String getEvaTime() {
        return evaTime;
    }

    public void setEvaTime(String evaTime) {
        this.evaTime = evaTime;
    }

    public String getSymDescription() {
        return symDescription;
    }

    public void setSymDescription(String symDescription) {
        this.symDescription = symDescription;
    }

    public String getMedRecord() {
        return medRecord;
    }

    public void setMedRecord(String medRecord) {
        this.medRecord = medRecord;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getAltercol() {
        return altercol;
    }

    public void setAltercol(String altercol) {
        this.altercol = altercol;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Evarecord{" +
        "id=" + id +
        ", uid=" + uid +
        ", deviceId=" + deviceId +
        ", evaType=" + evaType +
        ", evaValue=" + evaValue +
        ", evaTime=" + evaTime +
        ", symDescription=" + symDescription +
        ", medRecord=" + medRecord +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        ", alter=" + altercol +
        "}";
    }
}
