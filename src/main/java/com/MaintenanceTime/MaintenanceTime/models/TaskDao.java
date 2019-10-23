package com.MaintenanceTime.MaintenanceTime.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface TaskDao extends CrudRepository<Task,Integer> {

}
