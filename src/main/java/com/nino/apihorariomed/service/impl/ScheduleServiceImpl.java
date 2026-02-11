package com.nino.apihorariomed.service.impl;

import com.nino.apihorariomed.entity.Schedule;
import com.nino.apihorariomed.repository.ScheduleRepository;
import com.nino.apihorariomed.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Schedule> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Schedule findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Schedule create(Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    @Transactional
    public Schedule update(Integer id, Schedule schedule) {
        Schedule existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(schedule.getNombre());
            existente.setDosis(schedule.getDosis());
            existente.setHora(schedule.getHora());
            existente.setFrecuencia(schedule.getFrecuencia());
            existente.setNotas(schedule.getNotas());
            existente.setActivo(schedule.getActivo());
            return repository.save(existente);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}