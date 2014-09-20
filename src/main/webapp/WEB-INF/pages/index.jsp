<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Lesson Schedule</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <!-- Schedule search by group -->
        <h1>Пошук розкладу для групи</h1>
        <form:form method="post" modelAttribute="groupSearchForm" action="showScheduleForGroup" role="form" class="form-inline">
            <form:select required="true" class="selectpicker" data-live-search="true" path="group">
                <form:options items="${groups}" itemValue="id"/>
            </form:select>

            <input type="submit" name="showScheduleForGroup" value="Показати розклад" class="btn btn-default">
        </form:form>

        <!-- Schedule search by instructor -->
        <h1>Пошук розкладу для викладача</h1>
        <form:form method="post" modelAttribute="instructorSearchForm" action="showScheduleForInstructor" role="form" class="form-inline">
            <form:select required="true" class="selectpicker" data-live-search="true" path="instructor">
                <form:options items="${instructors}" itemValue="id"/>
            </form:select>

            <input type="submit" name="showScheduleForInstructor" value="Показати розклад" class="btn btn-default">
        </form:form>

        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Войти</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p>Ваш логин: <sec:authentication property="principal.username" /></p>
            <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>
        </sec:authorize>

    </div>
</body>
</html>
