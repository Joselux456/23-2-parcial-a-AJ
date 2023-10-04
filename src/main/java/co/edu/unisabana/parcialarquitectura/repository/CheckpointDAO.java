package co.edu.unisabana.parcialarquitectura.repository;

import co.edu.unisabana.parcialarquitectura.repository.entity.CheckpointEntity;
import co.edu.unisabana.parcialarquitectura.repository.jpa.CheckpointRepository;
import co.edu.unisabana.parcialarquitectura.service.CheckpointPort;
import co.edu.unisabana.parcialarquitectura.service.model.Checkin;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CheckpointDAO implements CheckpointPort {

  private CheckpointRepository checkpointRepository;

  @Override
  public void saveCheckin(Checkin checkin) {
    checkpointRepository.save(CheckpointEntity.fromCheckin(checkin));
  }

}
