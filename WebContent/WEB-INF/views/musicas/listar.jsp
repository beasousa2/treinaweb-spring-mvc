<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<div class="row" >
		<div class="col-md-6" >
			<h3  class="text-center h3 text-primary">Músicas</h3>
		</div>
		<div class="col-md-6" >
			<a class="btn btn-primary btn-md" href="/TreinawebSpringMVC/musicas/adicionarMusica">
				<span>Adicionar</span>
				<svg class="bi bi-plus-circle-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="#fff" xmlns="http://www.w3.org/2000/svg">
  					<path fill-rule="evenodd" d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4a.5.5 0 0 0-1 0v3.5H4a.5.5 0 0 0 0 1h3.5V12a.5.5 0 0 0 1 0V8.5H12a.5.5 0 0 0 0-1H8.5V4z"/>
				</svg>
			</a>
		</div>
	</div>
	
	<div class="mt-3" ></div>
	 
	<div class="table-responsive">
		<table class="table table-hover">
  			<thead class="thead-dark">
    			<tr>
      				<th scope="col">Nome</th>
      				<th scope="col">Data de Criação</th>
      				<th scope="col">Álbum</th>
      				<th scope="col">Editar</th>
      				<th scope="col">Excluir</th>
    			</tr>
  			</thead>
  			<tbody>
  				<j:if test="${!empty musicas }">
  					<j:forEach items="${musicas}" var="mus">
  						<tr>
      						<td>${mus.musicName}</td>
      						<fmt:formatDate value="${mus.creationDate}" pattern="dd/MM/yyyy" timeZone="UTC"/>
      						<td></td>
      						<td>${mus.albuns.albumName}</td>
      						<td> 
      							<a class="btn btn-success btn-sm" href="/TreinawebSpringMVC/musicas/alterarMusica/${mus.id}" role="button">
      								<svg class="bi bi-pencil" width="1em" height="1em" viewBox="0 0 16 16" fill="#fff" xmlns="http://www.w3.org/2000/svg">
  										<path fill-rule="evenodd" d="M11.293 1.293a1 1 0 011.414 0l2 2a1 1 0 010 1.414l-9 9a1 1 0 01-.39.242l-3 1a1 1 0 01-1.266-1.265l1-3a1 1 0 01.242-.391l9-9zM12 2l2 2-9 9-3 1 1-3 9-9z" clip-rule="evenodd"/>
  										<path fill-rule="evenodd" d="M12.146 6.354l-2.5-2.5.708-.708 2.5 2.5-.707.708zM3 10v.5a.5.5 0 00.5.5H4v.5a.5.5 0 00.5.5H5v.5a.5.5 0 00.5.5H6v-1.5a.5.5 0 00-.5-.5H5v-.5a.5.5 0 00-.5-.5H3z" clip-rule="evenodd"/>
									</svg>
      							</a> 
      						</td>
      						<td> 
      							<a class="btn btn-danger btn-sm" href="/TreinawebSpringMVC/musicas/excluirMusica/${mus.id}" role="button">
      								<svg class="bi bi-x-circle-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="#fff" xmlns="http://www.w3.org/2000/svg">
  										<path fill-rule="evenodd" d="M16 8A8 8 0 110 8a8 8 0 0116 0zm-4.146-3.146a.5.5 0 00-.708-.708L8 7.293 4.854 4.146a.5.5 0 10-.708.708L7.293 8l-3.147 3.146a.5.5 0 00.708.708L8 8.707l3.146 3.147a.5.5 0 00.708-.708L8.707 8l3.147-3.146z" clip-rule="evenodd"/>
									</svg>
      							</a> 
      						</td>
    					</tr>	
  					</j:forEach>
  				</j:if>
    			    
  			</tbody>
		</table>	
	</div>
