<!doctype html>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>Lesson Schedule</title>

        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="<c:url value="/resources/silviomoreto-bootstrap-select-d3e3c1d/dist/css/bootstrap-select.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">

        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/silviomoreto-bootstrap-select-d3e3c1d/dist/js/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </head>

    <body>

        <div class="container">

            <%--
            <h1>Users</h1>
            <form:form method="post" action="add" commandName="user" role="form">
                <div class="form-group">
                    <form:label path="firstName">First Name:</form:label>
                    <form:input path="firstName" class="form-control" placeholder="First Name"/>
                </div>
                <div class="form-group">
                    <form:label path="lastName">Last Name:</form:label>
                    <form:input path="lastName" class="form-control" placeholder="Last Name"/>
                </div>
                <div class="form-group">
                    <form:label path="email">Email:</form:label>
                    <form:input path="email" class="form-control" placeholder="Email"/>
                </div>
                <button type="submit" class="btn btn-default">Add User</button>
            </form:form>
            --%>

            <!-- Auditorium adding form -->
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

            <!-- Course adding form -->
            <form:form method="post" action="addCourse" modelAttribute="course" role="form" class="form-inline">
                <div class="form-group">
                    <form:input path="name" class="form-control" placeholder="Название предмета"/>
                </div>
                <button type="submit" class="btn btn-default">Добавить предмет</button>
            </form:form>

            <!-- Group adding form -->
            <form:form method="post" action="addGroup" modelAttribute="group" role="form" class="form-inline">
                <div class="form-group">
                    <form:input path="name" class="form-control" placeholder="Название (шифр) группы"/>
                </div>
                <div class="form-group">
                    <form:input path="numberOfStudents" class="form-control" placeholder="Контингент"/>
                </div>
                <button type="submit" class="btn btn-default">Добавить группу</button>
            </form:form>

            <!-- Instructor adding form -->
            <form:form method="post" action="addInstructor" modelAttribute="instructor" role="form" class="form-inline">
                <div class="form-group">
                    <form:input path="name" class="form-control" placeholder="Имя преподавателя"/>
                </div>
                <div class="form-group">
                    <form:input path="title" class="form-control" placeholder="Звание"/>
                </div>
                <button type="submit" class="btn btn-default">Добавить преподавателя</button>
            </form:form>

            <form:form method="post" action="addLesson" modelAttribute="lesson" role="form" class="form-inline">
                <form:select multiple="true" path="groups" class="selectGroups selectpicker" data-live-search="true">
                    <form:options items="${groups}" itemValue="id"/>
                </form:select>

                <form:select path="course" class="selectCourse selectpicker" data-live-search="true">
                    <form:options items="${courses}" itemValue="id" itemLabel="name"/>
                </form:select>

                <%--<form:select multiple="true" path="instructors" class="selectInstructors selectpicker" data-live-search="true">--%>
                    <%--<form:options items="${instructors}" itemValue="id"/>--%>
                <%--</form:select>--%>

                <%--<form:select multiple="true" path="auditoriums" class="selectAuditoriums selectpicker" data-live-search="true">--%>
                    <%--<form:options items="${auditoriums}" itemValue="id"/>--%>
                <%--</form:select>--%>
                <input type="submit" name="addLesson" value="Добавить занятие" class="btn btn-default">
            </form:form>


            <%--
            <form:form method="POST" action="chooseAuditorium" modelAttribute="auditoriumSelect">
                <form:select path="room">
                    <form:options items="${auditoriums}" itemLabel="room"/>
                </form:select>
                <input type="submit" name="submit" value="Submit"></td>
            </form:form>
            --%>


            <%--<form:form method="post" action="addLesson" modelAttribute="lesson" role="form" class="form-inline">--%>
                <%--<spring:bind path="course.name">--%>
                    <%--<input type="text" class="form-control" placeholder="Course name"/>--%>
                <%--</spring:bind>--%>
                <%--<spring:bind path="instructor.title">--%>
                    <%--<input type="text" class="form-control" placeholder="Instructor title"/>--%>
                <%--</spring:bind>--%>
                <%--<spring:bind path="instructor.name">--%>
                    <%--<input type="text" class="form-control" placeholder="Instructor name"/>--%>
                <%--</spring:bind>--%>
                <%--<spring:bind path=""--%>
            <%--</form:form>--%>


            <%--
            <c:if test="${!empty users}">
                <h3>Users</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.lastName}, ${user.firstName}</td>
                                <td>${user.email}</td>
                                <td>
                                    <form:form action="delete/${user.id}" method="post"><input type="submit"
                                                                                               class="btn btn-danger btn-mini"
                                                                                               value="Delete"/>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            --%>

        </div>

        <script type="text/javascript">
            $('.selectGroups').selectpicker({
                noneSelectedText: 'Выберите группу'
            });
            $('.selectInstructors').selectpicker({
                noneSelectedText: 'Выберите преподавателей'
            });
            $('.selectAuditoriums').selectpicker({
                noneSelectedText: 'Выберите аудитории'
            });
            $('.selectCourse').selectpicker({
                noneSelectedText: 'Выберите предмет'
            })
            $('.selectpicker').selectpicker({
                noneResultsText: "Ничего не найдено по запросу"
            });
        </script>
    </body>
</html>