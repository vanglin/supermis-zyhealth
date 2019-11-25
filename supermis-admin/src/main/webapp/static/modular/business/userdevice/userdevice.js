/**
 * 用户设备管理管理初始化
 */
var Userdevice = {
    id: "UserdeviceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Userdevice.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '序号，主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'uid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'deviceId', visible: true, align: 'center', valign: 'middle'},
            {title: '设备租赁开始时间', field: 'leaseStartTime', visible: true, align: 'center', valign: 'middle'},
            {title: '租赁时长', field: 'leaseTime', visible: true, align: 'center', valign: 'middle'},
            {title: '设备初始最佳值', field: 'deviceInitValue', visible: true, align: 'center', valign: 'middle'},
            {title: '备选列', field: 'altercol', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Userdevice.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Userdevice.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户设备管理
 */
Userdevice.openAddUserdevice = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户设备管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/userdevice/userdevice_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户设备管理详情
 */
Userdevice.openUserdeviceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户设备管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/userdevice/userdevice_update/' + Userdevice.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户设备管理
 */
Userdevice.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/userdevice/delete", function (data) {
            Feng.success("删除成功!");
            Userdevice.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("userdeviceId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户设备管理列表
 */
Userdevice.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Userdevice.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Userdevice.initColumn();
    var table = new BSTable(Userdevice.id, "/userdevice/list", defaultColunms);
    table.setPaginationType("client");
    Userdevice.table = table.init();
});
