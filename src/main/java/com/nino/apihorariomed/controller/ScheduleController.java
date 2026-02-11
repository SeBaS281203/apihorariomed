package com.nino.apihorariomed.controller;

import com.nino.apihorariomed.entity.Schedule;
import com.nino.apihorariomed.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules") // Ruta pedida en el examen
@CrossOrigin(origins = "*")   // Permite conexión desde Android/Web
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    // GET con Paginación
    @GetMapping
    public Page<Schedule> getAll(
            @RequestParam(required = false) String search,
            @PageableDefault(size = 10, sort = "id") Pageable pageable
    ) {
        return service.findAll(pageable);
    }

    // GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable Integer id) {
        Schedule schedule = service.findById(id);
        if (schedule == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(schedule);
    }

    // POST (Crear)
    @PostMapping
    public ResponseEntity<Schedule> create(@RequestBody Schedule schedule) {
        Schedule created = service.create(schedule);
        return ResponseEntity.status(201).body(created);
    }

    // PUT (Actualizar)
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> update(@PathVariable Integer id, @RequestBody Schedule schedule) {
        Schedule updated = service.update(id, schedule);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    // DELETE (Borrar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
