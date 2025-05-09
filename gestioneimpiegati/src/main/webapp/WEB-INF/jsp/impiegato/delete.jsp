<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="it" class="h-100" >
	 <head>

	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />

	   <title>Elimina impiegato</title>

	 </head>
	   <body class="d-flex flex-column h-100">

	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>


			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">

			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza dettaglio</h5>
					    </div>

                        <form:form id="deleteForm"
                                   modelAttribute="delete_impiegato_attr"
                                   method="post"
                                   action="${pageContext.request.contextPath}/impiegato/delete"
                                   class="row g-3" novalidate="novalidate">

                            <form:hidden path="id"/>

                            <div class='card-body'>
                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Id:</dt>
                                  <dd class="col-sm-9">${delete_impiegato_attr.id}</dd>
                                </dl>

                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Nome:</dt>
                                  <dd class="col-sm-9">${delete_impiegato_attr.nome}</dd>
                                </dl>

                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Cognome:</dt>
                                  <dd class="col-sm-9">${delete_impiegato_attr.cognome}</dd>
                                </dl>

                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Matricola:</dt>
                                  <dd class="col-sm-9">${delete_impiegato_attr.matricola}</dd>
                                </dl>

                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Data di Nascita:</dt>
                                  <dd class="col-sm-9">
                                    <fmt:parseDate value="${delete_impiegato_attr.dataDiNascita}" pattern="yyyy-MM-dd" var="localDateToBeParsed" type="date"/>
                                    <fmt:formatDate pattern="dd/MM/yyyy" value="${localDateToBeParsed}" />
                                  </dd>
                                </dl>

                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Stato :</dt>
                                  <dd class="col-sm-9">${delete_impiegato_attr.stato}</dd>
                                </dl>

                                <div class="card-footer">
                                    <button type="submit" class="btn btn-danger">Elimina</button>
                                    <a href="${pageContext.request.contextPath}/impiegato"
                                       class="btn btn-outline-secondary">Back</a>
                                </div>

					    	</form:form>


					    </div>
					    <!-- end card body -->


					    <div class='card-footer'>
					        <a href="${pageContext.request.contextPath}/impiegato" class='btn btn-outline-secondary' style='width:80px'>
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