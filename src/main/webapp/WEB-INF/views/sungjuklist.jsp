<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>성적 리스트</title>
</head>
<body>
    <h1>성적 리스트</h1>
    <table border="1" width="750px" cellpadding="10px" cellspacing="0">
        <tr><th>이름</th><th>국어</th><th>영어</th><th>수학</th></tr>

        <%--
            for(SungJuk sj : sjs)
        --%>
        <c:forEach items="${sjs}" var="sj">
            <tr>
                <td><a href="/view?sjno=${sj.sjno}">${sj.name}</a></td>
                <td>${sj.kor}</td>
                <td>${sj.eng}</td>
                <td>${sj.mat}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
