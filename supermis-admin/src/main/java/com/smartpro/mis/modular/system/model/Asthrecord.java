package com.smartpro.mis.modular.system.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 哮喘管理记录表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public class Asthrecord extends Model<Asthrecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号，主键
     */
    private Integer id;
    /**
     * 随访时间
     */
    private Date followTime;
    /**
     * 至此次随访是否仍在服用
     */
    private Integer isMedTaking;
    /**
     * 每日服用次数
     */
    private Integer timesPerDay;
    /**
     * 每次剂量
     */
    private Integer dosage;
    /**
     * 身份证号
     */
    private String cardNo;
    /**
     * 药物名称
     */
    private String drug;
    /**
     * 开始使用时间
     */
    private Date firstUseDrugTime;
    private Integer mediDay;
    /**
     * 给药途径
     */
    private String drugRoute;
    /**
     * 病人姓名
     */
    private String patientName;
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

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public Integer getIsMedTaking() {
        return isMedTaking;
    }

    public void setIsMedTaking(Integer isMedTaking) {
        this.isMedTaking = isMedTaking;
    }

    public Integer getTimesPerDay() {
        return timesPerDay;
    }

    public void setTimesPerDay(Integer timesPerDay) {
        this.timesPerDay = timesPerDay;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public Date getFirstUseDrugTime() {
        return firstUseDrugTime;
    }

    public void setFirstUseDrugTime(Date firstUseDrugTime) {
        this.firstUseDrugTime = firstUseDrugTime;
    }

    public Integer getMediDay() {
        return mediDay;
    }

    public void setMediDay(Integer mediDay) {
        this.mediDay = mediDay;
    }

    public String getDrugRoute() {
        return drugRoute;
    }

    public void setDrugRoute(String drugRoute) {
        this.drugRoute = drugRoute;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
        return "Asthrecord{" +
        "id=" + id +
        ", followTime=" + followTime +
        ", isMedTaking=" + isMedTaking +
        ", timesPerDay=" + timesPerDay +
        ", dosage=" + dosage +
        ", cardNo=" + cardNo +
        ", drug=" + drug +
        ", firstUseDrugTime=" + firstUseDrugTime +
        ", mediDay=" + mediDay +
        ", drugRoute=" + drugRoute +
        ", patientName=" + patientName +
        ", altercol=" + altercol +
        "}";
    }
}
