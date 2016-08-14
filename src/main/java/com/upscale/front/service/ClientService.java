package com.upscale.front.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upscale.front.domain.Client;
import com.upscale.front.repository.ClientsRepository;

@Service
@Transactional
public class ClientService {
	
	private final Logger log = LoggerFactory.getLogger(ClientService.class);
	
	@Inject
	private ClientsRepository clientsRepository;
	
	public Client save(Client client) {
		log.debug("Request to save client : {}", client);
		Client result = clientsRepository.saveAndFlush(client);
		return result;
	}

}
