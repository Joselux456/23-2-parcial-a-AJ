package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.controller.dto.CheckpointDTO;
import co.edu.unisabana.parcialarquitectura.service.model.Checkin;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CheckpointService {

  private CheckpointPort checkpointPort;

  public void checkin(CheckpointDTO checkpoint) {
    if (checkpoint.dayOfMonth > 30 || checkpoint.dayOfMonth < 1) {
      throw new IllegalArgumentException("Invalid date");
    }
    Checkin checkin = new Checkin(checkpoint.facility, checkpoint.driver, checkpoint.dayOfMonth);
    checkpointPort.saveCheckin(checkin);

  }
}
