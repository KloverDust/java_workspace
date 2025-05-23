<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="it" class="h-100" >
	 <head>

	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />

	   <title>Elimina satellite</title>

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
                                   modelAttribute="delete_satellite_attr"
                                   method="post"
                                   action="${pageContext.request.contextPath}/satellite/delete"
                                   class="row g-3" novalidate="novalidate">

                            <form:hidden path="id"/>

                            <div class='card-body'>
                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Id:</dt>
                                  <dd class="col-sm-9">${delete_satellite_attr.id}</dd>
                                </dl>

                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Denominazione:</dt>
                                  <dd class="col-sm-9">${delete_satellite_attr.denominazione}</dd>
                                </dl>

                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Codice:</dt>
                                  <dd class="col-sm-9">${delete_satellite_attr.codice}</dd>
                                </dl>

                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Data di Lancio:</dt>
                                  <dd class="col-sm-9">
                                    <fmt:parseDate value="${delete_satellite_attr.dataLancio}" pattern="yyyy-MM-dd" var="localDateToBeParsed1" type="date"/>
                                    <fmt:formatDate pattern="dd/MM/yyyy" value="${localDateToBeParsed1}" />
                                  </dd>
                                </dl>

                                <dl class="row">
                                    <dt class="col-sm-3 text-right">Data di Nascita:</dt>
                                    <dd class="col-sm-9">
                                        <fmt:parseDate value="${delete_satellite_attr.dataRientro}" pattern="yyyy-MM-dd" var="localDateToBeParsed2" type="date"/>
                                        <fmt:formatDate pattern="dd/MM/yyyy" value="${localDateToBeParsed2}" />
                                    </dd>
                                </dl>

                                <dl class="row">
                                  <dt class="col-sm-3 text-right">Stato :</dt>
                                  <dd class="col-sm-9">${delete_satellite_attr.stato}</dd>
                                </dl>

                                <div class="card-footer">
                                    <button type="submit" class="btn btn-danger">Elimina</button>
                                    <a href="${pageContext.request.contextPath}/satellite"
                                       class="btn btn-outline-secondary">Back</a>
                                </div>

					    	</form:form>


					    </div>
					    <!-- end card body -->


					    <div class='card-footer'>
					        <a href="${pageContext.request.contextPath}/satellite" class='btn btn-outline-secondary' style='width:80px'>
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