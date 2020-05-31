package br.com.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springmvc.domains.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {

}
