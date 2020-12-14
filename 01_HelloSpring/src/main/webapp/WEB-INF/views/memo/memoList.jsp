<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="HelloSpring" name="title"/>  
</jsp:include>

<section id="container">
	
		<div id="memo-container">
		<form action="${path }/memo/insertMemo.do" class="form-inline">
			<input type="text" class="form-control col-sm-6" name="memo"
			placeholder="메모" required>&nbsp;
			<input type="password" class="form-control col-sm-2" name="password"
			maxlength="4" placeholder="비밀번호입력" required="required">
			<button type="submit" class="btn btn-outline-success">저장</button>
		</form>
	</div>
	<br />
        <!-- 메모목록 -->
        <table class="table">
            <tr>
                <th scope="col">번호</th>
                <th scope="col">메모</th>
                <th scope="col">날짜</th>
                <th scope="col">삭제</th>
            </tr>
            <c:forEach items="${list }" var="m">
                <tr>
                    <td>${m['MEMONO'] }</td>
                    <td>${m['MEMO'] }</td>
                    <td>${m['MEMODATE'] }</td>
                </tr>
			</c:forEach>
        </table>
	
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>