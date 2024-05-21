package com.example.kyrsach;

import org.springframework.data.repository.CrudRepository;

public interface DoctorEntityInterface  extends CrudRepository<DoctorEntity, Integer> {
    DoctorEntity findDoctorEntityByIddoctor(Integer id);
    @Override
    void deleteById(Integer id);
    /*
*/
}
