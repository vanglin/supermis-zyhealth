/**
 * 初始化评测记录管理详情对话框
 */
var EvarecordInfoDlg = {
    evarecordInfoData : {}
};

/**
 * 清除数据
 */
EvarecordInfoDlg.clearData = function() {
    this.evarecordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EvarecordInfoDlg.set = function(key, val) {
    this.evarecordInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EvarecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
EvarecordInfoDlg.close = function() {
    parent.layer.close(window.parent.Evarecord.layerIndex);
}

/**
 * 收集数据
 */
EvarecordInfoDlg.collectData = function() {
    this
    .set('id')
    .set('uid')
    .set('deviceId')
    .set('evaType')
    .set('evaValue')
    .set('evaTime')
    .set('symDescription')
    .set('medRecord')
    .set('latitude')
    .set('longitude')
    .set('alter');
}

/**
 * 提交添加
 */
EvarecordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/evarecord/add", function(data){
        Feng.success("添加成功!");
        window.parent.Evarecord.table.refresh();
        EvarecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.evarecordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
EvarecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/evarecord/update", function(data){
        Feng.success("修改成功!");
        window.parent.Evarecord.table.refresh();
        EvarecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.evarecordInfoData);
    ajax.start();
}

$(function() {

});
