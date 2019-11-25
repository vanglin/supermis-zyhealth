/**
 * 初始化留言详情对话框
 */
var InteractmessageInfoDlg = {
    interactmessageInfoData : {}
};

/**
 * 清除数据
 */
InteractmessageInfoDlg.clearData = function() {
    this.interactmessageInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InteractmessageInfoDlg.set = function(key, val) {
    this.interactmessageInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
InteractmessageInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
InteractmessageInfoDlg.close = function() {
    parent.layer.close(window.parent.Interactmessage.layerIndex);
}

/**
 * 收集数据
 */
InteractmessageInfoDlg.collectData = function() {
    this
    .set('id')
    .set('mesOwner')
    .set('contraid')
    .set('megSender')
    .set('megReciver')
    .set('megContent')
    .set('sendTime')
    .set('readTime')
    .set('isRead')
    .set('megType')
    .set('altercol');
}

/**
 * 提交添加
 */
InteractmessageInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/interactmessage/add", function(data){
        Feng.success("添加成功!");
        window.parent.Interactmessage.table.refresh();
        InteractmessageInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.interactmessageInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
InteractmessageInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/interactmessage/update", function(data){
        Feng.success("修改成功!");
        window.parent.Interactmessage.table.refresh();
        InteractmessageInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.interactmessageInfoData);
    ajax.start();
}

$(function() {

});
