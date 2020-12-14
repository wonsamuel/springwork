<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="HelloSpring" name="title"/>  
</jsp:include>
<style>
	div#board-container{width:400px; margin:0 auto; text-align:center;}
	div#board-container input,div#board-container button{margin-bottom:15px;}
	/* 부트스트랩 : 파일라벨명 정렬*/
	div#board-container label.custom-file-label{text-align:left;}
</style>

<section id="container">
	<div id="board-container">
        <input type="text" class="form-control" placeholder="제목" name="boardTitle" id="boardTitle" value="${board.boardTitle }" required>
        <input type="text" class="form-control" name="boardWriter" value="${board.boardWriter }" readonly required>

       		<c:forEach items="${files }" var="f" varStatus="vs">
	            <button type="button" 
	                    class="btn btn-outline-success btn-block"
	                    onclick="fileDownload('${f.originalFilename}','${f.renamedFilename }')">
	             	첨부파일 ${vs.count } - ${f.originalFilename }   		 
	            </button>
			</c:forEach>
        
        <textarea class="form-control" name="boardContent" placeholder="내용" required>${board.boardContent }</textarea>
    </div>

	
	<script>
		function fileDownload(ori, rename) {
			
			/* 주소창에 인코딩처리해서 파라메터 보내기 */
			 ori = encodeURIComponent(ori);
			
			
			location.href="${path}/board/fileDownload?ori="+ori+"&rename="+rename;
		}
	</script>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>