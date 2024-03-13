package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
public class ApiController {
    private final Logger log = LoggerFactory.getLogger(ApiController.class);
    Map<Integer, Film> films = new HashMap<>();

    @GetMapping("/{id}")
    public Film getMethodFilm(@PathVariable(name = "id") int id) {
        log.info("get film");
        return films.get(id);
    }

    @PostMapping
    public Film postMethodFilm(@RequestBody Film entityFilm) {
        log.info("post new film");
        films.put(films.size(), entityFilm);
        return entityFilm;
    }

    @PutMapping("/{id}")
    public Film putMethodFilm(@PathVariable(name = "id") int id, @RequestBody Film entityFilm) {
        log.info("put film");
        films.replace(id, entityFilm);
        return entityFilm;
    }

    @GetMapping
    public List<Film> getMethodFilmsAll() {
        return List.copyOf(films.values());
    }

    @DeleteMapping("/{id}")
    public Film deleteMethodFilm(@PathVariable(name = "id") int id) {
        Film delFilm = films.get(id);
        films.remove(id);
        return delFilm;
    }
}
