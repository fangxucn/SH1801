<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script type="text/javascript" src="../js/my.js" ></script>
    <script>
        function addProduct(){
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
                        window.location.href="showproduct";
                    }
                }
            };
            var url="../product/add";
            url=url+"?name="+name;
            url=url+"&pnum="+pnum;
            url=url+"&price="+price;
            url=url+"&category="+category;
            url=url+"&description="+description;
            xmlhttp.open("get",url);
            xmlhttp.send();

        }



    </script>
</head>
<body>
<h1>添加商品</h1>
商品名称：<input id="name" value=""/><br>
商品库存：<input id="pnum" value=""/><br>
商品价格：<input id="price" value=""/><br>
商品类型：<input id="category" value=""/><br>
商品描述：<input id="description" value=""/><br>
<button onclick="addProduct();">添加</button>
</body>
</html>