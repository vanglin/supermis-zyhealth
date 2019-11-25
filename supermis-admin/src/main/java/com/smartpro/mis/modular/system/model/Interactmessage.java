package com.smartpro.mis.modular.system.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 互动留言表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public class Interactmessage extends Model<Interactmessage> {

    private static final long serialVersionUID = 1L;

    /**
     * 消息编号
     */
    private Long id;
    /**
     * 消息主人
     */
    private Integer mesOwner;
    /**
     * 对方编号
     */
    private Integer contraid;
    /**
     * 消息发送者编号
     */
    private Integer megSender;
    private Integer megReciver;
    /**
     * 消息内容
     */
    private String megContent;
    private Date sendTime;
    private Date readTime;
    /**
     * 消息是否已读,1表示已读，0未读
     */
    private Integer isRead;
    /**
     * 消息类型,1表示普通消息，2表示系统消息
     */
    private Integer megType;
    /**
     * 备选列
     */
    private String altercol;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMesOwner() {
        return mesOwner;
    }

    public void setMesOwner(Integer mesOwner) {
        this.mesOwner = mesOwner;
    }

    public Integer getContraid() {
        return contraid;
    }

    public void setContraid(Integer contraid) {
        this.contraid = contraid;
    }

    public Integer getMegSender() {
        return megSender;
    }

    public void setMegSender(Integer megSender) {
        this.megSender = megSender;
    }

    public Integer getMegReciver() {
        return megReciver;
    }

    public void setMegReciver(Integer megReciver) {
        this.megReciver = megReciver;
    }

    public String getMegContent() {
        return megContent;
    }

    public void setMegContent(String megContent) {
        this.megContent = megContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getMegType() {
        return megType;
    }

    public void setMegType(Integer megType) {
        this.megType = megType;
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
        return "Interactmessage{" +
        "id=" + id +
        ", mesOwner=" + mesOwner +
        ", contraid=" + contraid +
        ", megSender=" + megSender +
        ", megReciver=" + megReciver +
        ", megContent=" + megContent +
        ", sendTime=" + sendTime +
        ", readTime=" + readTime +
        ", isRead=" + isRead +
        ", megType=" + megType +
        ", altercol=" + altercol +
        "}";
    }
}
