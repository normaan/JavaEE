/**
 * 公共js
 */

// 项目路径
var path = "http://127.0.0.1:8080/ljr/";

// 将修改的用户信息保存至浏览器缓存
/*var userLogin;

$(function(){
	userLogin = sessionStorage.getItem("userLogin");

	// 将json转换为json对象
	userLogin = JSON.parse(userLogin);
})*/




//URL传参公用方法
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) {
		return unescape(r[2]);
	} else {
		return null;
	}
}