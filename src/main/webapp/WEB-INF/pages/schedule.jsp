<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

            <!-- Auditorium adding form -->
            <form:form method="post" action="addAuditorium" modelAttribute="auditorium" role="form" class="form-inline">
                <div class="form-group">
                    <form:input path="room" class="form-control" placeholder="Кімната"/>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">-</div>
                        <form:input path="building" class="form-control" placeholder="Корпус"/>
                    </div>
                </div>
                <button type="submit" class="btn btn-default">Додати аудиторію</button>
            </form:form>

            <!-- Course adding form -->
            <form:form method="post" action="addCourse" modelAttribute="course" role="form" class="form-inline">
                <div class="form-group">
                    <form:input path="name" class="form-control" placeholder="Назва предмету"/>
                </div>
                <button type="submit" class="btn btn-default">Додати предмет</button>
            </form:form>

            <!-- Group adding form -->
            <form:form method="post" action="addGroup" modelAttribute="group" role="form" class="form-inline">
                <div class="form-group">
                    <form:input path="name" class="form-control" placeholder="Назва (шифр) групи"/>
                </div>
                <div class="form-group">
                    <form:input path="numberOfStudents" class="form-control" placeholder="Контингент"/>
                </div>
                <button type="submit" class="btn btn-default">Додати группу</button>
            </form:form>

            <!-- Instructor adding form -->
            <form:form method="post" action="addInstructor" modelAttribute="instructor" role="form" class="form-inline">
                <div class="form-group">
                    <form:input path="name" class="form-control" placeholder="Ім'я викладача"/>
                </div>
                <div class="form-group">
                    <form:input path="title" class="form-control" placeholder="Звання"/>
                </div>
                <button type="submit" class="btn btn-default">Додати викладача</button>
            </form:form>

            <!-- Lesson creation form -->
            <form:form method="post" action="addLesson" modelAttribute="lesson" role="form" class="form-inline">
                <form:select multiple="true" path="groups" class="selectGroups selectpicker" data-live-search="true">
                    <form:options items="${groups}" itemValue="id"/>
                </form:select>

                <form:select path="course" class="selectCourse selectpicker" data-live-search="true">
                    <form:options items="${courses}" itemValue="id" itemLabel="name"/>
                </form:select>

                <form:select multiple="true" path="instructors" class="selectInstructors selectpicker" data-live-search="true">
                    <form:options items="${instructors}" itemValue="id"/>
                </form:select>

                <form:select multiple="true" path="auditoriums" class="selectAuditoriums selectpicker" data-live-search="true">
                    <form:options items="${auditoriums}" itemValue="id"/>
                </form:select>

                <form:select path="dayOfWeek" class="selectpicker" data-live-search="true">
                    <form:options items="${dayOfWeek}" itemLabel="displayName"/>
                </form:select>

                <form:select path="number" class="selectpicker" data-live-search="true">
                    <form:options items="${number}" itemLabel="displayName"/>
                </form:select>

                <form:select path="lessonType" class="selectpicker" data-live-search="true">
                    <form:options items="${lessonType}" itemLabel="displayName"/>
                </form:select>

                <input type="submit" name="addLesson" value="Додати заняття" class="btn btn-default">
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

            <!-- Schedule table generation -->
            <c:if test="${mode == 'group'}">
                <h1 align="center">Розклад для групи ${name}</h1>
            </c:if>
            <c:if test="${mode == 'instructor'}">
                <h1 align="center">Розклад для викладача ${name}</h1>
            </c:if>
            <c:if test="${!empty lessons}">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th></th>
                            <c:forEach items="${daysOfWeek}" var="dayOfWeek">
                                <th>${dayOfWeek.displayName}</th>
                            </c:forEach>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="count" value="0" scope="page"/>
                        <c:forEach var="i" begin="1" end="5">
                            <c:forEach var="j" begin="1" end="6">
                                <c:if test="${j == 1}">
                                    <tr>
                                    <th>${numbers[i - 1].displayName}</th>
                                </c:if>
                                    <td>
                                        <c:if test="${lessons[count].number.value == i && lessons[count].dayOfWeek.value == j}">
                                            <table>
                                                <tr><td>${lessons[count].course.name}</td></tr>
                                                <tr><td>${lessons[count].instructorsString}</td></tr>
                                                <tr><td>${lessons[count].auditoriumsString} ${lessons[count].lessonType.displayName}</td></tr>
                                                <tr><td>
                                                    <form action="delete/${lessons[count].id}/" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Видалити"/></form>
                                                </td></tr>
                                            </table>
                                            <c:if test="${fn:length(lessons) > count}">
                                                <c:set var="count" value="${count + 1}" scope="page"/>
                                            </c:if>
                                        </c:if>
                                    </td>
                                <c:if test="${j == 6}">
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <%--<c:if test="${!empty users}">--%>
                <%--<h3>Users</h3>--%>
                <%--<table class="table table-bordered table-striped">--%>
                    <%--<thead>--%>
                        <%--<tr>--%>
                            <%--<th>Name</th>--%>
                            <%--<th>Email</th>--%>
                            <%--<th>&nbsp;</th>--%>
                        <%--</tr>--%>
                    <%--</thead>--%>
                    <%--<tbody>--%>
                        <%--<c:forEach items="${users}" var="user">--%>
                            <%--<tr>--%>
                                <%--<td>${user.lastName}, ${user.firstName}</td>--%>
                                <%--<td>${user.email}</td>--%>
                                <%--<td>--%>
                                    <%--<form:form action="delete/${user.id}" method="post">--%>
                                        <%--<input type="submit"--%>
                                                    <%--class="btn btn-danger btn-mini"--%>
                                                                                               <%--value="Delete"/>--%>
                                    <%--</form:form>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                        <%--</c:forEach>--%>
                    <%--</tbody>--%>
                <%--</table>--%>
            <%--</c:if>--%>


        </div>

        <script type="text/javascript">
            $('.selectGroups').selectpicker({
                noneSelectedText: 'Оберіть групи'
            });
            $('.selectInstructors').selectpicker({
                noneSelectedText: 'Оберіть викладачів'
            });
            $('.selectAuditoriums').selectpicker({
                noneSelectedText: 'Оберіть аудиторії'
            });
            $('.selectCourse').selectpicker({
                noneSelectedText: 'Оберіть предмет'
            });
            $('.selectpicker').selectpicker({
                noneResultsText: "Нічого не знайдено по запиту"
            });
        </script>
    </body>
</html>