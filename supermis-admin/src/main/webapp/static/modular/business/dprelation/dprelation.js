/**
 * 管理初始化
 */
var Dprelation = {
    id: "DprelationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Dprelation.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '医生编号', field: 'doctorId', visible: true, align: 'center', valign: 'middle'},
            {title: '病人编号', field: 'patientId', visible: true, align: 'center', valign: 'middle'},
            {title: '关系是否有效，1表示有效，-1无效', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Dprelation.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Dprelation.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Dprelation.openAddDprelation = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dprelation/dprelation_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Dprelation.openDprelationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dprelation/dprelation_update/' + Dprelation.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Dprelation.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/dprelation/delete", function (data) {
            Feng.success("删除成功!");
            Dprelation.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("dprelationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
Dprelation.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Dprelation.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Dprelation.initColumn();
    var table = new BSTable(Dprelation.id, "/dprelation/list", defaultColunms);
    table.setPaginationType("client");
    Dprelation.table = table.init();
});
