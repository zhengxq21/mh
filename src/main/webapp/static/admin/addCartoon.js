$(function(){

    $.ajax({
        type:'post',
        url:'/type/getTypes',
        data:{},
        dataType:'json',
        success:function(result){

        }
    })


    $.ajax({
        type:'post',
        url:'/district/getDistricts',
        data:{},
        dataType:'json',
        success:function(result){
        }
    })

});