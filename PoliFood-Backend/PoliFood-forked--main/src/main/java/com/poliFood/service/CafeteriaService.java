package com.poliFood.service;

import com.poliFood.model.Cafeteria;
import com.poliFood.projection.CafeteriaAdminView;
import com.poliFood.projection.CafeteriaView;
import com.poliFood.repository.CafeteriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeteriaService {
    private CafeteriaRepository cafeteriaRepository;

    public CafeteriaService(CafeteriaRepository cafeteriaRepository) {
        this.cafeteriaRepository = cafeteriaRepository;
    }

    public void save(Cafeteria cafeteria) {
        cafeteriaRepository.save(cafeteria);
    }

    public void delete(Cafeteria cafeteria) {
        cafeteriaRepository.delete(cafeteria);
    }

    public List<CafeteriaView> findAll() {
        return cafeteriaRepository.findAllBy();
    }

    public List<CafeteriaAdminView> findAllCafeteriaAdmin(Long id) {
        return cafeteriaRepository.findAllById(id);
    }


    public Cafeteria findByName(String name) {
        return cafeteriaRepository.findByName(name);
    }

    public CafeteriaView findCafeteriaViewByName(String name){
        return cafeteriaRepository.findAllByName(name);
    }
}
