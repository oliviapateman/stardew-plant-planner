package com.example.SoloProject.Plants;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantsRepository extends CrudRepository<Plants, Integer> {

    @Query("SELECT p FROM Plants p JOIN FETCH p.jarPrice WHERE p.id = (:id)")
    public List<Plants> findJarPriceById(int id);

    @Query("SELECT p FROM Plants p WHERE p.month = (:month)")
    public List<Plants> findByMonth(int month);
}
