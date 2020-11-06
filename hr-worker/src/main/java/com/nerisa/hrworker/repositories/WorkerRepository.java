package com.nerisa.hrworker.repositories;

import com.nerisa.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> { }
