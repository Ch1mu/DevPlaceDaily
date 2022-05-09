package Dia25.MVC25.Controllers.Repositories;

import Dia25.MVC25.Models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongsRepository extends JpaRepository<Song, Long> {

    @Query(value = "select * from songs s where s.album_id = :id", nativeQuery = true)
    public List<Song> songsPerAlbum(@Param("id") long id);
    public Song getById(long id);
}
