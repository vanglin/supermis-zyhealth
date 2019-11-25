package com.smartpro.mis.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 新闻资讯表
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-28
 */
public class News extends Model<News> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，资讯编号
     */
    private Integer id;
    /**
     * 资讯类别，1表示健康资讯类,2表示哮喘管理类，3表示设备资讯类
     */
    private Integer newsType;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 新闻内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modTime;
    /**
     * 编辑人
     */
    private String editor;
    /**
     * 面向人群的角色
     */
    private String roleid;
    /**
     * 阅读次数
     */
    private Long readCount;
    /**
     * 当前状态，1表示可用，2表示不可用
     */
    private Integer status;



    /**
     * 新闻图片
     */
    private String titleImg;
    /**
     * 外部链接
     */
    private String outlink;
    /**
     * 备选列
     */
    private String alterCol;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAlterCol() {
        return alterCol;
    }

    public void setAlterCol(String alterCol) {
        this.alterCol = alterCol;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public String getOutlink() {
        return outlink;
    }

    public void setOutlink(String outlink) {
        this.outlink = outlink;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "News{" +
        "id=" + id +
        ", newsType=" + newsType +
        ", title=" + title +
        ", content=" + content +
        ", createTime=" + createTime +
        ", modTime=" + modTime +
        ", editor=" + editor +
        ", roleid=" + roleid +
        ", readCount=" + readCount +
        ", status=" + status +
        ", alterCol=" + alterCol +
        "}";
    }
}
