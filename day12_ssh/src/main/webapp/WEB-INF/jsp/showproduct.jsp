<%@ page import="com.qfedu.ssh.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/7
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品展示</title>
    <%
        User user=(User)session.getAttribute("user");
        if(user==null){
            System.out.println("showproduct.jsp:"+user);
            request.getRequestDispatcher("/user/login").forward(request,response);
            return ;
        }
        String icon=user.getIcon();
        if(icon==null||"".equals(icon)){
            icon="../images/icon.png";
        }

    %>
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
                    var headHtml="<tr><td>商品编号</td><td>商品名称 </td><td>商品库存</td><td>商品类型</td><td>商品价格</td><td colspan=\"3\">操作</td></tr>";
                    //往里面拼接数据
                    var innerhtml="";
                    var jsonArray=jsonObject.products;
                    if(jsonArray.length>0){
                        for(var i=0;i<jsonArray.length;i++){
                            var jsonObjectProduct=jsonArray[i];
                            innerhtml=innerhtml+"<tr><td>"
                                +jsonObjectProduct.id+"</td><td>"
                                +jsonObjectProduct.name+"</td><td>"
                                +jsonObjectProduct.pnum+"</td><td>"
                                +jsonObjectProduct.category+"</td><td>"
                                +jsonObjectProduct.price+"</td>" +
                                "<td><a href='#' onclick='return clickShow("+jsonObjectProduct.id+")'>查看</a></td>" +
                                "<td><a href='#' onclick='return clickEdit("+jsonObjectProduct.id+")'>编辑</a></td>" +
                                "<td><a href='#' onclick='return clickDelete("+jsonObjectProduct.id+")'>删除</a></td>"+
                                "</tr>";
                        }
                    }
                    //把这一页商品展示出来
                    tableProducts.innerHTML=headHtml+innerhtml;

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

            var url="../product/page";
            var category=document.getElementById("category").value;
            url=url+"?category="+category;
            url=url+"&pageno="+pageno;
            url=url+"&pagesize="+pageSize;
            xmlhttp.open("get",url);
            xmlhttp.send();

        }


        function clickShow(id){
            window.location.href="../product/showone?id="+id;
            return false;
        }

        function clickEdit(id){
            window.location.href="../product/showedit?id="+id;
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
            var url="../product/deleleone?id="+id;
            xmlhttp.open("get",url);
            xmlhttp.send();

            return false;
        }
    </script>
</head>
<body onload="onbuttonclick(1);">
<div style="position: absolute; right: 20px;"><img style="position:relative; top:4px;" width="20px" height="20px" id="icon" src="<%out.print(icon);%>"/><a href="../user/edituser">${user.username}</a></div>

<h1>商品展示</h1>
<input type="text" id="category" placeholder="输入类型"/><button onclick="onbuttonclick(1);">搜索</button>
<br>
<div>
    <table id="producttable">
        <tr>
            <td>
                商品编号
            </td>
            <td>
                商品名称
            </td>
            <td>
                商品库存
            </td>
            <td>
                商品类型
            </td>
            <td>
                商品价格
            </td>
            <td colspan="3">
                操作
            </td>
        </tr>
    </table>

    <%--显示按钮，包括上一页、下一页、第n页--%>
    <div id="pagenos">


    </div>
</div>
</body>
</html>
