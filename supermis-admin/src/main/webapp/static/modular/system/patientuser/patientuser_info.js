/**
 * 初始化普通用户信息管理详情对话框
 */
var PatientuserInfoDlg = {
    patientuserInfoData : {}
};

/**
 * 清除数据
 */
PatientuserInfoDlg.clearData = function() {
    this.patientuserInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PatientuserInfoDlg.set = function(key, val) {
    this.patientuserInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PatientuserInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PatientuserInfoDlg.close = function() {
    parent.layer.close(window.parent.Patientuser.layerIndex);
}

/**
 * 收集数据
 */
PatientuserInfoDlg.collectData = function() {
    this
    .set('id')
    .set('username')
    .set('IDCardNo')
    .set('age')
    .set('permAddr')
    .set('mobile')
    .set('firstRelName')
    .set('firstRelMobile')
    .set('secondRelName')
    .set('secondRelMobile');
}

/**
 * 提交添加
 */
PatientuserInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/patientuser/add", function(data){
        Feng.success("添加成功!");
        window.parent.Patientuser.table.refresh();
        PatientuserInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.patientuserInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PatientuserInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/patientuser/update", function(data){
        Feng.success("修改成功!");
        window.parent.Patientuser.table.refresh();
        PatientuserInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.patientuserInfoData);
    ajax.start();
}

$(function() {

});
