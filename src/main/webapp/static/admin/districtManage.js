$(function(){


});
var url;
function openDistrictAddDialog(){
    $("#dlg").dialog("open").dialog("setTitle","添加漫画地区信息");
    url = "/admin/district/save";
}

function openDistrictModifyDialog(){
    var selectedRows = $("#dg").datagrid("getSelections");
    if (selectedRows.length != 1){
        $.messager.alert("系统提示","请选择一条要编辑的数据");
        return;
    }
    var row = selectedRows[0];
    $("#fm").form("load",row);
    $("#dlg").dialog("open").dialog("setTitle","编辑漫画地区信息");
    url = "/admin/district/save?id"+rows.id;
}