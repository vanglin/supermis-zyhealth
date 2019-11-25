/**
 * 初始化药物库详情对话框
 */
var GlobaldrugInfoDlg = {
    globaldrugInfoData : {}
};

/**
 * 清除数据
 */
GlobaldrugInfoDlg.clearData = function() {
    this.globaldrugInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GlobaldrugInfoDlg.set = function(key, val) {
    this.globaldrugInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GlobaldrugInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
GlobaldrugInfoDlg.close = function() {
    parent.layer.close(window.parent.Globaldrug.layerIndex);
}

/**
 * 收集数据
 */
GlobaldrugInfoDlg.collectData = function() {
    this
    .set('id')
    .set('drug')
    .set('functionDescript')
    .set('treatSymptoms')
    .set('advEffect')
    .set('stock')
    .set('supplier')
    .set('dosageManage')
    .set('createTime')
    .set('altercol');
}

/**
 * 提交添加
 */
GlobaldrugInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/globaldrug/add", function(data){
        Feng.success("添加成功!");
        window.parent.Globaldrug.table.refresh();
        GlobaldrugInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.globaldrugInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
GlobaldrugInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/globaldrug/update", function(data){
        Feng.success("修改成功!");
        window.parent.Globaldrug.table.refresh();
        GlobaldrugInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.globaldrugInfoData);
    ajax.start();
}

$(function() {

});
