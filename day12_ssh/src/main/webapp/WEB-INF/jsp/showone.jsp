<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/8
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>商品详情</h1>
<%--    ${product.id}<br>
    ${product.name}<br>
    ${product.pnum}<br>
    ${product.price}<br>
    ${product.category}<br>
    ${product.description}<br>--%>


<script type="text/javascript" src="../js/my.js" ></script>
<script>
    //window.localStorage
    //cookie
    //jQuery  urlparam取
    //EL表达式
    var id=${id};
    function show(){
        //1、拿到五个数据  done
        //2、发送给服务器 done
        //3、接收返回值
        //4、跳转页面
        var xmlhttp=getXMLHttpRequest();
        xmlhttp.onreadystatechange=function(){
            if(xmlhttp.readyState==4&&xmlhttp.status==200){
                var result=xmlhttp.responseText;
                var jsonObject=JSON.parse(result);
                var info=document.getElementById("info");
                info.innerHTML=info.innerHTML+jsonObject.id+"<br>";
                info.innerHTML=info.innerHTML+jsonObject.name+"<br>";
                info.innerHTML=info.innerHTML+jsonObject.pnum+"<br>";
                info.innerHTML=info.innerHTML+jsonObject.price+"<br>";
                info.innerHTML=info.innerHTML+jsonObject.category+"<br>";
                info.innerHTML=info.innerHTML+jsonObject.description+"<br>";
            }
        };
        //                    getproductinfobyid
        var url="../product/getproductinfobyid?id="+id;

        xmlhttp.open("get",url);
        xmlhttp.send();

    }



</script>
<div id="info">


</div>
</body>
</html>
<script>
    show();
</script>