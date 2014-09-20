<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Lesson Schedule</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/schedule.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-select/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">

        <!-- Schedule search by group -->
        <form:form method="post" modelAttribute="group" action="showScheduleForGroup" role="form" class="form-inline">
            <form:select class="selectGroups selectpicker" data-live-search="true" path="">
                <form:options items="${groups}" itemValue="id"/>
            </form:select>

            <input type="submit" name="showLessonForGroup" value="Показати розклад" class="btn btn-default">
        </form:form>

    </div>
</body>
</html>
