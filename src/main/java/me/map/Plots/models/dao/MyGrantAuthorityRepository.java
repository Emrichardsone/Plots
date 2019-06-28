package me.map.Plots.models.dao;

import me.map.Plots.models.MyGrantAuthority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MyGrantAuthorityRepository extends CrudRepository<MyGrantAuthority, Integer> {
    public MyGrantAuthority getByRole(String role);
}
