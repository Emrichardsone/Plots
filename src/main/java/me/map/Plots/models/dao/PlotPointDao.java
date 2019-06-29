package me.map.Plots.models.dao;

import me.map.Plots.models.PlotPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface PlotPointDao extends CrudRepository<PlotPoint, Integer>{

}