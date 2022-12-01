package codegym.vn.repository;

import codegym.vn.bean.Song;

import java.util.List;

public interface ISongRepository {
    void create(Song s);

    List<Song> findAll();

}
