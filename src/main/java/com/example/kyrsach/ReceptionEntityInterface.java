package com.example.kyrsach;

import org.springframework.data.repository.CrudRepository;

public interface ReceptionEntityInterface extends CrudRepository<ReceptionEntity,Integer> {
    ReceptionEntity findReceptionEntityByIdreception(Integer id);
    @Override
    void deleteById(Integer id);
}
