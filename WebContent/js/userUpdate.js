/**
 * 
 */
//验证确认密码
 function validateUpdatepass() {
 	var newuserpwd = document.getElementById("newuserpwd").value;
 	var reuserpwd = document.getElementById("reuserpwd").value;
 	if (newuserpwd.length < 5 || newuserpwd.length > 16) {
		window.alert("密码长度必须在5~16之间！");
		form.newuserpwd.focus();
		return false;
	} else if (newuserpwd!= reuserpwd) {
 		window.alert("您输入的密码与确认密码不一致!");
 		form.reuserpwd.focus();
 		return false;
 	} else{
 		return true;
 	}
 }
 
 function checkAll() {
		if (validateUpdatepass()) {
//			alert("ok");
			return true;
		} else {
//			alert("error");
			return false;
		}
	}
 