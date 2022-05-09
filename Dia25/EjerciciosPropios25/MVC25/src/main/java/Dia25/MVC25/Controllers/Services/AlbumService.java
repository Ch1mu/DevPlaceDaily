package Dia25.MVC25.Controllers.Services;

import Dia25.MVC25.Controllers.Repositories.AlbumRepository;
import Dia25.MVC25.Models.Album;
import Dia25.MVC25.Models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository aR;

    public void save(Album album)
    {
        aR.save(album);
    }
    public List<Album> getAll()
    {
        return aR.findAll();
    }

    public Album getById(long id)
    {
        return aR.getById(id);
    }
}
