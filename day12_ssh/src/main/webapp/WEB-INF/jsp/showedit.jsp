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
<h1>商品修改</h1>
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


                document.getElementById("name").value=jsonObject.name;
                document.getElementById("pnum").value=jsonObject.pnum;
                document.getElementById("price").value=jsonObject.price;
                document.getElementById("category").value=jsonObject.category;
                document.getElementById("description").value=jsonObject.description;
            }
        };
        //                    getproductinfobyid
        var url="../product/getproductinfobyid?id="+id;
        xmlhttp.open("get",url);
        xmlhttp.send();

    }

    function editProduct(){
        //1、拿到五个数据  done
        //2、发送给服务器 done
        //3、接收返回值
        //4、跳转页面
        var name=document.getElementById("name").value;
        var pnum=document.getElementById("pnum").value;
        var price=document.getElementById("price").value;
        var category=document.getElementById("category").value;
        var description=document.getElementById("description").value;

        var xmlhttp=getXMLHttpRequest();
        xmlhttp.onreadystatechange=function(){
            if(xmlhttp.readyState==4&&xmlhttp.status==200){
                var result=xmlhttp.responseText;
                var jsonObject=JSON.parse(result);
                var state=jsonObject.state;
                if(state=="success"){
                    window.location.href="../product/showproduct";
                }
            }
        };
        var url="../product/edit";
        url=url+"?id="+id;
        url=url+"&name="+name;
        url=url+"&pnum="+pnum;
        url=url+"&price="+price;
        url=url+"&category="+category;
        url=url+"&description="+description;
        xmlhttp.open("get",url);
        xmlhttp.send();
    }


</script>
<div id="info">
    商品名称：<input id="name" value=""/><br>
    商品库存：<input id="pnum" value=""/><br>
    商品价格：<input id="price" value=""/><br>
    商品类型：<input id="category" value=""/><br>
    商品描述：<input id="description" value=""/><br>
    <button onclick="editProduct();">修改</button>

</div>
</body>
</html>
<script>
    show();
</script>