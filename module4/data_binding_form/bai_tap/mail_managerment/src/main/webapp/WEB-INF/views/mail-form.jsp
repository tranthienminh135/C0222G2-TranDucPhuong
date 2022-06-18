<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/17/2022
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        button {
            border: none;
            padding: 5px;
            border-radius: 5px;
        }
        .btn-button {
            background-color: #1ba1e2;
            color: white;
        }
        .btn-button:hover {
            background-color: #105e85;
        }
        .title {
            font-weight: bold;
        }

    </style>
</head>
<body>
<form:form action="/mail" method="post" modelAttribute="mailBox">
    <fieldset>
        <legend>Mail Box</legend>
        <table>
            <tr>
                <td class="title">Language</td>
                <td>
                    <form:select path="language">
                        <form:option value="english">English</form:option>
                        <form:option value="vietnamese">Vietnamese</form:option>
                        <form:option value="japanese">Japanese</form:option>
                        <form:option value="chinese">Chinese</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td class="title">Page size</td>
                <td>
                    Show
                    <form:select path="pageSize">
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="25">25</form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="25">25</form:option>
                    </form:select>
                    emails per page
                </td>
            </tr>
            <tr>
                <td class="title">Spams filter</td>
                <td>
                    <form:checkbox path="spamsFilter"/> Enable spams filter
                </td>
            </tr>
            <tr>
                <td class="title">Signature</td>
                <td>
                    <form:textarea cols="20" path="signature"/>
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <button class="btn-button">Update</button>
                    <button type="reset">Cancel</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
<fieldset>
    <legend>Mail Box Result</legend>
    <table>
        <tr>
            <td class="title">Language: </td>
            <td>
                ${mailBoxResult.language}
            </td>
        </tr>
        <tr>
            <td class="title">Page size: </td>
            <td>
                ${mailBoxResult.pageSize}
            </td>
        </tr>
        <tr>
            <td class="title">Spams filter: </td>
            <td>
                ${mailBoxResult.spamsFilter}
            </td>
        </tr>
        <tr>
            <td class="title">Signature: </td>
            <td>
                ${mailBoxResult.signature}
            </td>
        </tr>
    </table>
</fieldset>
</body>
</html>
