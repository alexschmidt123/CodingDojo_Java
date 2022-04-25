package com.coding.one2many.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.one2many.models.Ninja;
@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long>{

}
