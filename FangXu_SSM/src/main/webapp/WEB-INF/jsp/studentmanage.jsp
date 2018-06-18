<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试管理</title>
    <%--<%--%>
    <%--User user=(User)session.getAttribute("user");--%>
    <%--if(user==null){--%>
    <%--System.out.println("showproduct.jsp:"+user);--%>
    <%--request.getRequestDispatcher("/user/login").forward(request,response);--%>
    <%--return ;--%>
    <%--}--%>
    <%--String icon=user.getIcon();--%>
    <%--if(icon==null||"".equals(icon)){--%>
    <%--icon="../images/icon.png";--%>
    <%--}--%>

    <%--%>--%>
    <script type="text/javascript" src="../js/my.js" ></script>
    <script>




    </script>
    <script>

        var pageNo=0;
        var pageSum=0;
        var pageSize=5;
        function gopage(n){
            if(pageNo+n>0&&pageNo+n<=pageSum){
                pageNo=pageNo+n;
                onbuttonclick(pageNo);
            }
        }

        function onbuttonclick(pageno){

            //请求服务器json数据
            //解析json显示到网页上
            //在网页上显示出适当的按钮
            var xmlhttp=getXMLHttpRequest();


            xmlhttp.onreadystatechange=function(){
                if(xmlhttp.readyState==4&&xmlhttp.status==200){

                    var jsonStr=xmlhttp.responseText;

                    var jsonObject=JSON.parse(jsonStr);
                    //获取总页数和当前页号
                    pageNo=jsonObject.pageNo;
                    pageSum=jsonObject.pageCount;

                    //显示这一页数据
                    var tableProducts=document.getElementById("producttable");
                    //往里面拼接数据
                    var innerhtml="";
                    var jsonArray=jsonObject.items;
                    if(jsonArray.length>0){
                        for(var i=0;i<jsonArray.length;i++){
                            var jsonObjectStudent=jsonArray[i];
                            innerhtml=innerhtml+"<tr><td>"
                                +jsonObjectStudent.name+"</td><td>"
                                +jsonObjectStudent.score+"</td>"+
                                // "<td><a href='#' onclick='return clickEdit("+jsonObjectQuestion.id+jsonObjectQuestion.subject+jsonObjectQuestion.answer+")'>编辑</a></td>" +
                                "<td><a href='#' onclick='return clickShow("+jsonObjectStudent.id+")'>查看</a></td>" +
                                "<td><a href='#' onclick='return clickDelete("+jsonObjectStudent.id+")'>删除</a></td>"+
                                "</tr>";
                        }
                    }
                    //把这一页商品展示出来
                    tableProducts.innerHTML=innerhtml;

                    //在网页上显示出适当的按钮
                    var divpagenos=document.getElementById("pagenos");
                    var html1="<button onclick='gopage(-1)'>上一页</button>";
                    var html2="";
                    for(var i=0;i<pageSum;i++){
                        html2=html2+"<button onclick='onbuttonclick("+(i+1)+")'>"+(i+1)+"</button>";
                    }
                    var htmllast="<button onclick='gopage(1)'>下一页</button>";
                    divpagenos.innerHTML=html1+html2+htmllast;
                }

            };

            var url="../student/showStudentPage";
            url=url+"?pageno="+pageno;
            url=url+"&pagesize="+pageSize;
            xmlhttp.open("get",url);
            xmlhttp.send();

        }

        function clickShow(id){
            window.location.href="../student/showone?id="+id;
            return false;
        }

        function clickEdit(id){
            // window.location.href="../question/showedit?id="+id+"&subject="+subject+"&answer="+answer;
            window.location.href="../question/showedit?id="+id;
            return false;
        }

        function clickDelete(id){
            var xmlhttp=getXMLHttpRequest();


            xmlhttp.onreadystatechange=function() {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var result=xmlhttp.responseText;
                    var jsonObject=JSON.parse(result);
                    if(jsonObject.state=="success"){
                        onbuttonclick(pageNo);
                    }

                }
            }
            var url="../student/deleleone?id="+id;
            xmlhttp.open("get",url);
            xmlhttp.send();

            return false;
        }

        function addQuestion() {
            window.location.href="../question/showadd";
        }

    </script>
</head>
<body onload="onbuttonclick(1);">

测试管理：
<br>
<div>
    <table id="producttable">

    </table>

    <%--显示按钮，包括上一页、下一页、第n页--%>
    <div id="pagenos">


    </div>
</div>
</body>
</html>
