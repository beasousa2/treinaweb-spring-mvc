<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>    

	<j:url var="actionChange" value="/albuns/alterar" ></j:url>
	
	<div>
		<h3 class="text-center h3 text-primary">Alterar Álbum ${album.albumName}</h3>
	
		<f:form action="${actionChange}" method="POST" modelAttribute="album">
			<div class="row">
				<div class="form-group col-md-6 col-xs-12">
    				<label for="exampleInputEmail1">Id</label>
    				<f:input path="id" type="text" class="form-control" id="exampleInputEmail1" readonly="true"/>
    				    		
  				</div>
  			</div>
			<div class="row">
				<div class="form-group col-md-6 col-xs-12">
    				<label for="exampleInputEmail1">Nome</label>
    				<f:input path="albumName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
    				<small id="emailHelp" class="form-text text-danger"> <f:errors path="albumName"></f:errors> </small>    		
  				</div>
  			</div>
  			<div class="row">
	  			<div class="form-group col-md-6 col-xs-12">
    				<label for="exampleInputPassword1">Ano de Lançamento</label>
    				<f:input path="releaseYear" type="text" class="form-control" id="exampleInputPassword1"/>    		
  				</div>
  			</div>  
  			<button type="submit" class="btn btn-primary">Salvar</button>
		</f:form>
	</div>
	
