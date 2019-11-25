package com.smartpro.mis.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户用药记录表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public class Userdrugrecord extends Model<Userdrugrecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户编号
     */
    private Integer uid;
    /**
     * 药物编号
     */
    private Integer drugId;
    /**
     * 开始使用时间
     */
    private Date startUseTime;
    /**
     * 结束使用时间
     */
    private Date endUseTime;
    /**
     * 用药数量
     */
    private Integer drugNum;
    /**
     * 记录时间
     */
    private Date recordTime;
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

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Date getStartUseTime() {
        return startUseTime;
    }

    public void setStartUseTime(Date startUseTime) {
        this.startUseTime = startUseTime;
    }

    public Date getEndUseTime() {
        return endUseTime;
    }

    public void setEndUseTime(Date endUseTime) {
        this.endUseTime = endUseTime;
    }

    public Integer getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(Integer drugNum) {
        this.drugNum = drugNum;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
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
        return "Userdrugrecord{" +
        "id=" + id +
        ", uid=" + uid +
        ", drugId=" + drugId +
        ", startUseTime=" + startUseTime +
        ", endUseTime=" + endUseTime +
        ", drugNum=" + drugNum +
        ", recordTime=" + recordTime +
        ", altercol=" + altercol +
        "}";
    }
}
