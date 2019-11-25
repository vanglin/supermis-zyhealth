/**
 * 留言管理初始化
 */
var Interactmessage = {
    id: "InteractmessageTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Interactmessage.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '消息编号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '消息主人', field: 'mesOwner', visible: true, align: 'center', valign: 'middle'},
            {title: '对方编号', field: 'contraid', visible: true, align: 'center', valign: 'middle'},
            {title: '消息发送者编号', field: 'megSender', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'megReciver', visible: true, align: 'center', valign: 'middle'},
            {title: '消息内容', field: 'megContent', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'sendTime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'readTime', visible: true, align: 'center', valign: 'middle'},
            {title: '消息是否已读,1表示已读，0未读', field: 'isRead', visible: true, align: 'center', valign: 'middle'},
            {title: '消息类型,1表示普通消息，2表示系统消息', field: 'megType', visible: true, align: 'center', valign: 'middle'},
            {title: '备选列', field: 'altercol', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Interactmessage.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Interactmessage.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加留言
 */
Interactmessage.openAddInteractmessage = function () {
    var index = layer.open({
        type: 2,
        title: '添加留言',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/interactmessage/interactmessage_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看留言详情
 */
Interactmessage.openInteractmessageDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '留言详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/interactmessage/interactmessage_update/' + Interactmessage.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除留言
 */
Interactmessage.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/interactmessage/delete", function (data) {
            Feng.success("删除成功!");
            Interactmessage.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("interactmessageId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询留言列表
 */
Interactmessage.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Interactmessage.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Interactmessage.initColumn();
    var table = new BSTable(Interactmessage.id, "/interactmessage/list", defaultColunms);
    table.setPaginationType("client");
    Interactmessage.table = table.init();
});
