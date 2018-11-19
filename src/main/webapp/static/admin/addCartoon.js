$(function(){

    $.ajax({
        type:'post',
        url:'/admin/type/getTypes',
        data:{},
        dataType:'json',
        success:function(result){
            var typeHtml = "";
            if (result!= '' && result != null){
                for (var i=0;i<result.length;i++){
                    typeHtml += "<input type='checkbox' id='type' name='type' value='"+result[i].id+"'>"+result[i].typeName+"&nbsp;";
                }
                $("#typeCheckBox").html(typeHtml);
            }

        }
    });


    $.ajax({
        type:'post',
        url:'/admin/district/getDistricts',
        data:{},
        dataType:'json',
        success:function(result){
            if (result != '' && result != null){
                var districtHtml = "";
                for (var i = 0;i < result.length;i++){
                    districtHtml += "<input type='radio' name='districtId' id='districtId' value='"+result[i].id+"'>"+result[i].districtName+"&nbsp;";
                }
                $("#districtCheckBox").html(districtHtml);
            }
        }
    });

});

function submitData(){
    $("#fm").form("submit",{
        url:"/admin/cartoon/save",
        onSubmit:function(){
            var content = CKEDITOR.instances.content.getData();
            if (content == ""){
                $.messager.alert("系统提示","内容不能为空");
            }
            return $(this).form("validate");
        },
        success:function (result) {
            var result = eval('('+result+')');
            if (result.success){
                $.messager.alert("系统提示","保存成功");
                resetValue();
            } else{
                $.messager.alert("系统提示","保存失败")
            }
        }
    });
}




function resetValue(){
    $("#name").val("");
    $("#title").val("");
    $("#districtId").prop("check",false);
    $("#type").prop("check",false);
    $("#panUrl").val("");
    $("#imageFile").val("");
    CKEDITOR.instances.content.setData("");
}
