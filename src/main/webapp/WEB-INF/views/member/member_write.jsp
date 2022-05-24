<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join JSP</title>
<style type="text/css">
</style>

</head>
<body>
	<h3>회원가입</h3>
	<p class="w-pct60 right"
		style="margin: 0 auto; padding-bottom: 5px; font-size: 13px;">*는
		필수 입력 항목입니다.</p>
	<form name="form1" method="post" action="./insert.do">
		<table class="w-pct60">
			<tr>
				<th><label for="username">이&emsp;름</label></th>
				<td><input id="username" type="text" name="u_name"
					placeholder="이름을 입력하세요" maxlength="30" title="8자 까지 입력" required
					autofocus /> <span class="point successNameChk">이름은 2자 이상
						8자 이하로 설정해주시기 바랍니다.</span> <input type="hidden" id="nameDoubleChk" /></td>
			</tr>

			<tr class="email">
				<th><label for="useremail">이메일</label></th>
				<td>
					<p>
						<input id="u_id" type="text" name="u_id"
							title="이메일 주소를 입력해주세요." required /> <span id="emailChk"
							class="doubleChk">인증번호 보내기</span><br /> <input id="sm_email2"
							type="text" name="sm_email2" title="인증번호 입력" disabled required />
						<span id="emailChk2" class="doubleChk">이메일인증</span> <span
							class="point successEmailChk">이메일 입력후 인증번호 보내기를 해주십시오.</span> <input
							type="hidden" id="emailDoubleChk" />
					</p>
					<p class="tip">아이디 비밀번호 분실시 필요한 정보이므로, 정확하게 기입해 주십시오.</p>
				</td>
			</tr>

			<tr>
				<th><label for="userpass">비밀번호</label></th>
				<td><input id="userpass" type="password" name="u_pw" required
					maxlength="8" autocomplete="off" /> <span class="point">※
						비밀번호는 총 8자 까지 입력가능</span></td>
			</tr>
			<tr>
				<th><label for="userpasschk">비밀번호 확인</label></th>
				<td><input id="userpasschk" type="password" name="sm_pw_chk"
					placeholder="동일하게 입력해주세요." required maxlength="8"
					autocomplete="off" /> <span class="point successPwChk"></span> <input
					type="hidden" id="pwDoubleChk" /></td>
			</tr>


			<tr>
				<th>* 산 레벨테스트</th>
				<td><label><input type="checkbox" name="m_1"
						value="한라산" checked />한라산</label> <label><input type="checkbox"
						name="m_1" value="밷수산" />백두산</label> <label><input
						type="checkbox" name="m_1" value="원미산" checked />원미산</label> <label><input
						type="checkbox" name="m_1" value="산" />산</label></td>
			</tr>

			<tr>
				<th>주소</th>
				<td>
					<p>카카오(다음) 주소찾기</p>
					<div>Company Address</div> <input id="member_post" name="ad1"
					type="text" placeholder="Zip Code" readonly onclick="findAddr()">
					<input id="member_addr" name="ad2" type="text"
					placeholder="Address" readonly> <br> <input
					type="text" name="ad3" placeholder="Detailed Address">
				</td>
			</tr>
		</table>
		<div class="btnSet">
			<a class="btn-fill" onclick="go_join()">회원가입</a> <a class="btn-empty"
				onclick="history.go(-1)">취소</a> <input type="submit" value="회원가입">
	</form>
	</div>
	<!-- ?v=<new java.util.Date().getTime()>을 붙이면 기다릴 필요 없이 수정사항이 바로바로 새로고침이 된다.-->

	<!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>	jQuery ui -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.js"></script>

	</script>
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/ui.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.3.6.0.min.js"></script>


	<script>
		function findAddr() {
			new daum.Postcode(
					{
						oncomplete : function(data) {

							console.log(data);

							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
							// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var roadAddr = data.roadAddress; // 도로명 주소 변수
							var jibunAddr = data.jibunAddress; // 지번 주소 변수
							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('member_post').value = data.zonecode;
							if (roadAddr !== '') {
								document.getElementById("member_addr").value = roadAddr;
							} else if (jibunAddr !== '') {
								document.getElementById("member_addr").value = jibunAddr;
							}
						}
					}).open();
		}

		$("#u_id")
				.blur(
						function() {
							var u_id = $("#u_id").val();
							if (u_id == "" || u_id.length < 2) {
								$(".successEmailChk").text(
										"정확한 이메일 형식으로 넣어주세요 :)");
								$(".successEmailChk").css("color", "red");
								$("#emailDoubleChk").val("false");
							} else {
								$
										.ajax({
											url : '${pageContext.request.contextPath}/nameCheck?u_id='
													+ u_id,
											type : 'post',
											cache : false,
											success : function(data) {
												if (data == 0) {
													$(".successEmailChk").text(
															"사용가능한 아이디입니다.");
													$(".successEmailChk").css(
															"color", "green");
													$("#emailDoubleChk").val(
															"true");
												} else {
													$(".successEmailChk").text(
															"사용중인 아이디입니다 :p");
													$(".successEmailChk").css(
															"color", "red");
													$("#emailDoubleChk").val(
															"false");
												}
											},
											error : function() {
												console.log("실패");
											}
										});
							}
						});

		//비밀번호 확인
		$("#userpasschk").blur(function() {
			if ($("#userpasschk").val() == $("#userpass").val()) {
				$(".successPwChk").text("비밀번호가 일치합니다.");
				$(".successPwChk").css("color", "green");
				$("#pwDoubleChk").val("true");
			} else {
				$(".successPwChk").text("비밀번호가 일치하지 않습니다.");
				$(".successPwChk").css("color", "red");
				$("#pwDoubleChk").val("false");
			}
		});

		//이메일 인증
		var code = "";
		$("#emailChk")
				.click(
						function() {
							var u_id = $("#u_id").val();
							$
									.ajax({
										type : "GET",
										url : "mailCheck?u_id=" + u_id,
										cache : false,
										success : function(data) {
											if (data == "error") {
												alert("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.");
												$("#u_id").attr(
														"autofocus", true);
												$(".successEmailChk").text(
														"유효한 이메일 주소를 입력해주세요.");
												$(".successEmailChk").css(
														"color", "red");
											} else {
												alert("인증번호 발송이 완료되었습니다.\n입력한 이메일에서 인증번호 확인을 해주십시오.");
												$("#sm_email2").attr(
														"disabled", false);
												$("#emailChk2").css("display",
														"inline-block");
												$(".successEmailChk")
														.text(
																"인증번호를 입력한 뒤 이메일 인증을 눌러주십시오.");
												$(".successEmailChk").css(
														"color", "green");
												code = data;
											}
										}
									});
						});

		//이메일 인증번호 대조 
		$("#emailChk2").click(function() {
			if ($("#sm_email2").val() == code) {
				$(".successEmailChk").text("인증번호가 일치합니다.");
				$(".successEmailChk").css("color", "green");
				$("#emailDoubleChk").val("true");
				$("#sm_email2").attr("disabled", true); 
				//$("#sm_email").attr("disabled",true); 
			} else {
				$(".successEmailChk").text("인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.");
				$(".successEmailChk").css("color", "red");
				$("#emailDoubleChk").val("false");
				$("#sm_email2").attr("autofocus", true);
			}
		});
	</script>





</body>
</html>