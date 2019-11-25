package com.smartpro.mis.modular.business.apiEntity;

import java.util.Date;

/**
 * Created by Mengiy on 2018/3/22.
 */
public class UserDeviceParams {
    private int id;
    private int uid;
    private int deviceId;
    private Date leaseStartTime;
    private int leaseTime;
    private float deviceInitValue;
    private String altercol;
    private String deviceName;
    private String deviceType;
    private String functions;
    private String functionDesc;
    private String manufacturer;
    private String deviceModel;
    private String productDate;
    private String expirationDate;
    private int devicePrice;
    private int deviceStock;
    private String deviceImg;
    private Date createTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public int getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(int leaseTime) {
        this.leaseTime = leaseTime;
    }

    public float getDeviceInitValue() {
        return deviceInitValue;
    }

    public void setDeviceInitValue(float deviceInitValue) {
        this.deviceInitValue = deviceInitValue;
    }

    public String getAltercol() {
        return altercol;
    }

    public void setAltercol(String altercol) {
        this.altercol = altercol;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getFunctionDesc() {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc) {
        this.functionDesc = functionDesc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getDevicePrice() {
        return devicePrice;
    }

    public void setDevicePrice(int devicePrice) {
        this.devicePrice = devicePrice;
    }

    public int getDeviceStock() {
        return deviceStock;
    }

    public void setDeviceStock(int deviceStock) {
        this.deviceStock = deviceStock;
    }

    public String getDeviceImg() {
        return deviceImg;
    }

    public void setDeviceImg(String deviceImg) {
        this.deviceImg = deviceImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
