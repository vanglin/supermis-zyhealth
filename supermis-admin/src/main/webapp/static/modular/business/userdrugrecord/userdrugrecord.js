/**
 * 用户药物记录管理初始化
 */
var Userdrugrecord = {
    id: "UserdrugrecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Userdrugrecord.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '用户编号', field: 'uid', visible: true, align: 'center', valign: 'middle'},
            {title: '药物编号', field: 'drugId', visible: true, align: 'center', valign: 'middle'},
            {title: '开始使用时间', field: 'startUseTime', visible: true, align: 'center', valign: 'middle'},
            {title: '结束使用时间', field: 'endUseTime', visible: true, align: 'center', valign: 'middle'},
            {title: '用药数量', field: 'drugNum', visible: true, align: 'center', valign: 'middle'},
            {title: '记录时间', field: 'recordTime', visible: true, align: 'center', valign: 'middle'},
            {title: '备选列', field: 'altercol', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Userdrugrecord.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Userdrugrecord.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户药物记录
 */
Userdrugrecord.openAddUserdrugrecord = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户药物记录',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/userdrugrecord/userdrugrecord_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户药物记录详情
 */
Userdrugrecord.openUserdrugrecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户药物记录详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/userdrugrecord/userdrugrecord_update/' + Userdrugrecord.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户药物记录
 */
Userdrugrecord.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/userdrugrecord/delete", function (data) {
            Feng.success("删除成功!");
            Userdrugrecord.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("userdrugrecordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户药物记录列表
 */
Userdrugrecord.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Userdrugrecord.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Userdrugrecord.initColumn();
    var table = new BSTable(Userdrugrecord.id, "/userdrugrecord/list", defaultColunms);
    table.setPaginationType("client");
    Userdrugrecord.table = table.init();
});
