package com.smartpro.mis.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 医生信息表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-20
 */
@TableName("doctorUser")
public class Doctoruser extends Model<Doctoruser> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String cardNo;
    private String hospitalName;
    /**
     * 医院地址
     */
    private String hospitalAddr;
    /**
     * 科室
     */
    private String department;
    /**
     * 职称
     */
    private String title;
    /**
     * 医学专长
     */
    private String medSpecialty;
    private String mobile;
    /**
     * 综合评分
     */
    private Float collScore;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddr() {
        return hospitalAddr;
    }

    public void setHospitalAddr(String hospitalAddr) {
        this.hospitalAddr = hospitalAddr;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedSpecialty() {
        return medSpecialty;
    }

    public void setMedSpecialty(String medSpecialty) {
        this.medSpecialty = medSpecialty;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Float getCollScore() {
        return collScore;
    }

    public void setCollScore(Float collScore) {
        this.collScore = collScore;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Doctoruser{" +
        "id=" + id +
        ", username=" + username +
        ", cardNo=" + cardNo +
        ", hospitalName=" + hospitalName +
        ", hospitalAddr=" + hospitalAddr +
        ", department=" + department +
        ", title=" + title +
        ", medSpecialty=" + medSpecialty +
        ", mobile=" + mobile +
        ", collScore=" + collScore +
        "}";
    }
}
