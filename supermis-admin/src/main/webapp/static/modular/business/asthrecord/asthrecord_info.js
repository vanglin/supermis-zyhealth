/**
 * 初始化哮喘记录管理详情对话框
 */
var AsthrecordInfoDlg = {
    asthrecordInfoData : {}
};

/**
 * 清除数据
 */
AsthrecordInfoDlg.clearData = function() {
    this.asthrecordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AsthrecordInfoDlg.set = function(key, val) {
    this.asthrecordInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AsthrecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AsthrecordInfoDlg.close = function() {
    parent.layer.close(window.parent.Asthrecord.layerIndex);
}

/**
 * 收集数据
 */
AsthrecordInfoDlg.collectData = function() {
    this
    .set('id')
    .set('followTime')
    .set('isMedTaking')
    .set('timesPerDay')
    .set('dosage')
    .set('cardNo')
    .set('drug')
    .set('firstUseDrugTime')
    .set('mediDay')
    .set('drugRoute')
    .set('patientName')
    .set('altercol');
}

/**
 * 提交添加
 */
AsthrecordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/asthrecord/add", function(data){
        Feng.success("添加成功!");
        window.parent.Asthrecord.table.refresh();
        AsthrecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.asthrecordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AsthrecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/asthrecord/update", function(data){
        Feng.success("修改成功!");
        window.parent.Asthrecord.table.refresh();
        AsthrecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.asthrecordInfoData);
    ajax.start();
}

$(function() {

});
