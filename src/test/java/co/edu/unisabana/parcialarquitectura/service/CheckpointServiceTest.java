package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.controller.dto.CheckpointDTO;
import co.edu.unisabana.parcialarquitectura.repository.entity.CheckpointEntity;
import co.edu.unisabana.parcialarquitectura.repository.jpa.CheckpointRepository;
import co.edu.unisabana.parcialarquitectura.service.model.Checkin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles(profiles = "test")
public class CheckpointServiceTest {

    @InjectMocks
    CheckpointService checkpointService;
    @Mock
    CheckpointPort checkpointPort;

    @Test
    void Dado_un_checkpoint_Cuando_invoca_checkin_Entonces_guarda_checkin(){
        CheckpointDTO checkpointDTO = new CheckpointDTO("Roswell","Carlos",10);
        Checkin checkin = new Checkin(checkpointDTO.facility,checkpointDTO.driver,checkpointDTO.dayOfMonth);
        checkpointService.checkin(checkpointDTO);
        Mockito.verify(checkpointPort).saveCheckin(checkin);
    }
    @Test
    void Dado_un_checkpoint_Cuando_day_of_month_es_mayor_30_checkin_Entonces_excepcion(){
        CheckpointDTO checkpointDTO = new CheckpointDTO("Roswell","Carlos",30);
        Checkin checkin = new Checkin(checkpointDTO.facility,checkpointDTO.driver,checkpointDTO.dayOfMonth);
        checkpointService.checkin(checkpointDTO);
        Assertions.assertEquals(checkin.getDayOfMonth(),30);
    }
}
