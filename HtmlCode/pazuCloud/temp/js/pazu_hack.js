/*
PAZU注入本js，用于深度处理打印数据
*/
window.onbeforepazuprint = function (oX, callback) {
  //alert(JSON.stringify(oX.json)) 
  var o = oX.json;//oX.xml xml的文档字符串
   
  var e = document.createElement("div");
  e.id = "div_PrintData";//id可以自己取，这里只是为了和pazu_hack.css对应
  e.innerHTML = "<span style=\"font-size:40px\">PAZU超级好用</span><br/><br/>" + "<p>Key : " + o.key + "</p>" + "<p>Text : " + o.content + "</p>" + "<p>JSON object : " + JSON.stringify(o) + "</p>";
  e.style.cssText = "border:1px solid red;width:500px;height:220px;padding:10px";
  document.body.appendChild(e);

  if (o.isH5Test) {
      //H5 canvas画图测试,需要打印服务器安装IE9+  id="myCanvas" width="600" height="200" style="border:solid 1px #333;margin:100px auto;">
      try{
          var e = document.createElement("canvas");
          e.id = "myCanvas";
          e.innerHTML = "<span style=\"font-size:40px\">PAZU超级好用</span><br/><br/>" + "<p>Key : " + o.key + "</p>" + "<p>Text : " + o.content + "</p>" + "<p>JSON object : " + JSON.stringify(o) + "</p>";
          e.style.cssText = "border:solid 1px #333;margin:10px auto;width:100%;height:200px";
          document.body.appendChild(e);

          var ctx = e.getContext("2d");

          ctx.beginPath();
          //圆形
          ctx.arc(95, 100, 40, 0, 2 * Math.PI);
          //三角形
          ctx.moveTo(200, 140);
          ctx.lineTo(300, 140);
          ctx.lineTo(250, 60);
          ctx.closePath();
          //正方形
          ctx.strokeRect(200, 20, 40, 40)
          ctx.stroke();
      }catch(ex){
          //不支持 html5
          var e = document.createElement("div");
          e.innerHTML = "打印服务器端不支持Html5，需要安装IE9+";
          document.body.appendChild(e);
      }
  }
  callback();//必须调用callback来执行真正的打印，当然如果你自己调用pazu对象（注意：不是大写的PAZU,小写pazu代表真正的打印插件控件）进行更深入控制时，可以按自己需要决定是否调用。

};