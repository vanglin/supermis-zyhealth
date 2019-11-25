/**
 * 哮喘记录管理管理初始化
 */
var Asthrecord = {
    id: "AsthrecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Asthrecord.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '编号，主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '随访时间', field: 'followTime', visible: true, align: 'center', valign: 'middle'},
            {title: '至此次随访是否仍在服用', field: 'isMedTaking', visible: true, align: 'center', valign: 'middle'},
            {title: '每日服用次数', field: 'timesPerDay', visible: true, align: 'center', valign: 'middle'},
            {title: '每次剂量', field: 'dosage', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证号', field: 'cardNo', visible: true, align: 'center', valign: 'middle'},
            {title: '药物名称', field: 'drug', visible: true, align: 'center', valign: 'middle'},
            {title: '开始使用时间', field: 'firstUseDrugTime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'mediDay', visible: true, align: 'center', valign: 'middle'},
            {title: '给药途径', field: 'drugRoute', visible: true, align: 'center', valign: 'middle'},
            {title: '病人姓名', field: 'patientName', visible: true, align: 'center', valign: 'middle'},
            {title: '备选列', field: 'altercol', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Asthrecord.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Asthrecord.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加哮喘记录管理
 */
Asthrecord.openAddAsthrecord = function () {
    var index = layer.open({
        type: 2,
        title: '添加哮喘记录管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/asthrecord/asthrecord_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看哮喘记录管理详情
 */
Asthrecord.openAsthrecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '哮喘记录管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/asthrecord/asthrecord_update/' + Asthrecord.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除哮喘记录管理
 */
Asthrecord.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/asthrecord/delete", function (data) {
            Feng.success("删除成功!");
            Asthrecord.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("asthrecordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询哮喘记录管理列表
 */
Asthrecord.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Asthrecord.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Asthrecord.initColumn();
    var table = new BSTable(Asthrecord.id, "/asthrecord/list", defaultColunms);
    table.setPaginationType("client");
    Asthrecord.table = table.init();
});
