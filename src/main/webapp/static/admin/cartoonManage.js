$(function () {

});

function searchCartoon(){
    $("#dg").datagrid("load",{
        "name":$("#s_name").val()
    })
}

function formatImageName(val,row){
    return "<img width='100px' height='100px' src='/static/cartoonImage/"+val+"'>";
}

function openCartoonModifyTab(){
    
}

function deleteCartoon() {
    var selectdRows = $("#dg").datagrid("getSelections");
    if (selectdRows.length==0){
        $.messager.alert("系统提示","请选择要删除的数据！");
        return;
    }
    var strIds=[];
    for (var i = 0;i<selectdRows.length;i++){
        strIds.push(selectdRows[i].id);
    }
    var ids = strIds.join(",");
    $.messager.confirm("系统提示","您确定要删除这<font color='red'>"+selectdRows.length+"</font>条数据吗？",function(r){
        if (r){
            $.post("/admin/cartoon/delete",{"ids":ids},function (result){
                if (result.success){
                    $.messager.alert("系统提示","数据已删除成功");
                    $("#dg").datagrid("reload");
                }else{
                    $.messager.alert("系统提示","数据删除失败，请联系管理员");
                }
            },"json");
        }
    });

}


function openFilmModifyTab(){
    var selectedRows = $("#dg").datagrid("getSelections");
    if (selectedRows.length!=1){
        $.messager.alert("系统提示","请选择一条要修改的漫画");
        return;
    }
    var row = selectedRows[0];
    window.parent.openTab("修改漫画","modifyCartoon.html?id="+row.id,"icon-modifyFilm");
}