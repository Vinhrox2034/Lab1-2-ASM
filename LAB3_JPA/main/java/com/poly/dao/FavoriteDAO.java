package com.poly.dao;

import com.poly.entity.Favorite;
import java.util.List;

public interface FavoriteDAO {
    List<Favorite> findAll();
    Favorite findById(Integer id);
    Favorite create(Favorite entity);
    Favorite update(Favorite entity);
    void deleteById(Integer id);
}
