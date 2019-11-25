/**
 * 评测记录管理管理初始化
 */
var Evarecord = {
    id: "EvarecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Evarecord.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '评测用户编号', field: 'uid', visible: true, align: 'center', valign: 'middle'},
            {title: '设备编号', field: 'deviceId', visible: true, align: 'center', valign: 'middle'},
            {title: '评测类型，PEF、FEV1、FEV6、FVC、ACT、RQLQ', field: 'evaType', visible: true, align: 'center', valign: 'middle'},
            {title: '评测值', field: 'evaValue', visible: true, align: 'center', valign: 'middle'},
            {title: '评测时间', field: 'evaTime', visible: true, align: 'center', valign: 'middle'},
            {title: '症状描述', field: 'symDescription', visible: true, align: 'center', valign: 'middle'},
            {title: '用药记录', field: 'medRecord', visible: true, align: 'center', valign: 'middle'},
            {title: '当前位置纬度(latitude,float)', field: 'latitude', visible: true, align: 'center', valign: 'middle'},
            {title: '当前位置经度', field: 'longitude', visible: true, align: 'center', valign: 'middle'},
            {title: '候选域', field: 'alter', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Evarecord.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Evarecord.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加评测记录管理
 */
Evarecord.openAddEvarecord = function () {
    var index = layer.open({
        type: 2,
        title: '添加评测记录管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/evarecord/evarecord_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看评测记录管理详情
 */
Evarecord.openEvarecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '评测记录管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/evarecord/evarecord_update/' + Evarecord.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除评测记录管理
 */
Evarecord.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/evarecord/delete", function (data) {
            Feng.success("删除成功!");
            Evarecord.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("evarecordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询评测记录管理列表
 */
Evarecord.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Evarecord.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Evarecord.initColumn();
    var table = new BSTable(Evarecord.id, "/evarecord/list", defaultColunms);
    table.setPaginationType("client");
    Evarecord.table = table.init();
});
