package Dia25.MVC25.Controllers.Repositories;

import Dia25.MVC25.Models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    public Album getById(long id);
}
