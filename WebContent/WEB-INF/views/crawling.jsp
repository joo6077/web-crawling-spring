<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%
	response.setHeader("Access-Control-Allow-Origin","*");
%> --%>
<!DOCTYPE html>
<html>
<head>
<style></style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="app">
		<div id="get_url" class="app_url app_url_input">
			<input type="text" id="url">
			<button id="iframe">url 가져오기</button>
		</div>
		<div id="url_page">
		</div>
	</div>
</body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script type="text/javascript">
		
	$(document).ready(function(){
		$("#iframe").click(function(){
			$.ajax({
				type: "post",
				data: "https://aroundlena.tistory.com/16",
				dataType: "text",
				contentType: "application/json",
				url: "${pageContext.request.contextPath}/send",
				success: function(data){
					$("#url_page").html(data);
					var iframe = document.createElement("iframe");
					var urlPage = document.getElementById("url_page");
					iframe.src = data;
					urlPage.appendChild(iframe);
					
					console.log(data.indexOf("</body"));
					
					$("#url_page").css('width', '200px');
					$("#url_page").css('height', '200px');
					$("#url_page").css('overflow', 'hidden');
				}
			})
			
		});	
		
		
			var all = $("*").click(function(e){
			e.stopPropagation();
			var domElement = $(this).get(0);
			
			var sumResult = "";
			
			console.log(sumResult);
			var i = 0;
			var parentSelectors = new Array();
			//노드 자기 자신 값
			sumResult = sumResult + domElement.nodeName.toLowerCase();
			
			if(domElement.hasAttribute("id")){
				sumResult = sumResult + "#" + domElement.id;
			}if(domElement.hasAttribute("class")){
				sumResult = sumResult + "." +domElement.className.split(" ").join(".");
			}
			parentSelectors.push(sumResult);
			
			//부모 노드 및 클래스들 값들 가져오기
			while(true){
				//태그 이름이 body이면 멈춤.
				if(domElement.nodeName === "BODY"){
					console.log("멈췄습니다!");
					break;
				}
				//문자열 초기화
				sumResult = "";
				
				//부모의 부모 ...
				domElement = domElement.parentNode;
				//노드 이름 대문자 -> 소문자
				sumResult = sumResult + domElement.nodeName.toLowerCase();
				
				//sumResult = sumResult + 아이디 및 클래스.
				if(domElement.hasAttribute("id")){
					sumResult = sumResult + "#" + domElement.id;
				}if(domElement.hasAttribute("class")){
					sumResult = sumResult + "." +domElement.className.split(" ").join(".");
				}
				parentSelectors.push(sumResult);
			}
			//배열 역순 저장
			var reParentSelectors = parentSelectors.reverse();
			console.log(reParentSelectors);
			
			$.ajax({
				type: "post",
				url: "${pageContext.request.contextPath}/transfer",
				dataType:"json",
				contentType: "application/json",
				data: JSON.stringify(reParentSelectors),
				success: function(res){
					console.log(res);	
				}
			}); 
			
		});
	});
	var vm = new Vue({
		el: '#app',
		data:{
			url: ""
		},
		methods:{
			getUrl(){
				var url = document.getElementById("url");
				this.url = url.value;
			},
			getInfo(){
				alert("안되?");
				
			}
		}
			
	});
</script>
</html>