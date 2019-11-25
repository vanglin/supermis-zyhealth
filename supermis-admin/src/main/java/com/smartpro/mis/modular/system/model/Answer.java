package com.smartpro.mis.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author smartpro123
 * @since 2018-04-22
 */
@TableName("answer")
public class Answer extends Model<Answer> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 提问者编号
     */
    private Integer megOwner;
    /**
     * 回答者编号
     */
    private Integer answerId;
    /**
     * 问题内容
     */
    private String question;
    /**
     * 回答内容
     */
    private String answer;
    /**
     * 1表示已回复，0表示未回复
     */
    private Integer isReply;
    /**
     * 提问时间
     */
    private Date qaTime;
    /**
     * 回答时间
     */
    private Date replyTime;
    /**
     * 是否有效
     */
    private Integer isValid;
    /**
     * 可选字段
     */
    private String alterCon;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMegOwner() {
        return megOwner;
    }

    public void setMegOwner(Integer megOwner) {
        this.megOwner = megOwner;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getIsReply() {
        return isReply;
    }

    public void setIsReply(Integer isReply) {
        this.isReply = isReply;
    }

    public Date getQaTime() {
        return qaTime;
    }

    public void setQaTime(Date qaTime) {
        this.qaTime = qaTime;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getAlterCon() {
        return alterCon;
    }

    public void setAlterCon(String alterCon) {
        this.alterCon = alterCon;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Answer{" +
        "id=" + id +
        ", megOwner=" + megOwner +
        ", answerId=" + answerId +
        ", question=" + question +
        ", answer=" + answer +
        ", isReply=" + isReply +
        ", qaTime=" + qaTime +
        ", replyTime=" + replyTime +
        ", isValid=" + isValid +
        ", alterCon=" + alterCon +
        "}";
    }
}
