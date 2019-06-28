package me.map.Plots.models.dao;

import me.map.Plots.models.MapStory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface MapStoryDao extends CrudRepository<MapStory, Integer>{

}