<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100">
<head>
    <!-- Common imports in pages -->
    <jsp:include page="../header.jsp" />
    <title>Visualizza regista</title>

</head>
<body class="d-flex flex-column h-100">
<!-- Fixed navbar -->
<jsp:include page="../navbar.jsp" />

<!-- Begin page content -->
<main class="flex-shrink-0">
    <div class="container">

        <div class='card'>
            <div class='card-header'>
                Visualizza regista
            </div>

            <div class='card-body'>
                <dl class="row">
                    <dt class="col-sm-3 text-right">Id:</dt>
                    <dd class="col-sm-9">${show_regista_attr.id}</dd>
                </dl>

                <dl class="row">
                    <dt class="col-sm-3 text-right">Nome:</dt>
                    <dd class="col-sm-9">${show_regista_attr.nome}</dd>
                </dl>

                <dl class="row">
                    <dt class="col-sm-3 text-right">Cognome:</dt>
                    <dd class="col-sm-9">${show_regista_attr.cognome}</dd>
                </dl>

                <dl class="row">
                    <dt class="col-sm-3 text-right">Nickname:</dt>
                    <dd class="col-sm-9">${show_regista_attr.nickName}</dd>
                </dl>

                <dl class="row">
                    <dt class="col-sm-3 text-right">Data di nascita:</dt>
                    <dd class="col-sm-9"><fmt:formatDate type = "date" value = "${show_regista_attr.dataDiNascita}" /></dd>
                </dl>

                <!-- end card body -->
            </div>

            <!-- TODO: SISTEMARE QUESTO BACK -->
            <div class='card-footer'>
                <a href="${pageContext.request.contextPath }/regista/" class='btn btn-outline-secondary' style='width:80px'>
                    <i class='fa fa-chevron-left'></i> Back
                </a>
            </div>
            <!-- end card -->
        </div>

        <!-- end container -->
    </div>

</main>
<jsp:include page="../footer.jsp" />

</body>
</html>