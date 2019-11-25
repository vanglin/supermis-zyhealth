package com.smartpro.mis.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 普通用户信息表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-20
 */
@TableName("patientUser")
public class Patientuser extends Model<Patientuser> {

    private static final long serialVersionUID = 1L;

    /**
     * 人员信息编号
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    private String username;
    /**
     * 身份证号
     */
    private String cardNo;
    private Integer age;
    /**
     * 长住地址
     */
    private String permAddr;
    /**
     * 手机号码
     */
    private String mobile;
    private String firstRelName;
    private String firstRelMobile;
    private String secondRelName;
    private String secondRelMobile;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPermAddr() {
        return permAddr;
    }

    public void setPermAddr(String permAddr) {
        this.permAddr = permAddr;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirstRelName() {
        return firstRelName;
    }

    public void setFirstRelName(String firstRelName) {
        this.firstRelName = firstRelName;
    }

    public String getFirstRelMobile() {
        return firstRelMobile;
    }

    public void setFirstRelMobile(String firstRelMobile) {
        this.firstRelMobile = firstRelMobile;
    }

    public String getSecondRelName() {
        return secondRelName;
    }

    public void setSecondRelName(String secondRelName) {
        this.secondRelName = secondRelName;
    }

    public String getSecondRelMobile() {
        return secondRelMobile;
    }

    public void setSecondRelMobile(String secondRelMobile) {
        this.secondRelMobile = secondRelMobile;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Patientuser{" +
        "id=" + id +
        ", username=" + username +
        ", cardNo=" + cardNo +
        ", age=" + age +
        ", permAddr=" + permAddr +
        ", mobile=" + mobile +
        ", firstRelName=" + firstRelName +
        ", firstRelMobile=" + firstRelMobile +
        ", secondRelName=" + secondRelName +
        ", secondRelMobile=" + secondRelMobile +
        "}";
    }
}
