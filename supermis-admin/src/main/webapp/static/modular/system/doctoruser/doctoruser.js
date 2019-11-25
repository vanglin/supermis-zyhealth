/**
 * 医生信息管理初始化
 */
var Doctoruser = {
    id: "DoctoruserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Doctoruser.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'username', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'IDCardNo', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'hospitalName', visible: true, align: 'center', valign: 'middle'},
            {title: '医院地址', field: 'hospitalAddr', visible: true, align: 'center', valign: 'middle'},
            {title: '科室', field: 'department', visible: true, align: 'center', valign: 'middle'},
            {title: '职称', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '医学专长', field: 'medSpecialty', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'mobile', visible: true, align: 'center', valign: 'middle'},
            {title: '综合评分', field: 'collScore', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Doctoruser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Doctoruser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加医生信息
 */
Doctoruser.openAddDoctoruser = function () {
    var index = layer.open({
        type: 2,
        title: '添加医生信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/doctoruser/doctoruser_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看医生信息详情
 */
Doctoruser.openDoctoruserDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '医生信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/doctoruser/doctoruser_update/' + Doctoruser.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除医生信息
 */
Doctoruser.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/doctoruser/delete", function (data) {
            Feng.success("删除成功!");
            Doctoruser.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("doctoruserId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询医生信息列表
 */
Doctoruser.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Doctoruser.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Doctoruser.initColumn();
    var table = new BSTable(Doctoruser.id, "/doctoruser/list", defaultColunms);
    table.setPaginationType("client");
    Doctoruser.table = table.init();
});
