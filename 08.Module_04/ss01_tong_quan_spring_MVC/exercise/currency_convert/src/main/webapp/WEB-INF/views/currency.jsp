<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency convert</title>
</head>
<body>
<h3>Đổi tiền tệ VND - USD</h3>

<form method="post" action="/currency">
    <table>
        <colgroup>
            <col width="150" span="1">
            <col width="20" span="1">
            <col width="150" span="1">
            <col width="20" span="1">
            <col width="150" span="1">
        </colgroup>
        <tr>
            <th> Amount</th>
            <td></td>
            <th> From Currency</th>
            <td></td>
            <th> To Currency</th>
        </tr>
        <tr>
            <td class="borderE"><input type="text" id="amount" name="amount" value="${amount}"></td>
            <td></td>
            <td align="center"><select id="fromC" name="inputC">
                <option value="VND" ${inputC.equals("VND") ? 'selected' : ''}>VND</option>
                <option value="USD" ${inputC.equals("USD") ? 'selected' : ''}>USD</option>
            </select></td>
            <td></td>
            <td align="center"><select id="toC" name="outputC">
                <option value="USD" ${outputC.equals("USD") ? 'selected' : ''}>USD</option>
                <option value="VND" ${outputC.equals("VND") ? 'selected' : ''}>VND</option>
            </select></td>
            <td>
                <button style="background-color: cornflowerblue; color: white" type="submit" >
                    Convert
                </button>
            </td>
        </tr>
        <tr>
            <td colspan="5" id="result">${result}</td>
        </tr>

    </table>
</form>
</body>
</html>
