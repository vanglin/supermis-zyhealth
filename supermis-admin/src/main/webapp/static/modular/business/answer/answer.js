/**
 * 互动问答管理初始化
 */
var Answer = {
    id: "AnswerTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Answer.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '提问者编号', field: 'megOwner', visible: true, align: 'center', valign: 'middle'},
            {title: '回答者编号', field: 'answerId', visible: true, align: 'center', valign: 'middle'},
            {title: '问题内容', field: 'question', visible: true, align: 'center', valign: 'middle'},
            {title: '回答内容', field: 'answer', visible: true, align: 'center', valign: 'middle'},
            {title: '1表示已回复，0表示未回复', field: 'isReply', visible: true, align: 'center', valign: 'middle'},
            {title: '提问时间', field: 'qaTime', visible: true, align: 'center', valign: 'middle'},
            {title: '回答时间', field: 'replyTime', visible: true, align: 'center', valign: 'middle'},
            {title: '是否有效', field: 'isValid', visible: true, align: 'center', valign: 'middle'},
            {title: '可选字段', field: 'alterCon', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Answer.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Answer.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加互动问答
 */
Answer.openAddAnswer = function () {
    var index = layer.open({
        type: 2,
        title: '添加互动问答',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/answer/answer_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看互动问答详情
 */
Answer.openAnswerDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '互动问答详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/answer/answer_update/' + Answer.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除互动问答
 */
Answer.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/answer/delete", function (data) {
            Feng.success("删除成功!");
            Answer.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("answerId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询互动问答列表
 */
Answer.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Answer.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Answer.initColumn();
    var table = new BSTable(Answer.id, "/answer/list", defaultColunms);
    table.setPaginationType("client");
    Answer.table = table.init();
});
