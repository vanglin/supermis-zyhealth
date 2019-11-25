package com.smartpro.mis.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 设备表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public class Device extends Model<Device> {

    private static final long serialVersionUID = 1L;

    /**
     * 设备编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备类型
     */
    private String deviceType;
    /**
     * 功效类型
     */
    private String functions;
    /**
     * 功能描述
     */
    private String functionDesc;
    /**
     * 生产厂家
     */
    private String manufacturer;
    /**
     * 设备型号
     */
    private String deviceModel;
    /**
     * 出厂日期
     */
    private String productDate;
    /**
     * 设备保质期
     */
    private String expirationDate;
    /**
     * 设备单价
     */
    private Integer devicePrice;
    /**
     * 库存量
     */
    private Integer deviceStock;
    /**
     * 设备图片
     */
    private String deviceImg;
    private Date createTime;
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

    public Integer getDevicePrice() {
        return devicePrice;
    }

    public void setDevicePrice(Integer devicePrice) {
        this.devicePrice = devicePrice;
    }

    public Integer getDeviceStock() {
        return deviceStock;
    }

    public void setDeviceStock(Integer deviceStock) {
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
        return "Device{" +
        "id=" + id +
        ", deviceName=" + deviceName +
        ", deviceType=" + deviceType +
        ", functions=" + functions +
        ", functionDesc=" + functionDesc +
        ", manufacturer=" + manufacturer +
        ", deviceModel=" + deviceModel +
        ", productDate=" + productDate +
        ", expirationDate=" + expirationDate +
        ", devicePrice=" + devicePrice +
        ", deviceStock=" + deviceStock +
        ", deviceImg=" + deviceImg +
        ", createTime=" + createTime +
        ", altercol=" + altercol +
        "}";
    }
}
