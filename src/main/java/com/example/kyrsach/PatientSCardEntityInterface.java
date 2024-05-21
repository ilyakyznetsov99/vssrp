package com.example.kyrsach;
import org.springframework.data.repository.CrudRepository;
public interface PatientSCardEntityInterface extends CrudRepository<PatientSCardEntity,Integer> {
    PatientSCardEntity findPatientSCardEntityByidpatientScard(Integer id);
    @Override
    void deleteById(Integer id);
}
