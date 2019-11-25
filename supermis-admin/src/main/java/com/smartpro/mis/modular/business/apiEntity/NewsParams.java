package com.smartpro.mis.modular.business.apiEntity;

/**
 * Created by Mengiy on 2018/3/22.
 */
public class NewsParams {




    /**
     * 新闻资讯类型
     */
    private Integer newsType;
    /**
     * 面向群体角色
     */
    private String roleid;
    /**
     * 新闻创建者
     */
    private String editor;
    /**
     * 新闻创建时间
     */
    private String createTime;
    /**
     * 新闻状态，1表示可用，0不可用
     */
    private int status;
    /**
     * 查询的起点
     */
    private int start;

    /**
     * 查询的条数
     */
    private int num;

    /**
     * 备选列
     */
    private String altercol;

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAltercol() {
        return altercol;
    }

    public void setAltercol(String altercol) {
        this.altercol = altercol;
    }
}
