package com.dps.repository;

import org.springframework.data.repository.CrudRepository;

import com.dps.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {

}
