<%--
  Created by IntelliJ IDEA.
  User: Quang Nhu
  Date: 6/30/2020
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<div class="page-content">
    <%--                <div class="ace-settings-container" id="ace-settings-container">--%>
    <%--                    <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">--%>
    <%--                        <i class="ace-icon fa fa-cog bigger-130"></i>--%>
    <%--                    </div>--%>

    <table>
        <tr>
            <th>Tên bài viết</th>
            <th>Mô tả ngắn</th>
            <th>Ngày tạo</th>
        </tr>
        <c:forEach var="item" items="${model}">
            <tr>
                <td>${item.getTitle()}</td>
                <td>${item.getShortDescription()}</td>
                <td>${item.getCreatedDate()}</td>
            </tr>
        </c:forEach>
    </table>

    <!--Show PAGING-->
<%--    <%@include file="/common/paging/paging.jsp" %>--%>
    <!-- PAGE CONTENT ENDS -->

    <%--                </div><!-- /.row -->--%>
</div><!-- /.page-content -->
</body>
</html>
