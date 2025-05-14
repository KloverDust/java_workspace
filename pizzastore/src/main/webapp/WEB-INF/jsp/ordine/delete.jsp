<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="it" class="h-100">
<head>
    <!-- Common imports in pages -->
    <jsp:include page="../header.jsp" />
    <title>Elimina ordine</title>
</head>
<body class="d-flex flex-column h-100">

<!-- Fixed navbar -->
<jsp:include page="../navbar.jsp" />

<!-- Begin page content -->
<main class="flex-shrink-0">
    <div class="container">

        <div class="card">
            <div class="card-header">
                <h5>Elimina il seguente ordine</h5>
            </div>

            <form:form id="deleteForm"
                       modelAttribute="delete_ordine_attr"
                       method="post"
                       action="${pageContext.request.contextPath}/ordine/delete"
                       class="row g-3" novalidate="novalidate">

                <form:hidden path="id"/>

                <div class="card-body">
                    <dl class="row">
                        <dt class="col-sm-3 text-end">ID Ordine:</dt>
                        <dd class="col-sm-9">${delete_ordine_attr.id}</dd>
                    </dl>

                    <dl class="row">
                        <dt class="col-sm-3 text-end">Codice:</dt>
                        <dd class="col-sm-9">${delete_ordine_attr.codice}</dd>
                    </dl>

                    <dl class="row">
                        <dt class="col-sm-3 text-end">Data Ordine:</dt>
                        <dd class="col-sm-9">${delete_ordine_attr.dataOrdine}</dd>
                    </dl>

                    <dl class="row">
                        <dt class="col-sm-3 text-end">Cliente:</dt>
                        <dd class="col-sm-9">
                            <c:if test="${not empty delete_ordine_attr.cliente}">
                                ${delete_ordine_attr.cliente.nome} ${delete_ordine_attr.cliente.cognome}
                            </c:if>
                        </dd>
                    </dl>

                    <dl class="row">
                        <dt class="col-sm-3 text-end">Chiuso:</dt>
                        <dd class="col-sm-9">
                            <c:choose>
                                <c:when test="${delete_ordine_attr.closed}">Sì</c:when>
                                <c:otherwise>No</c:otherwise>
                            </c:choose>
                        </dd>
                    </dl>

                    <dl class="row">
                        <dt class="col-sm-3 text-end">Costo Totale:</dt>
                        <dd class="col-sm-9">${delete_ordine_attr.costoTotale}</dd>
                    </dl>

                    <dl class="row">
                        <dt class="col-sm-3 text-end">Pizze nell'ordine:</dt>
                        <dd class="col-sm-9">
                            <c:if test="${not empty delete_ordine_attr.pizze}">
                                <ul>
                                    <c:forEach var="pizza" items="${delete_ordine_attr.pizze}">
                                        <li>${pizza.nome} - &euro; ${pizza.prezzoBase}</li>
                                    </c:forEach>
                                </ul>
                            </c:if>
                            <c:if test="${empty delete_ordine_attr.pizze}">
                                Nessuna pizza associata
                            </c:if>
                        </dd>
                    </dl>
                </div>

                <div class="card-footer">
                    <button type="submit" class="btn btn-danger">Elimina</button>
                    <a href="${pageContext.request.contextPath}/ordine"
                       class="btn btn-outline-secondary">Back</a>
                </div>

            </form:form>

        </div> <!-- end card -->

    </div> <!-- end container -->
</main>

<!-- Footer -->
<jsp:include page="../footer.jsp" />

</body>
</html>
