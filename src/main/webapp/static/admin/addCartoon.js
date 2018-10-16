$(function(){

    $.ajax({
        type:'post',
        url:'/type/getTypes',
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
    })


    $.ajax({
        type:'post',
        url:'/district/getDistricts',
        data:{},
        dataType:'json',
        success:function(result){
            if (result != '' && result != null){
                var districtHtml = "";
                for (var i = 0;i < result.length;i++){
                    districtHtml += "<input type='radio' name='district' id='district' value='"+result[i].id+"'>"+result[i].districtName+"&nbsp;";
                }
                $("#districtCheckBox").html(districtHtml);
            }
        }
    })

});