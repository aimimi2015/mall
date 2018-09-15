<%@ page language="java"  contentType="text/html; charset=UTF-8" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    request.setAttribute("basePath", basePath);

%>


<html>
<body>

${basePath}
tomcat1111

<form name="input" action="${basePath}/user/login.do" method="post">
    <table cellpadding="0" cellspacing="5" border="0">
        <tr>
            <th>账号：</th>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <th>密码：</th>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit" value="确定">
                <input type="reset" value="取消">
            </td>
        </tr>
    </table>
</form>


springmvc上传文件
<form name="form1" action="${basePath}/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="springmvc上传文件" />
</form>


富文本图片上传文件
<form name="form2" action="${basePath}/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="富文本图片上传文件" />
</form>

</body>
</html>
