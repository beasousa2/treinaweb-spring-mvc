package br.com.springmvc.domains;




import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "alb_albuns")
public class Album {
	
	public Album() {
		this.music = new HashSet<Music>();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alb_id")
	private long id;
	
	@NotNull(message = "O nome é obrigatório")
	@NotEmpty(message = "O nome é obrigatório")
	@Size(min = 4, max = 150, message = "O nome deve conter entre 4 a 60 caracteres")
	@Column(name = "alb_name", length = 150, nullable = false)
	private String albumName;
	
//	@NotNull(message = "Ano de Lançamento é obrigatório")
//	@NotEmpty(message = "Ano de Lançamento é obrigatório")
//	@Min(value=1900, message = "Ano inferior a 1900")
	@Column(name = "alb_release_year", nullable = false)
	private int releaseYear;
	
	@OneToMany(mappedBy = "album", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	private Set<Music> music;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Set<Music> getMusic() {
		return music;
	}

	public void setMusic(Set<Music> music) {
		this.music = music;
	}
	
	

}
