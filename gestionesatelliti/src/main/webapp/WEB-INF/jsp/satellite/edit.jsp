<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
		<style>
			.error_field {
				color: red;
			}
		</style>

	<title>Modifica satellite esistente</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<%-- se l'attributo in request ha errori --%>
					<spring:hasBindErrors  name="edit_satellite_attr">
						<%-- alert errori --%>
						<div class="alert alert-danger " role="alert">
							Attenzione!! Sono presenti errori di validazione
						</div>
					</spring:hasBindErrors>
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
					  <div class='card'>
						    <div class='card-header'>
						        <h5>Modifica satellite esistente</h5>
						    </div>
						    <div class='card-body'>
				
									<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
				
				
									<form:form modelAttribute="edit_satellite_attr" method="post" action="${pageContext.request.contextPath}/satellite/update" class="row g-3" novalidate="novalidate">
									
									    <form:hidden path="id"/>

										<div class="col-md-6">
											<label for="nome" class="form-label">Nome <span class="text-danger">*</span></label>
											<spring:bind path="nome">
												<input type="text" name="nome" id="nome" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il nome" value="${edit_satellite_attr.nome }" required>
											</spring:bind>
											<form:errors  path="nome" cssClass="error_field" />
										</div>
										
										<div class="col-md-6">
											<label for="cognome" class="form-label">Cognome <span class="text-danger">*</span></label>
											<spring:bind path="cognome">
												<input type="text" name="cognome" id="cognome" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire il cognome" value="${edit_satellite_attr.cognome }" required>
											</spring:bind>
											<form:errors  path="cognome" cssClass="error_field" />
										</div>
									
										<div class="col-md-6">
											<label for="matricola" class="form-label">Matricola <span class="text-danger">*</span></label>
											<spring:bind path="matricola">
												<input type="text" name="matricola" id="matricola" class="form-control ${status.error ? 'is-invalid' : ''}" placeholder="Inserire la matricola" value="${edit_satellite_attr.matricola }" required>
											</spring:bind>
											<form:errors  path="matricola" cssClass="error_field" />
										</div>
										
										
										<fmt:parseDate value="${edit_satellite_attr.dataDiNascita}" pattern="yyyy-MM-dd" var="localDateToBeParsed" type="date"/>
										<fmt:formatDate pattern="yyyy-MM-dd" value="${localDateToBeParsed}" var="parsedDate"/>
										<div class="col-md-3">
											<label for="dataDiNascita" class="form-label">Data di Nascita <span class="text-danger">*</span></label>
		                        			<spring:bind path="dataDiNascita">
			                        		<input class="form-control ${status.error ? 'is-invalid' : ''}" id="dataDiNascita" type="date" placeholder="dd/MM/yy"
			                            		title="formato : gg/mm/aaaa"  name="dataDiNascita" required 
			                            		value="${parsedDate}" >
				                            </spring:bind>
			                            	<form:errors  path="dataDiNascita" cssClass="error_field" />
										</div>
										
										<div class="col-md-3">
											<label for="stato" class="form-label">Stato <span class="text-danger">*</span></label>
										    <spring:bind path="stato">
											    <select class="form-select ${status.error ? 'is-invalid' : ''}" id="stato" name="stato" required>
											    	<option value="" selected> - Selezionare - </option>
											    	<option value="ATTIVO" ${edit_satellite_attr.stato == 'ATTIVO'?'selected':''}>ATTIVO</option>
											      	<option value="SOSPESO" ${edit_satellite_attr.stato == 'SOSPESO'?'selected':''}>SOSPESO</option>
											      	<option value="DIMESSO" ${edit_satellite_attr.stato == 'DIMESSO'?'selected':''}>DIMESSO</option>
										    	</select>
										    </spring:bind>
										    <form:errors  path="stato" cssClass="error_field" />
										</div>
										
										
									<div class="col-12">
										<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
									</div>
				
								</form:form>
		  
						    
						    
							<!-- end card-body -->			   
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