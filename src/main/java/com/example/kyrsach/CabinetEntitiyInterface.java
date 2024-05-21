package com.example.kyrsach;
import org.springframework.data.repository.CrudRepository;
public interface CabinetEntitiyInterface extends CrudRepository<CabinetEntity, Integer> {
CabinetEntity findCabinetEntitiesByNumcab(Integer id);
@Override
void deleteById(Integer id);


}
