package Dia25.MVC25.Controllers.Services;


import Dia25.MVC25.Controllers.Repositories.SongsRepository;

import Dia25.MVC25.Models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongsRepository aR;

    public void save(Song song)
    {
        aR.save(song);
    }
    public List<Song> getAll()
    {
        return aR.findAll();
    }

    public List<Song> songsPerAlbum(long id)
    {
        return  aR.songsPerAlbum(id);
    }
    public Song getById(long id)
    {
        return aR.getById(id);
    }

    public Song songPerId(long id)
    {
        return aR.getById(id);
    }
}
