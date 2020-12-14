<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="HelloSpring" name="title"/>  
</jsp:include>

<section id="container">
	
	<section id="board-container" class="container">
        <p>총 ${total }건의 게시물이 있습니다.</p>
        <input type="button" value="글쓰기" id="btn-add" class="btn btn-outline-success" onclick="location.replace('${path}/board/boardForm.do');">
        
        <table id="tbl-board" class="table table-striped table-hover">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>첨부파일</th>
                <th>조회수</th>
            </tr>
			<c:forEach items="${list }" var="b">
		            <tr>
	            		
		                <td><c:out value="${b.boardNo }"/></td>
		                <td><a href="${path }/board/boardDetail.do?no=${b.boardNo}"><c:out value="${b.boardTitle }"/></a></td>
		                <td><c:out value="${b.boardWriter }"/></td>
		                <td><fmt:formatDate type="date" pattern="yyyy-MM-dd" value="${b.boardDate }"/></td>
		                <td align="center">
							<c:if test="${b.fileCount>0 }">
								<img src="${path }/resources/images/file.png" width="16px"/>
							</c:if>
		                </td>
		                <td><c:out value="${b.boardReadCount }"/></td>
	           			
		            </tr>
			</c:forEach>
        </table>
        <div id="page-container">
        	${pageBar }
        </div> 
    </section>
	
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>