package br.com.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springmvc.domains.Album;

public interface AlbumRepositorie extends JpaRepository<Album, Long>{

}
