<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/libs/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/libs/jquery.dataTables.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery.min.js"></script>
    <script type="text/javascript" charset="utf8"
            src="${pageContext.request.contextPath}/js/libs/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/js/libs/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/bootbox.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/libs/angular.min.js"></script>
    <title>我的账户</title>
</head>
<body ng-app="accountApp">
<div ng-controller="accountCtrl">
    <%--<span>您当前的可用资金为：￥{{momey}}元</span>--%>
    <table id="table_id_example" class="display">
        <thead>
        <tr>
            <%--<th>时间</th>
            <th>类型</th>--%>
            <th>金额(元)</th>
        </tr>
        </thead>
        <tbody>
        <td>￥{{momey}}元</td>
        </tbody>
    </table>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/account.js"></script>
</html>