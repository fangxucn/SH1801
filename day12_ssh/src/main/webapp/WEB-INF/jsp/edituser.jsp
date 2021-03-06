<%@ page import="com.qfedu.ssh.bean.User" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑用户</title>
    <script type="text/javascript" src="../js/my.js"></script>
    <script type="text/javascript" src="../js/pattern.js" ></script>
    <script>
        function getXMLHttpRequest(){
            var xmlhttp;
            if(window.XMLHttpRequest){
                xmlhttp=new XMLHttpRequest();
            }else{
                //IE6以前
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            return xmlhttp;
        }

        function onfileChanged(){
            //form,showphoto,photo
            if(document.getElementById("photo").value==""){
                //什么也没选，就什么也不做
                return ;
            }
            var fileForm=document.getElementById("file");

            //用ajax把图片上传到服务器
            var xmlhttp=getXMLHttpRequest();
            xmlhttp.onreadystatechange=function(){
                if(xmlhttp.readyState==4&&xmlhttp.status==200){
                    var imgPath=xmlhttp.responseText;
                    if("error"==imgPath){
                        imgPath="../images/error.png";
                    }
                    document.getElementById("icon").value=imgPath;
                    document.getElementById("showphoto").src=imgPath;
                }
            };
            xmlhttp.open("post",fileForm.action);
            xmlhttp.send(new FormData(fileForm));

        }

    </script>
    <script>
        var tempusername=false;
        function onusernamechanged(){
            var username=document.getElementById("username");
            var fontusername=document.getElementById("fontusername");
            if(uPattern.test(username.value)){
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
                xmlhttp.open("get","findusername?username="+username.value);
                xmlhttp.send();

                return true;
            }else{
                //用户名格式不正确
                fontusername.color="red";
                fontusername.innerHTML="用户名格式不正确";
                return false;
            }

        }
        var tempemail=false;
        function onemailchanged(){
            var email=document.getElementById("email");
            var fontemail=document.getElementById("fontemail");
            if(ePattern.test(email.value)){
                //用户名格式正确
                fontemail.color="green";
                fontemail.innerHTML="邮箱格式正确";
                //在正确的前提下，应该去判断是不是数据库里有这个用户名
                //进而提供给用户到底用户名可不可用。（此部分属于后端验证）
                var xmlhttp=getXMLHttpRequest();
                xmlhttp.onreadystatechange=function(){
                    if(xmlhttp.readyState==4&&xmlhttp.status==200) {
                        var result = xmlhttp.responseText;
                        if(result=="true"){
                            tempemail=false;
                            fontemail.color="red";
                            fontemail.innerHTML="邮箱已经存在";
                        }else{
                            tempemail=true;
                            fontemail.color="green";
                            fontemail.innerHTML="邮箱可用";
                        }

                    }
                };
                xmlhttp.open("get","findemail?email="+email.value);
                xmlhttp.send();
                return true;
            }else{
                //用户名格式不正确
                fontemail.color="red";
                fontemail.innerHTML="邮箱格式不正确";
                return false;
            }

        }
        var temptelephone=false;
        function ontelephonechanged(){
            var telephone=document.getElementById("telephone");
            var fonttelephone=document.getElementById("fonttelephone");
            if(mPattern.test(telephone.value)){
                //用户名格式正确
                fonttelephone.color="green";
                fonttelephone.innerHTML="手机号格式正确";
                //在正确的前提下，应该去判断是不是数据库里有这个用户名
                //进而提供给用户到底用户名可不可用。（此部分属于后端验证）
                var xmlhttp=getXMLHttpRequest();
                xmlhttp.onreadystatechange=function(){
                    if(xmlhttp.readyState==4&&xmlhttp.status==200) {
                        var result = xmlhttp.responseText;
                        if(result=="true"){
                            temptelephone=false;
                            fonttelephone.color="red";
                            fonttelephone.innerHTML="手机号已经存在";
                        }else{
                            temptelephone=true;
                            fonttelephone.color="green";
                            fonttelephone.innerHTML="手机号可用";
                        }

                    }
                };
                xmlhttp.open("get","findtelephone?telephone="+telephone.value);
                xmlhttp.send();
                return true;
            }else{
                //用户名格式不正确
                fonttelephone.color="red";
                fonttelephone.innerHTML="手机号格式不正确";
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
        var tempcheckcode=false;
        function oncheckcode(){
            var checkcode=document.getElementById("checkcode");
            var fontcheckcode=document.getElementById("fontcheckcode");
            if(checkcode.value.length==4){
                //请求服务器，问问这个数据对不对
                var xmlhttp=getXMLHttpRequest();
                xmlhttp.onreadystatechange=function(){
                    if(xmlhttp.readyState==4&&xmlhttp.status==200){
                        var textcode=xmlhttp.responseText;
                        if(textcode==checkcode.value){
                            tempcheckcode=true;
                            fontcheckcode.color="green";
                            fontcheckcode.innerHTML="验证码输入正确";
                        }else{
                            tempcheckcode=false;
                            fontcheckcode.color="red";
                            fontcheckcode.innerHTML="验证码输入错误";
                        }

                    }
                };
                xmlhttp.open("get","textcheckcode");
                xmlhttp.send();
            }else{
                tempcheckcode=false;
                fontcheckcode.color="red";
                fontcheckcode.innerHTML="验证码输入错误";
            }

        }
        function onSubmitClick(){
            //前端校验的方法
            var bool=onpasswordchanged()
                &&onrepasswordchanged();

            return bool;
        }


    </script>
</head>

<body>
<h1>编辑用户</h1>
<form action="doedit" method="post">
    <table>
        <tr>
            <td>用户名</td>

            <td><div>${user.username}</div></td>
            <td><font id="fontusername"></font></td>
        </tr>
        <tr>
            <td>邮箱</td>

            <td><div>${user.email}</div></td>
            <td><font id="fontemail"></font></td>
        </tr>
        <tr>
            <td>手机号</td>

            <td><div>${user.telephone}</div></td>
            <td><font id="fonttelephone"></font></td>
        </tr>
        <tr>
            <td>密码</td>

            <td><input id="password" name="password" type="password" onchange="onpasswordchanged();"/></td>
            <td><font id="fontpassword"></font></td>
        </tr>
        <tr>
            <td>密码重复</td>

            <td><input id="repassword" name="repassword" type="password" onchange="onrepasswordchanged();"/></td>
            <td><font id="fontrepassword"></font></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <%
                    String gender=((User)session.getAttribute("user")).getGender();

                %>
                <input  type="radio" name="gender" value="男" <%if("男".equals(gender)){out.print("checked='checked'");}%>/>男
                <input  type="radio" name="gender" value="女" <%if("女".equals(gender)){out.print("checked='checked'");}%>/>女
            </td>
            <td><font></font></td>
        </tr>
        <tr>
            <td colspan="3">
                <input name="icon" type="hidden" id="icon" value="" />
            </td>

        </tr>
        <tr>
            <td colspan="2" align="center">
                <button onclick="return onSubmitClick();">提交</button>
            </td>
            <td><font id="fontsubmit"></font></td>
        </tr>
    </table>

</form>
<div  style="position: absolute;top: 130px;right: 50px;">
    <form id="file" action="fileupload" method="post" enctype="multipart/form-data">


        <img id="showphoto" width="100px" height="100px" src="../images/moren.png"/>
        <br>
        <input type="file" id="photo" name="icon" onchange="onfileChanged();"/>


    </form>
</div>





</body>
</html>