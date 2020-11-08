package com.nerisa.hrworker.resources;

import com.nerisa.hrworker.entities.Worker;
import com.nerisa.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value="/workers")
@RequiredArgsConstructor
@Slf4j
public class WorkerResource {

    private final Environment environment;

    private final WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
      return  ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {

        log.info("PORT = " + environment.getProperty("local.server.port"));
        return ResponseEntity.ok(workerRepository.findById(id).get());
    }
}
