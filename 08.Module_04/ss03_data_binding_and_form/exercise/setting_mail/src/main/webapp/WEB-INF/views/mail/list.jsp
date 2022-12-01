<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Mail</title>
</head>
<body>
<h1>List Mails</h1>
<p>${mess}</p>
<a href="/mail/setting">Update Mail</a>
<h4>Language: ${settingMail.language}</h4>
<h4>Show: ${settingMail.amount} emails per page</h4>
<h4>${settingMail.enableSpamsFilter ? "Show mail not spam" : "Show mail spam"}</h4>
<table border="1">
    <tr>
        <th>No.</th>
        <th>Mail Name</th>
        <th>Subject</th>
        <th>Note</th>
    </tr>
    <c:set var="i" value="0"/>
    <c:forEach items="${mail}" var="mail" varStatus="status">
        <c:if test="${(!settingMail.enableSpamsFilter || (settingMail.enableSpamsFilter && !mail.mailSpam)) && i < settingMail.amount}">
            <tr>
                <td><c:out value="${i=i+1}"></c:out></td>
                <td>${mail.mailName}</td>
                <td>${mail.subject}</td>
                <td>
                    <c:if test="${!settingMail.enableSpamsFilter}">
                        <c:if test="${mail.mailSpam}">Mail Spam</c:if>
                    </c:if>
                    <c:if test="${!mail.mailSpam}">Mail not Spam</c:if>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
