<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="it" class="h-100">
<head>
	<jsp:include page="../header.jsp" />
	<title>Elenco Pizze</title>
</head>
<body class="d-flex flex-column h-100">
<jsp:include page="../navbar.jsp" />

<main class="flex-shrink-0">
	<div class="container">

		<!-- Alerts -->
		<div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none':''}" role="alert">
			${successMessage}
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
		</div>
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':''}" role="alert">
			${errorMessage}
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
		</div>

		<div class="card">
			<div class="card-header">
				<h5>Lista delle Pizze</h5>
			</div>
			<div class="card-body">
				<a class="btn btn-primary mb-3" href="${pageContext.request.contextPath}/pizza/insert">
					Aggiungi Nuova Pizza
				</a>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
						<tr>
							<th>Descrizione</th>
							<th>Ingredienti</th>
							<th>Prezzo Base (€)</th>
							<th>Attiva</th>
							<th>Azioni</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${pizza_list_attribute}" var="pizzaItem">
							<tr>
								<td><c:out value="${pizzaItem.descrizione}" /></td>
								<td><c:out value="${pizzaItem.ingredienti}" /></td>
								<td>
									<fmt:formatNumber value="${pizzaItem.prezzoBase}"
													  type="currency"
													  currencySymbol="€" />
								</td>
								<td>
									<c:choose>
										<c:when test="${pizzaItem.attivo}">Sì</c:when>
										<c:otherwise>No</c:otherwise>
									</c:choose>
								</td>
								<td>
									<a class="btn btn-sm btn-outline-secondary"
									   href="${pageContext.request.contextPath}/pizza/show/${pizzaItem.id}">
										Visualizza
									</a>
									<a class="btn btn-sm btn-outline-primary mx-2"
									   href="${pageContext.request.contextPath}/pizza/edit/${pizzaItem.id}">
										Modifica
									</a>
									<a class="btn btn-sm btn-outline-danger"
									   href="${pageContext.request.contextPath}/pizza/delete/${pizzaItem.id}"
									   onclick="return confirm('Eliminare la pizza #${pizzaItem.id}?');">
										Elimina
									</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</main>

<jsp:include page="../footer.jsp" />
</body>
</html>
