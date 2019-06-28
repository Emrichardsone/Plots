package me.map.Plots.models.dao;

import me.map.Plots.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Long> {
    public User findByUsername(String username);
}

