/**
 * 药物库管理初始化
 */
var Globaldrug = {
    id: "GlobaldrugTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Globaldrug.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '药物名称', field: 'drug', visible: true, align: 'center', valign: 'middle'},
            {title: '药物功能描述', field: 'functionDescript', visible: true, align: 'center', valign: 'middle'},
            {title: '治疗症状', field: 'treatSymptoms', visible: true, align: 'center', valign: 'middle'},
            {title: '不良反应', field: 'advEffect', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'stock', visible: true, align: 'center', valign: 'middle'},
            {title: '供应商', field: 'supplier', visible: true, align: 'center', valign: 'middle'},
            {title: '用量管理', field: 'dosageManage', visible: true, align: 'center', valign: 'middle'},
            {title: '添加时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '备选列', field: 'altercol', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Globaldrug.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Globaldrug.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加药物库
 */
Globaldrug.openAddGlobaldrug = function () {
    var index = layer.open({
        type: 2,
        title: '添加药物库',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/globaldrug/globaldrug_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看药物库详情
 */
Globaldrug.openGlobaldrugDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '药物库详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/globaldrug/globaldrug_update/' + Globaldrug.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除药物库
 */
Globaldrug.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/globaldrug/delete", function (data) {
            Feng.success("删除成功!");
            Globaldrug.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("globaldrugId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询药物库列表
 */
Globaldrug.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Globaldrug.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Globaldrug.initColumn();
    var table = new BSTable(Globaldrug.id, "/globaldrug/list", defaultColunms);
    table.setPaginationType("client");
    Globaldrug.table = table.init();
});
