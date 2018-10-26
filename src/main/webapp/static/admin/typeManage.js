$(function(){

});

var url;

function openTypeAddDialog(){
    $("#dlg").dialog("open").dialog("setTitle","添加漫画类型信息");
    url = "/admin/type/save";
}


function openTypeModifyDialog() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if (selectedRows.length != 1){
        $.messager.alert("系统提示","请选择一条要编辑的数据");
        return;
    }
    var row = selectedRows[0];
    $("#fm").form("load",row);
    $("#dlg").dialog("open").dialog("setTitle","修改漫画类型信息");
    $("#id").val(row.id);
    url = "/admin/type/save";
}


function deleteType(){
    var selectedRows = $("#dg").datagrid("getSelections");
    if (selectedRows.length == 0){
        $.messager.alert("系统提示","请选择要删除的数据");
    }
    var strIds=[];
    for (var i=0;i<selectedRows.length;i++){
        strIds.push(selectedRows[i].id);
    }
    var ids = strIds.join(",");
    $.messager.confirm("系统提示","您确定要删除这<font color=''red'>"+selectedRows.length+"</font>条数据吗？"
    ,function(r){
        $.post("/admin/type/delete",{"ids":ids},function (result) {
            if (result.success){
                $.messager.alert("系统提示","数据删除成功！");
                $("#dg").datagrid("reload");
            }else{
                $.messager.alert("系统提示","数据删除失败，请联系管理员");
            }
        },"json");
        });
}

function saveType(){
    $("#fm").form("submit",{
        url:url,
        onSubmit:function () {
            return $(this).form("validate");
        },
        success:function (result) {
            var result = eval('('+result+')');
            if (result.success){
                $.messager.alert("系统提示","保存成功！");
                resetValue();
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");
            }
        }
    },"json");
}

function resetValue(){
    $("#typeName").val("");
    $("#id").val("");
}

function closeTypeDialog(){
    resetValue();
    $("#dlg").dialog("close");
}