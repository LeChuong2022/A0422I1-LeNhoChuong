<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/26/2022
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h4>Settings</h4>
<a href="/mail/list">Back List</a>
<form:form action="/mail/setting" method="post" modelAttribute="settingMail">
    <table border="1">
        <tr>
            <td style="font-weight: bold">Language:</td>
            <td colspan="3"><form:select type="text" path="language">
                <form:options items="${languageList}"></form:options>
            </form:select></td>
        </tr>
        <tr>
            <td style="font-weight: bold">Page Size:</td>

            <td>Show</td>
            <td>
                <form:select type="text" path="amount">
                    <form:options items="${amountList}"></form:options>
                </form:select></td>
            <td>
                emails per page
            </td>
        </tr>
        <tr>
            <td style="font-weight: bold">Spams filter:</td>
            <td colspan="3"><form:checkbox path="enableSpamsFilter" /> Enables spams filter</td>
        </tr>

        <tr>
            <td style="font-weight: bold">Signature:</td>
            <td><form:textarea type="text" path="signature"/></td>
        </tr>
    </table>
    <button type="submit" style="width: 60px; height: 30px">Update</button>
    <button type="reset" style="width: 60px; height: 30px">Cancel</button>
</form:form>

</body>
</html>
