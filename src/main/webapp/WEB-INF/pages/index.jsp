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
        <!-- Schedule search form -->
        <form:form method="post" action="addAuditorium" modelAttribute="auditorium" role="form" class="form-inline">
            <div class="form-group">
                <form:input path="room" class="form-control" placeholder="Комната"/>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon">-</div>
                    <form:input path="building" class="form-control" placeholder="Корпус"/>
                </div>
            </div>
            <button type="submit" class="btn btn-default">Добавить аудиторию</button>
        </form:form>
    </div>
</body>
</html>
