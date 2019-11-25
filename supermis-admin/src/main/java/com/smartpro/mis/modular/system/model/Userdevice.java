package com.smartpro.mis.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户设备关系表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public class Userdevice extends Model<Userdevice> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer deviceId;
    /**
     * 设备租赁开始时间
     */
    private Date leaseStartTime;
    /**
     * 租赁时长
     */
    private Integer leaseTime;
    /**
     * 设备初始最佳值
     */
    private Float deviceInitValue;
    /**
     * 备选列
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

    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public Integer getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(Integer leaseTime) {
        this.leaseTime = leaseTime;
    }

    public Float getDeviceInitValue() {
        return deviceInitValue;
    }

    public void setDeviceInitValue(Float deviceInitValue) {
        this.deviceInitValue = deviceInitValue;
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
        return "Userdevice{" +
        "id=" + id +
        ", uid=" + uid +
        ", deviceId=" + deviceId +
        ", leaseStartTime=" + leaseStartTime +
        ", leaseTime=" + leaseTime +
        ", deviceInitValue=" + deviceInitValue +
        ", altercol=" + altercol +
        "}";
    }
}
