<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="HelloSpring" name="title"/>  
</jsp:include>

<section id="container">
	
	<%-- <h1>${exception.message }</h1> EL사용불가--%>
		<h1><%=exception.getMessage() %></h1>
		<a href="${path }">메인화면으로</a>
	
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>