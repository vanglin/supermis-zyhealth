/**
 * 初始化用户设备管理详情对话框
 */
var UserdeviceInfoDlg = {
    userdeviceInfoData : {}
};

/**
 * 清除数据
 */
UserdeviceInfoDlg.clearData = function() {
    this.userdeviceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserdeviceInfoDlg.set = function(key, val) {
    this.userdeviceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserdeviceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
UserdeviceInfoDlg.close = function() {
    parent.layer.close(window.parent.Userdevice.layerIndex);
}

/**
 * 收集数据
 */
UserdeviceInfoDlg.collectData = function() {
    this
    .set('id')
    .set('uid')
    .set('deviceId')
    .set('leaseStartTime')
    .set('leaseTime')
    .set('deviceInitValue')
    .set('altercol');
}

/**
 * 提交添加
 */
UserdeviceInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/userdevice/add", function(data){
        Feng.success("添加成功!");
        window.parent.Userdevice.table.refresh();
        UserdeviceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userdeviceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
UserdeviceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/userdevice/update", function(data){
        Feng.success("修改成功!");
        window.parent.Userdevice.table.refresh();
        UserdeviceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userdeviceInfoData);
    ajax.start();
}

$(function() {

});
