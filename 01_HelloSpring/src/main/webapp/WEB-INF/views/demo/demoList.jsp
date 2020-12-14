<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="HelloSpring" name="title"/>
</jsp:include>

<section id="container">
	<table class="table">
		<tr>
			<th scope="col">번호</th>
			<th scope="col">이름</th>
			<th scope="col">나이</th>
			<th scope="col">이메일</th>
			<th scope="col">성별</th>
			<th scope="col">개발가능언어</th>
			<th scope="col">수정</th>
		</tr>
		<c:forEach items="${list }" var="d">
			<tr>
				<td>${d['devNo'] }</td>
				<td>${d['devName'] }</td>
				<td>${d['devAge'] }</td>
				<td>${d['devEmail'] }</td>
				<td>${d['devGender']=='M'?"남":"여" }</td>
				<td>
					<c:forEach items="${d['devLang'] }" var="l" varStatus="vs">
						${vs.index!=0?",":"" }${l }
					</c:forEach>
				</td>
				<td>
					<button type="button" class="btn btn-outline-light" onclick="">수정</button>
					<button type="button" class="btn btn-outline-light" onclick="">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>