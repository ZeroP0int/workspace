
                        function check(){
                        	if(checkName()&&checkPwd()){
                        		return true;
                        	}
                        	return false;
                        }
                        function checkName(){
                        	var name=document.getElementById("username").value;
                        	if(name.length==0){
                        		alert("用户不能为空");
                        		return false;
                        		}      
                        	return true;
                        	}
                        function checkPwd(){
                        
                        	var password=document.getElementById("password").value;
                        	var passwordRepeat=document.getElementById("passwordRepeat").value;
                        	if(password.length==0){
                        		alert("密码不能为空");
                        		return false;
                        	}
                        	if(passwordRepeat.length==0){
                        		alert("确认密码不能为空");
                        		return false;
                        	}
                        	if(passwordRepeat!=password){
                        		alert("两次密码不一致");
                        		return false;
                        	}
                        	return true;
                        }
                        function checkExistName(){                      	  
                      	  var name=$("#username").val();
                      	  $.ajax({
                      		  type:"post",
                      		  url:"CheckNameServlet",
                      		  data:"username="+name,
                      		  success:function(msg){
                      			 $("#usernameMsg").html(msg);//改变标签内容
                      			 if(msg=="该账户已存在"){
                      				 $("#username").val("");
                      			 }
                      		  }
                      	  })
                        }
                          
                        
                     
