$(document).ready(function () {


    $(".last_page").click(function () {


        if($("#pageNo").val()<$(".pageNumber:last").text()){

            $("#pageNo").val(parseInt($("#pageNo").val())+1);

        }

        $.ajax({
            "url" :"/productListPage",
            "type":"get",
            "data": "pageNo="+$("#pageNo").val(),
            "dataType":"json",
            "success":function (data) {
                alert("成功！");

                var li = "";
                for (var i = 0;i<data.length;i++){

                    li+="<li>\n" +
                        "                            <div class=\"img\"><a href=\"#\"><img src=\" /statics/images/per_1.jpg\" width=\"210\" height=\"185\" /></a></div>\n" +
                        "                            <div class=\"price\">\n" +
                        "                                <font>￥<span>"+data[i].price+"</span></font> &nbsp; 26R\n" +
                        "                            </div>\n" +
                        "                            <div class=\"name\"><a href=\"#\">" +data[i].name+"</a></div>\n" +
                        "                            <div class=\"carbg\">\n" +
                        "                                <a href=\"#\" class=\"ss\">收藏</a>\n" +
                        "                                <a href=\"#\" class=\"j_car\">加入购物车</a>\n" +
                        "                            </div>\n" +
                        "                        </li>"



                }



                $(".cate_list").html(li)

            },
            "error" : function () {
                alert("获取失败！");
            }
        });


    })


    $(".top_page").click(function () {


        if($("#pageNo").val()>1){

            $("#pageNo").val($("#pageNo").val()-1);

        }

        $(".pageNumber[class='cur']").removeClass("cur").siblings().addClass("cur");

        // var naber = parseInt($("#pageNo").val()-1);
        // $(".pageNumber").removeClass("cur");
        // // $(".pageNumber:eq()").addClass("cur");
        // alert(naber);


        $.ajax({
            "url" :"/productListPage",
            "type":"get",
            "data": "pageNo="+$("#pageNo").val(),
            "dataType":"json",
            "success":function (data) {


               var li = "";
               for (var i = 0;i<data.length;i++){

                   li+="<li>\n" +
                       "                            <div class=\"img\"><a href=\"#\"><img src=\" /statics/images/per_1.jpg\" width=\"210\" height=\"185\" /></a></div>\n" +
                       "                            <div class=\"price\">\n" +
                       "                                <font>￥<span>"+data[i].price+"</span></font> &nbsp; 26R\n" +
                       "                            </div>\n" +
                       "                            <div class=\"name\"><a href=\"#\">" +data[i].name+"</a></div>\n" +
                       "                            <div class=\"carbg\">\n" +
                       "                                <a href=\"#\" class=\"ss\">收藏</a>\n" +
                       "                                <a href=\"#\" class=\"j_car\">加入购物车</a>\n" +
                       "                            </div>\n" +
                       "                        </li>"



               }



                $(".cate_list").html(li)

            },
            "error" : function () {
                alert("获取失败！");
            }
        });


    })


$(".pageNumber").click(function () {


     $(".pageNumber").removeClass("cur");
        $(this).addClass("cur");


    $("#pageNo").val(this.text);
    $.ajax({
        "url" :"/productListPage",
        "type":"get",
        "data": "pageNo="+$("#pageNo").val(),
        "dataType":"json",
        "success":function (data) {
            alert("成功！");

            var li = "";
            for (var i = 0;i<data.length;i++){

                li+="<li>\n" +
                    "                            <div class=\"img\"><a href=\"#\"><img src=\" /statics/images/per_1.jpg\" width=\"210\" height=\"185\" /></a></div>\n" +
                    "                            <div class=\"price\">\n" +
                    "                                <font>￥<span>"+data[i].price+"</span></font> &nbsp; 26R\n" +
                    "                            </div>\n" +
                    "                            <div class=\"name\"><a href=\"#\">" +data[i].name+"</a></div>\n" +
                    "                            <div class=\"carbg\">\n" +
                    "                                <a href=\"#\" class=\"ss\">收藏</a>\n" +
                    "                                <a href=\"#\" class=\"j_car\">加入购物车</a>\n" +
                    "                            </div>\n" +
                    "                        </li>"



            }



            $(".cate_list").html(li)

        },
        "error" : function () {
            alert("获取失败！");
        }
    });


})


    $(".categoryCondition").click(function () {

        $(".categoryCond").val($(this).next().val());



        var data = '{"category":'+$(this).next().val()+'}';
        $.ajax({

            "url" :"/getProducts",
            "type":"post",
            "contentType":"application/json;charset=UTF-8",
            "data": data,
            "dataType":"json",
            "success":function (data) {
                alert("成功！");
                alert(data.length);
                var li = "";
                for (var i = 0;i<data.length;i++){

                    li+="<li>\n" +
                        "                            <div class=\"img\"><a href=\"#\"><img src=\" /statics/images/per_1.jpg\" width=\"210\" height=\"185\" /></a></div>\n" +
                        "                            <div class=\"price\">\n" +
                        "                                <font>￥<span>"+data[i].price+"</span></font> &nbsp; 26R\n" +
                        "                            </div>\n" +
                        "                            <div class=\"name\"><a href=\"#\">" +data[i].name+"</a></div>\n" +
                        "                            <div class=\"carbg\">\n" +
                        "                                <a href=\"#\" class=\"ss\">收藏</a>\n" +
                        "                                <a href=\"#\" class=\"j_car\">加入购物车</a>\n" +
                        "                            </div>\n" +
                        "                        </li>"



                }



                $(".cate_list").html(li)

            },
            "error":function () {
                alert("获取失败！")
            }








        })






    })


    $(".priceCondition").click(function () {
        var arry = $(this).text().split("-");
        $(".priceCondLow").val(arry[0].replace(/[^0-9]/ig,""));
        if(arry[1]==null){
            $(".priceCondTall").val(null)

        }else {
            $(".priceCondTall").val(arry[1].replace(/[^0-9]/ig, ""));
        }
          alert(arry[0].replace(/[^0-9]/ig,""));

          // var data = '{"category":'+$(this).next().val()+',"priceLow":'+$(".priceCondLow").val()+',"priceTall":'+$(".priceCondTall").val()+'}';
          var data = {"category":$(".categoryCond").val(),"priceLow":$(".priceCondLow").val(),"priceTall":$(".priceCondTall").val()};

            alert(JSON.stringify(data));
        // $.getJSON("/getProducts",JSON.stringify(data),function (data) {
        //     alert("成功！");
        //     alert(data.length);
        //     var li = "";
        //     for (var i = 0;i<data.length;i++){
        //
        //         li+="<li>\n" +
        //             "                            <div class=\"img\"><a href=\"#\"><img src=\" /statics/images/per_1.jpg\" width=\"210\" height=\"185\" /></a></div>\n" +
        //             "                            <div class=\"price\">\n" +
        //             "                                <font>￥<span>"+data[i].price+"</span></font> &nbsp; 26R\n" +
        //             "                            </div>\n" +
        //             "                            <div class=\"name\"><a href=\"#\">" +data[i].name+"</a></div>\n" +
        //             "                            <div class=\"carbg\">\n" +
        //             "                                <a href=\"#\" class=\"ss\">收藏</a>\n" +
        //             "                                <a href=\"#\" class=\"j_car\">加入购物车</a>\n" +
        //             "                            </div>\n" +
        //             "                        </li>"
        //
        //
        //
        //     }
        //
        //
        //
        //     $(".cate_list").html(li)
        //
        // })


        $.ajax({

            "url" :"/getProducts",
            "type":"post",
            "contentType":"application/json;charset=UTF-8",
            "data": JSON.stringify(data),
            "dataType":"json",
            "success":function (data) {
                alert("成功！");
                alert(data.length);
                var li = "";
                for (var i = 0;i<data.length;i++){

                    li+="<li>\n" +
                        "                            <div class=\"img\"><a href=\"#\"><img src=\" /statics/images/per_1.jpg\" width=\"210\" height=\"185\" /></a></div>\n" +
                        "                            <div class=\"price\">\n" +
                        "                                <font>￥<span>"+data[i].price+"</span></font> &nbsp; 26R\n" +
                        "                            </div>\n" +
                        "                            <div class=\"name\"><a href=\"#\">" +data[i].name+"</a></div>\n" +
                        "                            <div class=\"carbg\">\n" +
                        "                                <a href=\"#\" class=\"ss\">收藏</a>\n" +
                        "                                <a href=\"#\" class=\"j_car\">加入购物车</a>\n" +
                        "                            </div>\n" +
                        "                        </li>"



                }



                $(".cate_list").html(li)

            },
            "error":function () {
                alert("获取失败！")
            }








        })






    })



















    $(".demo").click(function () {

        alert("1111111")

        // $.get("/demo","name=黎明",function (data) {
        //              alert("成功!")
        //
        //              });
        $.ajax({
            "url":"/demo",
            "type":"get",
            "contentType":"application/json",
            "data":JSON.stringify({"name":"黎明"}),
            "dataType":"json",
            "success":function () {
                alert("成功!")
            },
            "error":function () {
                alert("失败!")
            }
        })
    })

    $(".j_car").click(function () {

        var id = $(this).next().val();
        $.get("/detail/add","id="+id,function (data) {

            if (data=="succeed") {
                alert("添加成功！")
            }else if(data == "failed"){

                alert("添加失败！")
            }else if(data == "login"){
                alert("请登录！")
            }else {

                alert("未知错误！")

            }

        });



    })



})