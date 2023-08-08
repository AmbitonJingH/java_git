function $(id){
    return document.getElementById(id);
}

function preRegist(){
    var unameTxt = $("unameTxt");
    //用户名不能为空 且用户名应为6~16位数组和字母组成
    var unameReg = /[0-9a-zA-Z]{6,16}/gim
    var uname = unameTxt.value;
    var unameSpan = $("unameSpan");
    if(!unameReg.test(uname)){
        unameSpan.style.visibility = "visible";
        return false;
    }else {
        unameSpan.style.visibility = "hidden";
    }

    var pwdTxt = $("pwdTxt");
    var pwd = pwdTxt.value;
    var pwdReg = /[\w]{8,}/;
    var pwdSpan = $("pwdSpan");
    if(!pwdReg.test(pwd)){
        pwdSpan.style.visibility = "visible";
        return false;
    }else {
        pwdSpan.style.visibility = "hidden";
    }
//两次密码输入不一致
    if($("pwdTxt").value!=$("pwdTxt2").value){
        $("pwdSpan2").style.visibility = "visible";
        return false;
    }else {
        $("pwdSpan2").style.visibility = "hidden";
    }
//输入正确邮箱
    var email = $("emailTxt").value;
    var emailSpan = $("emailSpan");
    var emailReg = /^(\w+([-.][A-Za-z0-9]+)*){3,18}@\w+([-.][A-Za-z0-9]+)*\.\w+([-.][A-Za-z0-9]+)*$/
    if(!emailReg.test(email)){
        emailSpan.style.visibility = "visible";
        return false;
    }else {
        emailSpan.style.visibility = "hidden";
    }

    return true;
}
var xmlHttpRequest;
function createXmlHttpRequest(){
    if(window.XMLHttpRequest){
        //符合DOM2标准的浏览器
        xmlHttpRequest = new XMLHttpRequest();
    }else if(window.ActiveXObject){
        //IE浏览器
        try {
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP")
        }
    }
}

function ckUnameCB(){
    if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
        var responseText = xmlHttpRequest.responseText;
        if(responseText=="{'uname':'1'}"){
            alert("用户名已存在！")
        }
    }
}
function ckUname(uname){
    createXmlHttpRequest();
    var url = "user.do?operate=ckUname&uname="+uname;
    xmlHttpRequest.open("GET",url,true);
    //设置回调函数
    xmlHttpRequest.onreadystatechange = ckUnameCB;
    xmlHttpRequest.send();

}