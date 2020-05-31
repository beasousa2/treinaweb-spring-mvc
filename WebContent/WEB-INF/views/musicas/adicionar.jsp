<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>    

	<j:url var="actionAdd" value="/musicas/adicionarMusica" ></j:url>
	
	<div>
		<h3 class="text-center h3 text-primary">Nova Música</h3>
	
		<f:form action="${actionAdd}" method="POST" modelAttribute="musica">
			<div class="row">
				<div class="form-group col-md-6 col-xs-12">
    				<label for="exampleInputEmail1">Nome</label>
    				<f:input path="musicName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
    				<small id="emailHelp" class="form-text text-danger"> <f:errors path="musicName"></f:errors> </small>    		
  				</div>
  			</div>
  			<div class="row">
				<div class="form-group col-md-6 col-xs-12">
    				<label for="exampleInputEmail1">Data de Criação</label>
    				<f:input path="creationDate" type="date" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
    				<small id="emailHelp" class="form-text text-danger"> <f:errors path="creationDate"></f:errors> </small>    		
  				</div>
  			</div>
  			<div class="row">
	  			<div class="form-group col-md-6 col-xs-12">
    				<label for="exampleInputPassword1">Álbum</label>
    				<f:select path="albuns.id" class="form-control" id="exampleInputPassword1">
    					<f:options items="${albuns}" itemLabel="albumName " itemValue="id"/>
    				</f:select>    		
  				</div>
  			</div>  
  			<button type="submit" class="btn btn-primary">Salvar</button>
		</f:form>
	</div>
	
