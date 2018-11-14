$(window).on('load',function(){
    var id = getQueryString('id');
        $.ajax({
        type:'post',
        url:'/cartoon/findById',
        data:{id:id},
        dataType:'json',
        success:function(result){
        }
    })

});

function getQueryString(name){
    var reg = new RegExp("(^|&amp;)"+ name +"=([^&amp;]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return r[2]; return '';
}