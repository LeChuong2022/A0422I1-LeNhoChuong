package codegym.vn.service.impl;

import codegym.vn.bean.Song;
import codegym.vn.repository.ISongRepository;
import codegym.vn.service.ISongService;
import codegym.vn.validate.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    ISongRepository songRepository;

    @Override
    public Map<String, String> create(Song s) {
        Map<String, String> errorMap = new HashMap<>();
        if (!Validation.checkName(s.getName())){
            errorMap.put("format", "Format's music is wrong");
        }
        if (errorMap.isEmpty()) {
            songRepository.create(s);
        }
        return errorMap;
    }
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}
