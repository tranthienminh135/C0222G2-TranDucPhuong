<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/17/2022
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .title {
            font-weight: bold;
        }
    </style>
</head>
<body>
<form:form action="/upload" method="post" modelAttribute="uploadSong">
    <fieldset>
        <legend>Upload The Song</legend>
        <table>
            <tr>
                <td class="title">Song name: </td>
                <td>
                    <form:input path="songName"/>
                </td>
            </tr>
            <tr>
                <td class="title">Singer: </td>
                <td>
                    <form:input path="singer"/>
                </td>
            </tr>
            <tr>
                <td class="title">Genres: </td>
                <td>
                    <form:select path="genres">
                        <form:option value="Pop">Pop</form:option>
                        <form:option value="Country">Country</form:option>
                        <form:option value="Rock">Rock</form:option>
                        <form:option value="Folk">Folk</form:option>
                        <form:option value="Dance">Dance</form:option>
                        <form:option value="Jazz">Jazz</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td class="title">Link: </td>
                <td>
                    <form:select path="link">
                        <form:option value="https://www.youtube.com/embed/ZuJyn7lwkZQ">East Of Eden</form:option>
                        <form:option value="https://www.youtube.com/embed/GspDybPhOeY">Sold Out</form:option>
                        <form:option value="https://www.youtube.com/embed/U9OQAySv184">Toss A Coin To Your Witcher</form:option>
                        <form:option value="https://www.youtube.com/embed/cHHLHGNpCSA">Waiting For Love</form:option>
                        <form:option value="https://www.youtube.com/embed/MoWpUXF8ucE">Jar of Hearts</form:option>
                        <form:option value="https://www.youtube.com/embed/TbLT12eg-lw">Take Me To Your Heart</form:option>
                        <form:option value="https://www.youtube.com/embed/Kvog7YStzpM">Có Chàng Trai Viết Lên Cây</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <button class="btn-button">Upload</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
<fieldset>
    <legend>Upload The Song Result</legend>
    <table>
        <tr>
            <td class="title">Song name: </td>
            <td>
                ${uploadSongResult.songName}
            </td>
        </tr>
        <tr>
            <td class="title">Singer: </td>
            <td>
                ${uploadSongResult.singer}
            </td>
        </tr>
        <tr>
            <td class="title">Genres: </td>
            <td>
                ${uploadSongResult.genres}
            </td>
        </tr>
        <tr>
            <td class="title">Link: </td>
            <td>
                <iframe width="300" height="auto" src="${uploadSongResult.link}" title="The Song" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </td>
        </tr>
    </table>
</fieldset>
</body>
</html>
