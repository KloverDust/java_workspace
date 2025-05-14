<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="it" class="h-100" >
<head>

    <!-- Common imports in pages -->
    <jsp:include page="../header.jsp" />

    <title>Elimina film</title>

</head>
<body class="d-flex flex-column h-100">

<!-- Fixed navbar -->
<jsp:include page="../navbar.jsp"></jsp:include>


<!-- Begin page content -->
<main class="flex-shrink-0">
    <div class="container">

        <div class='card'>
            <div class='card-header'>
                <h5>Elimina il seguente film</h5>
            </div>

            <form:form id="deleteForm"
                       modelAttribute="delete_film_attr"
                       method="post"
                       action="${pageContext.request.contextPath}/film/delete"
                       class="row g-3" novalidate="novalidate">

            <form:hidden path="id"/>

            <div class='card-body'>
                <dl class="row">
                    <dt class="col-sm-3 text-right">Id:</dt>
                    <dd class="col-sm-9">${delete_film_attr.id}</dd>
                </dl>

                <dl class="row">
                    <dt class="col-sm-3 text-right">Titolo:</dt>
                    <dd class="col-sm-9">${delete_film_attr.titolo}</dd>
                </dl>

                <dl class="row">
                    <dt class="col-sm-3 text-right">Genere:</dt>
                    <dd class="col-sm-9">${delete_film_attr.genere}</dd>
                </dl>

                <dl class="row">
                    <dt class="col-sm-3 text-right">Data Pubblicazione:</dt>
                    <dd class="col-sm-9"><fmt:formatDate type = "date" value = "${delete_film_attr.dataPubblicazione}" /></dd>
                </dl>

                <dl class="row">
                    <dt class="col-sm-3 text-right">Durata (min.):</dt>
                    <dd class="col-sm-9">${delete_film_attr.minutiDurata}</dd>
                </dl>

                <div class="card-footer">
                    <button type="submit" class="btn btn-danger">Elimina</button>
                    <a href="${pageContext.request.contextPath}/film"
                       class="btn btn-outline-secondary">Back</a>
                </div>

                </form:form>


            </div>
            <!-- end card body -->


            <div class='card-footer'>
                <a href="${pageContext.request.contextPath}/film" class='btn btn-outline-secondary' style='width:80px'>
                    <i class='fa fa-chevron-left'></i> Back
                </a>
            </div>
            <!-- end card -->
        </div>


        <!-- end container -->
    </div>

</main>

<!-- Footer -->
<jsp:include page="../footer.jsp" />
</body>
</html>