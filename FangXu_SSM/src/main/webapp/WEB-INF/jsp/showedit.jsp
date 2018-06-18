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

        var xmlhttp=getXMLHttpRequest();
        xmlhttp.onreadystatechange=function(){
            if(xmlhttp.readyState==4&&xmlhttp.status==200){
                var result=xmlhttp.responseText;
                var jsonObject=JSON.parse(result);
                var state=jsonObject.state;
                if(state=="success"){
                    window.location.href="../question/questionmanage";
                }
            }
        };
        var url="../question/edit";
        url=url+"?id="+id;
        url=url+"&name="+name;
        url=url+"&pnum="+pnum;
        xmlhttp.open("get",url);
        xmlhttp.send();
    }


</script>
<div id="info">
    <h5>试题编辑</h5>
    试题：<input id="name" value=""/>
    答案：<input id="pnum" value=""/>
    <button onclick="editProduct();">确定</button><button>取消</button>

</div>
</body>
</html>
<script>
    // show();
</script>