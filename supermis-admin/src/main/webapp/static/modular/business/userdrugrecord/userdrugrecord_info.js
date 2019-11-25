/**
 * 初始化用户药物记录详情对话框
 */
var UserdrugrecordInfoDlg = {
    userdrugrecordInfoData : {}
};

/**
 * 清除数据
 */
UserdrugrecordInfoDlg.clearData = function() {
    this.userdrugrecordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserdrugrecordInfoDlg.set = function(key, val) {
    this.userdrugrecordInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UserdrugrecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
UserdrugrecordInfoDlg.close = function() {
    parent.layer.close(window.parent.Userdrugrecord.layerIndex);
}

/**
 * 收集数据
 */
UserdrugrecordInfoDlg.collectData = function() {
    this
    .set('id')
    .set('uid')
    .set('drugId')
    .set('startUseTime')
    .set('endUseTime')
    .set('drugNum')
    .set('recordTime')
    .set('altercol');
}

/**
 * 提交添加
 */
UserdrugrecordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/userdrugrecord/add", function(data){
        Feng.success("添加成功!");
        window.parent.Userdrugrecord.table.refresh();
        UserdrugrecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userdrugrecordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
UserdrugrecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/userdrugrecord/update", function(data){
        Feng.success("修改成功!");
        window.parent.Userdrugrecord.table.refresh();
        UserdrugrecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.userdrugrecordInfoData);
    ajax.start();
}

$(function() {

});
