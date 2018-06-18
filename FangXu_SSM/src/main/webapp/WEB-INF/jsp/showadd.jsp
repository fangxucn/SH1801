<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <title>添加试题</title>
    <script type="text/javascript" src="../js/my.js" ></script>
    <script>


        function addQuestion(){
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
            alert(name);
            var url="../question/addquestion";
            url=url+"?name="+name;
            url=url+"&pnum="+pnum;
            xmlhttp.open("get",url);
            xmlhttp.send();
        }
        function onCancel() {
            window.location.href = "../question/questionmanage";
        }

    </script>

    <div id="info">
        <h5>添加试题</h5>
        试题：<input id="name" value=""/>
        答案：<input id="pnum" value=""/>
        <button onclick="addQuestion();">添加</button><button onclick="onCancel();">取消</button>

    </div>
    </body>
</html>
