<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员注册</title>
    <script type="text/javascript" src="../js/my.js"></script>
    <script type="text/javascript" src="../js/pattern.js" ></script>
    <script>
        var tempusername=false;
        function onusernamechanged(){
            var name=document.getElementById("name");
            var fontusername=document.getElementById("fontusername");
            if(uPattern.test(name.value)){
                //用户名格式正确
                fontusername.color="green";
                fontusername.innerHTML="用户名可用";
                //在正确的前提下，应该去判断是不是数据库里有这个用户名
                //进而提供给用户到底用户名可不可用。（此部分属于后端验证）
                //开始后端验证
                var xmlhttp=getXMLHttpRequest();
                xmlhttp.onreadystatechange=function(){
                    if(xmlhttp.readyState==4&&xmlhttp.status==200) {
                        var result = xmlhttp.responseText;
                        if(result=="true"){
                            tempusername=false;
                            fontusername.color="red";
                            fontusername.innerHTML="用户名已经存在";

                            //这里很容易有误区
                            //认为就像前端校验一样，返回一个真假值不就可以了么
                            //为啥一定用tempusername来接收信息？
                            //return false;
                        }else{
                            tempusername=true;
                            fontusername.color="green";
                            fontusername.innerHTML="用户名可用";
                        }

                    }
                };
                xmlhttp.open("get","findname?name="+name.value);
                xmlhttp.send();

                return true;
            }else{
                //用户名格式不正确
                fontusername.color="red";
                fontusername.innerHTML="用户名格式不正确";
                return false;
            }

        }


        function onpasswordchanged(){
            var password=document.getElementById("password");
            var fontpassword=document.getElementById("fontpassword");
            if(pPattern.test(password.value)){
                //用户名格式正确
                fontpassword.color="green";
                fontpassword.innerHTML="密码格式正确";
                //在正确的前提下，应该去判断是不是数据库里有这个用户名
                //进而提供给用户到底用户名可不可用。（此部分属于后端验证）
                return true;
            }else{
                //用户名格式不正确
                fontpassword.color="red";
                fontpassword.innerHTML="密码格式不正确";
                return false;
            }
        }
        function onrepasswordchanged(){
            var repassword=document.getElementById("repassword");
            var password=document.getElementById("password");
            var fontrepassword=document.getElementById("fontrepassword");
            if(password.value==repassword.value){
                //用户名格式正确
                fontrepassword.color="green";
                fontrepassword.innerHTML="密码两次输入一致";
                //在正确的前提下，应该去判断是不是数据库里有这个用户名
                //进而提供给用户到底用户名可不可用。（此部分属于后端验证）
                return true;
            }else{
                //用户名格式不正确
                fontrepassword.color="red";
                fontrepassword.innerHTML="密码两次输入不一致";
                return false;
            }
        }

        function onSubmitClick(){
            //前端校验的方法
            var bool=onusernamechanged()&&onpasswordchanged()
                &&onrepasswordchanged();



            //后端校验的值
            bool=bool&&tempusername;

            return bool;
        }


    </script>
</head>

<body>
<form action="dotreg" method="post">
    <table>
        <tr>
            <td>用户名</td>

            <td><input id="name" name="name" onchange="onusernamechanged();"/></td>
            <td><font id="fontusername"></font></td>
        </tr>
        <tr>
            <td>密码</td>

            <td><input id="password" name="password" type="text" onchange="onpasswordchanged();"/></td>
            <td><font id="fontpassword"></font></td>
        </tr>
        <tr>
            <td>密码重复</td>

            <td><input id="repassword" name="repassword" type="text" onchange="onrepasswordchanged();"/></td>
            <td><font id="fontrepassword"></font></td>
        </tr>
        <%--<tr>--%>
            <%--<td>性别</td>--%>
            <%--<td>--%>
                <%--<input  type="radio" name="gender" value="男" checked="checked"/>男--%>
                <%--<input  type="radio" name="gender" value="女" />女--%>
            <%--</td>--%>
            <%--<td><font></font></td>--%>
        <%--</tr>--%>




        <tr>
            <td colspan="2" align="center">
                <button onclick="return onSubmitClick();">注册</button>
            </td>
            <td><font id="fontsubmit"></font></td>
        </tr>
    </table>





</form>


</body>
</html>