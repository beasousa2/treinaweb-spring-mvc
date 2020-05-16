package br.com.springmvc.domains;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;



public class Album {
	
	@NotNull(message = "O nome é obrigatório")
	@NotEmpty(message = "Ano de Lançamento é obrigatório")
	@Size(min = 4, max = 60, message = "O nome deve conter entre 4 a 60 caracteres")
	private String albumName;
	
	@NotNull(message = "Ano de Lançamento é obrigatório")
	@NotEmpty(message = "Ano de Lançamento é obrigatório")
//	@Length(min = 2, max = 4, message = "Ano incorreto")
	
	private int releaseYear;

	public String getAlbumName() {	
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

}
