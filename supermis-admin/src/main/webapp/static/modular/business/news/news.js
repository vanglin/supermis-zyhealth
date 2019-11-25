/**
 * 新闻资讯管理初始化
 */
var News = {
    id: "NewsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
News.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键，资讯编号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '资讯类别，1表示健康资讯类,2表示哮喘管理类，3表示设备资讯类', field: 'newsType', visible: true, align: 'center', valign: 'middle'},
            {title: '资讯标题', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '新闻内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'modTime', visible: true, align: 'center', valign: 'middle'},
            {title: '编辑人', field: 'editor', visible: true, align: 'center', valign: 'middle'},
            {title: '面向人群的角色', field: 'roleid', visible: true, align: 'center', valign: 'middle'},
            {title: '阅读次数', field: 'readCount', visible: true, align: 'center', valign: 'middle'},
            {title: '当前状态，1表示可用，2表示不可用', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '备选列', field: 'alterCol', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
News.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        News.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加新闻资讯
 */
News.openAddNews = function () {
    var index = layer.open({
        type: 2,
        title: '添加新闻资讯',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/news/news_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看新闻资讯详情
 */
News.openNewsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '新闻资讯详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/news/news_update/' + News.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除新闻资讯
 */
News.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/news/delete", function (data) {
            Feng.success("删除成功!");
            News.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("newsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询新闻资讯列表
 */
News.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    News.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = News.initColumn();
    var table = new BSTable(News.id, "/news/list", defaultColunms);
    table.setPaginationType("client");
    News.table = table.init();
});
