$(window).on('load',function(){

    $.ajax({
        type:'post',
        url:'/admin/type/getTypes',
        data:{},
        dataType:'json',
        async:false,
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

    var id = getQueryString('id');
        $.ajax({
        type:'post',
        url:'/admin/cartoon/findById',
        data:{id:id},
        dataType:'json',
        success:function(result){
            $("#name").val(result.name);
            $("#id").val(result.id);
            $("#title").val(result.title);
            $("#panUrl").val(result.panUrl);
        }
    })

});

function getQueryString(name){
    var reg = new RegExp("(^|&amp;)"+ name +"=([^&amp;]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return r[2]; return '';
}