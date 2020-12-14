<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="HelloSpring" name="title"/>  
</jsp:include><!-- jsp의 파라메터 넘기는 방법 -->

<section id="container">
	<img src="${pageContext.request.contextPath }/resources/images/logo-spring.png" style="display:block;margin:100px auto;" alt="스프링로고">
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>