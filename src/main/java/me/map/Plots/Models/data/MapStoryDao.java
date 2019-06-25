package me.map.Plots.Models.data;

import me.map.Plots.Models.MapStory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface MapStoryDao extends CrudRepository<MapStory, Integer>{

}