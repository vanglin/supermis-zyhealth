/**
 * 初始化医生信息详情对话框
 */
var DoctoruserInfoDlg = {
    doctoruserInfoData : {}
};

/**
 * 清除数据
 */
DoctoruserInfoDlg.clearData = function() {
    this.doctoruserInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DoctoruserInfoDlg.set = function(key, val) {
    this.doctoruserInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DoctoruserInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DoctoruserInfoDlg.close = function() {
    parent.layer.close(window.parent.Doctoruser.layerIndex);
}

/**
 * 收集数据
 */
DoctoruserInfoDlg.collectData = function() {
    this
    .set('id')
    .set('username')
    .set('IDCardNo')
    .set('hospitalName')
    .set('hospitalAddr')
    .set('department')
    .set('title')
    .set('medSpecialty')
    .set('mobile')
    .set('collScore');
}

/**
 * 提交添加
 */
DoctoruserInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/doctoruser/add", function(data){
        Feng.success("添加成功!");
        window.parent.Doctoruser.table.refresh();
        DoctoruserInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.doctoruserInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DoctoruserInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/doctoruser/update", function(data){
        Feng.success("修改成功!");
        window.parent.Doctoruser.table.refresh();
        DoctoruserInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.doctoruserInfoData);
    ajax.start();
}

$(function() {

});
