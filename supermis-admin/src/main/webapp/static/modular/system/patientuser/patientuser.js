/**
 * 普通用户信息管理管理初始化
 */
var Patientuser = {
    id: "PatientuserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Patientuser.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '人员信息编号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'username', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证号', field: 'IDCardNo', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'age', visible: true, align: 'center', valign: 'middle'},
            {title: '长住地址', field: 'permAddr', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号码', field: 'mobile', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'firstRelName', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'firstRelMobile', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'secondRelName', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'secondRelMobile', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Patientuser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Patientuser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加普通用户信息管理
 */
Patientuser.openAddPatientuser = function () {
    var index = layer.open({
        type: 2,
        title: '添加普通用户信息管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/patientuser/patientuser_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看普通用户信息管理详情
 */
Patientuser.openPatientuserDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '普通用户信息管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/patientuser/patientuser_update/' + Patientuser.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除普通用户信息管理
 */
Patientuser.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/patientuser/delete", function (data) {
            Feng.success("删除成功!");
            Patientuser.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("patientuserId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询普通用户信息管理列表
 */
Patientuser.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Patientuser.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Patientuser.initColumn();
    var table = new BSTable(Patientuser.id, "/patientuser/list", defaultColunms);
    table.setPaginationType("client");
    Patientuser.table = table.init();
});
