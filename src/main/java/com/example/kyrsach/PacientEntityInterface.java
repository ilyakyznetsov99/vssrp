package com.example.kyrsach;

import org.springframework.data.repository.CrudRepository;

public interface PacientEntityInterface extends CrudRepository< PacientEntity,Integer> {
    PacientEntity findPacientEntityByIdpacient(Integer id);
    @Override
    void deleteById(Integer id);
}
