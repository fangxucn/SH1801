<%@ page import="com.qfedu.ssm.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/17 0017
  Time: 下午 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>一年级算术题测验</title>
    <script type="text/javascript" src="../js/my.js" ></script>
<%

    Student student = (Student) session.getAttribute("student");
    if(student==null){
        request.getRequestDispatcher("/student/login").forward(request,response);
        return ;
    }
%>
<script>
    function onbuttonclick(){


        var xmlhttp=getXMLHttpRequest();


        xmlhttp.onreadystatechange=function(){
            if(xmlhttp.readyState==4&&xmlhttp.status==200){

                 jsonStr=xmlhttp.responseText;

                var jsonObject=JSON.parse(jsonStr);

                //显示这一页数据
                var tableProducts=document.getElementById("questiontable");
                //往里面拼接数据
                var innerhtml="";
                if(jsonObject.length>0){
                    for(var i=0;i<jsonObject.length;i++){
                        var jsonObjectQuestion=jsonObject[i];
                        innerhtml=innerhtml+"<tr><td >"
                            +jsonObjectQuestion.subject+"</td><td><input type='text' id="+(i+1)+">"
                           "</td>" +
                            "</tr>";
                    }
                }
                //把这一页商品展示出来
                tableProducts.innerHTML=innerhtml;

            }

        };

        var url="../question/page";
        xmlhttp.open("post",url);
        xmlhttp.send();

    }
</script>

<script>
    function onhandover(){
        if (confirm("确定交卷吗")) {

            var xmlhttp=getXMLHttpRequest();


            xmlhttp.onreadystatechange=function(){
                if(xmlhttp.readyState==4&&xmlhttp.status==200){

                    var result=xmlhttp.responseText;


                    if(result=="success"){
                        window.location.href="../question/handover"
                    }

                }

            };



            var jsonObject=JSON.parse(jsonStr);

            if(jsonObject.length>0){
                for(var i=0;i<jsonObject.length;i++){
                    var jsonObjectQuestion=jsonObject[i];
                    var answer = document.getElementById(i+1).value;
                    jsonObjectQuestion.subject=jsonObjectQuestion.subject+answer;
                }
            }
            var json = JSON.stringify(jsonObject);
            json=escape(json);
            var url="../student/preserve";
            url=url+"?json="+json;
            url=url+"&stuid="+<%=student.getId()%>;
            // xmlhttp.open("post","../student/preserve");
            // xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            xmlhttp.open("get",url);
            xmlhttp.send();
        }
    }

</script>

</head>
<body onload="onbuttonclick()" >

<h1>一年级算术题测验</h1>
<br>
<div>
    <table id="questiontable">
        <tr>
        </tr>
    </table>

</div>
<button onclick="onhandover()">交卷</button>
</body>
</html>

