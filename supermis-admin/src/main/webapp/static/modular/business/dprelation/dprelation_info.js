/**
 * 初始化详情对话框
 */
var DprelationInfoDlg = {
    dprelationInfoData : {}
};

/**
 * 清除数据
 */
DprelationInfoDlg.clearData = function() {
    this.dprelationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DprelationInfoDlg.set = function(key, val) {
    this.dprelationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DprelationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DprelationInfoDlg.close = function() {
    parent.layer.close(window.parent.Dprelation.layerIndex);
}

/**
 * 收集数据
 */
DprelationInfoDlg.collectData = function() {
    this
    .set('id')
    .set('doctorId')
    .set('patientId')
    .set('status')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
DprelationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dprelation/add", function(data){
        Feng.success("添加成功!");
        window.parent.Dprelation.table.refresh();
        DprelationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dprelationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DprelationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dprelation/update", function(data){
        Feng.success("修改成功!");
        window.parent.Dprelation.table.refresh();
        DprelationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dprelationInfoData);
    ajax.start();
}

$(function() {

});
