package com.smartpro.mis.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 药物表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public class Globaldrug extends Model<Globaldrug> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 药物名称
     */
    private String drug;
    /**
     * 药物功能描述
     */
    private String functionDescript;
    /**
     * 治疗症状
     */
    private String treatSymptoms;
    /**
     * 不良反应
     */
    private String advEffect;
    private Integer stock;
    /**
     * 供应商
     */
    private String supplier;
    /**
     * 用量管理
     */
    private String dosageManage;
    /**
     * 添加时间
     */
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

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getFunctionDescript() {
        return functionDescript;
    }

    public void setFunctionDescript(String functionDescript) {
        this.functionDescript = functionDescript;
    }

    public String getTreatSymptoms() {
        return treatSymptoms;
    }

    public void setTreatSymptoms(String treatSymptoms) {
        this.treatSymptoms = treatSymptoms;
    }

    public String getAdvEffect() {
        return advEffect;
    }

    public void setAdvEffect(String advEffect) {
        this.advEffect = advEffect;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDosageManage() {
        return dosageManage;
    }

    public void setDosageManage(String dosageManage) {
        this.dosageManage = dosageManage;
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
        return "Globaldrug{" +
        "id=" + id +
        ", drug=" + drug +
        ", functionDescript=" + functionDescript +
        ", treatSymptoms=" + treatSymptoms +
        ", advEffect=" + advEffect +
        ", stock=" + stock +
        ", supplier=" + supplier +
        ", dosageManage=" + dosageManage +
        ", createTime=" + createTime +
        ", altercol=" + altercol +
        "}";
    }
}
