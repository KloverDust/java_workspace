<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="it" class="h-100">
<head>
	<!-- common header -->
	<jsp:include page="../header.jsp" />
	<title>Inserisci nuovo ordine</title>
</head>
<body class="d-flex flex-column h-100">
<!-- navbar -->
<jsp:include page="../navbar.jsp" />

<main class="flex-shrink-0">
	<div class="container">

		<!-- validation error banner -->
		<spring:hasBindErrors name="insert_ordine_attr">
			<div class="alert alert-danger" role="alert">
				Attenzione: controlla i campi evidenziati!
			</div>
		</spring:hasBindErrors>
		<!-- other errors -->
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':''}" role="alert">
			${errorMessage}
			<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
		</div>

		<div class="card">
			<div class="card-header">
				<h5>Inserisci nuovo ordine</h5>
			</div>
			<div class="card-body">
				<h6>I campi con <span class="text-danger">*</span> sono obbligatori</h6>

				<form:form method="post"
						   modelAttribute="insert_ordine_attr"
						   action="save"
						   class="row g-3" novalidate="novalidate">

					<!-- Cliente -->
					<div class="col-md-6">
						<label for="cliente" class="form-label">Cliente <span class="text-danger">*</span></label>
						<spring:bind path="cliente.id">
							<select id="cliente" name="cliente.id"
									class="form-select ${status.error?'is-invalid':''}">
								<option value="">-- Seleziona Cliente --</option>
								<c:forEach var="c" items="${clienti}">
									<option value="${c.id}"
											<c:if test="${c.id == insert_ordine_attr.cliente.id}">selected</c:if>>
											${c.nome} ${c.cognome}
									</option>
								</c:forEach>
							</select>
						</spring:bind>
						<form:errors path="cliente.id" cssClass="error_field"/>
					</div>

					<!-- Codice -->
					<div class="col-md-6">
						<label for="codice" class="form-label">Codice <span class="text-danger">*</span></label>
						<spring:bind path="codice">
							<input type="text"
								   id="codice"
								   name="codice"
								   class="form-control ${status.error?'is-invalid':''}"
								   placeholder="Inserisci il codice"
								   value="${insert_ordine_attr.codice}" />
						</spring:bind>
						<form:errors path="codice" cssClass="error_field"/>
					</div>

					<!-- Data Ordine -->
					<div class="col-md-6">
						<label for="dataOrdine" class="form-label">Data Ordine <span class="text-danger">*</span></label>
						<spring:bind path="dataOrdine">
							<input type="date"
								   id="dataOrdine"
								   name="dataOrdine"
								   class="form-control ${status.error?'is-invalid':''}"
								   value="${insert_ordine_attr.dataOrdine}" />
						</spring:bind>
						<form:errors path="dataOrdine" cssClass="error_field"/>
					</div>

					<!-- Chiuso -->
					<div class="col-md-6 form-check">
						<input class="form-check-input"
							   type="checkbox"
							   id="closed"
							   name="closed"
							   value="true" />
						<input type="hidden" name="_closed" value="false"/>
						<label class="form-check-label" for="closed">Chiuso</label>
					</div>
					<c:if test="${not empty requestScope['org.springframework.validation.BindingResult.insert_ordine_attr'].getFieldError('closed')}">
						<div class="invalid-feedback">
								${requestScope['org.springframework.validation.BindingResult.insert_ordine_attr'].getFieldError('closed').defaultMessage}
						</div>
					</c:if>

					<!-- Pizze -->
					<div class="col-md-12">
						<label for="pizze" class="form-label">Pizze <span class="text-danger">*</span></label>
						<spring:bind path="pizze">
							<select multiple
									id="pizze"
									name="pizze"
									class="form-select ${status.error?'is-invalid':''}">
								<c:forEach var="p" items="${pizzeList}">
									<option value="${p.id}"
											<c:if test="${insert_ordine_attr.pizze.contains(p)}">selected</c:if>>
											${p.nome} - € ${p.prezzoBase}
									</option>
								</c:forEach>
							</select>
						</spring:bind>
						<form:errors path="pizze" cssClass="error_field"/>
					</div>

					<div class="col-12">
						<button type="submit" class="btn btn-primary">Conferma</button>
						<a href="${pageContext.request.contextPath}/ordine"
						   class="btn btn-outline-secondary">Annulla</a>
					</div>

				</form:form>
			</div>
		</div>

	</div>
</main>

<!-- footer -->
<jsp:include page="../footer.jsp" />
</body>
</html>
