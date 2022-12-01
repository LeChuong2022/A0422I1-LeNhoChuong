package codegym.vn.service;

import codegym.vn.bean.Song;

import java.util.List;
import java.util.Map;

public interface ISongService {
    Map<String, String> create(Song s);

    List<Song> findAll();
}
