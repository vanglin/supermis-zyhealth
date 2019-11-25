package com.smartpro.mis.modular.business.apiEntity;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by Mengiy on 2018/3/22.
 */
public class MegParams {

    /**
     * 消息主人
     */
    @NotEmpty
    private Integer uid;
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
     *消息发送时间
     */
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

}
