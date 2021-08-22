// 定义最后光标对象
var lastEditRange;
$("#sendText").click(function(){

     // 获取选定对象
     var selection = getSelection()
     // 设置最后光标对象
     lastEditRange = selection.getRangeAt(0)

})

function chooseEmoji(id){
    console.log("选中id:",id.src)
    $("#sendText").click();
    $("#sendText").append(id);
}

//追加个人消息
function addMyselfMessage(){
        var html = "";
        html = '<div style="" class="item">'+
               '<div class="content">测试啊<i class="users icon"></i></div>'+
               '</div>'
        $("#message").append(html);
}

function addTable(){
      //第一种：动态创建表格的方式，使用拼接html的方式 （推荐）
            var html = "";
            for( var i = 0; i < 7; i++ ) {
                html += "<tr>";
                for(var j=i*12;j<8+i*12;j++){
                    var id="emoji"+j;
                    html +=  "<td><img onclick='chooseEmoji("+id+")' style='cursor: pointer;' id='"+id+"' src='img/"+j+".png' /></td>"
                }
                html += "</tr>";
            }
          return html;
}

$(function(){
    var popupLoading = '<table id="emojiTable" class="emoji"></table>';
    $('.shower').popup({
        hoverable  : true,
        exclusive: true,
        delay: {
            show: 400,
            hide: 400
        },
        html: popupLoading,
        variation: 'wide',
        onShow: function (el) {
            var popup = this;
            popup.html(popupLoading);
            popup.html(addTable());
        }
    });

    $("#send").click(function(){
        console.log("输入框内容",  $("#sendText") )
        addMyselfMessage()
    })
})
