package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.service.model.Checkin;

public interface CheckpointPort {

  void saveCheckin(Checkin checkin);

}