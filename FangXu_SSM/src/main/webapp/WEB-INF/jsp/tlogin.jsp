<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <script type="text/javascript" src="../js/my.js"></script>
    <script>
        function onSubmitClick(){
            var formInfo=document.getElementById("form");
            var xmlhttp=getXMLHttpRequest();

            xmlhttp.onreadystatechange=function(){
                if(xmlhttp.readyState==4&&xmlhttp.status==200){
                    var result=xmlhttp.responseText;
                    if(result=="success"){
                        document.getElementById("info").color="green";
                        document.getElementById("info").innerHTML="登录成功";
                        window.location.href="../teacher/homepage";
                    }else{
                        document.getElementById("info").color="red";
                        document.getElementById("info").innerHTML="登录信息有误";
                    }
                }
            };
            xmlhttp.open("post","../teacher/dotlogin");
            xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            var name=document.getElementById("name").value;
            var password=document.getElementById("password").value;
            xmlhttp.send("tname="+name+"&password="+password);

            return false;
        }


    </script>
</head>
<body>
<center>
    <h1>欢迎登录</h1>
    <div>
        <form id="form" action="#" method="post" >
            <input id="name" name="name" placeholder="用户名" value="lilaoshi"/><br>
            <input id="password" type="password" placeholder="密码" name="password" value="666666Aa@"/><br>
            <font id="info">&nbsp;</font><br>
            <input type="submit" value="登录" onclick="return onSubmitClick();"/>
        </form>



    </div>

</center>
</body>
</html>