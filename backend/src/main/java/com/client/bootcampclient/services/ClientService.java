package com.client.bootcampclient.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.client.bootcampclient.entities.Client;
import com.client.bootcampclient.entities.Dto.ClientDTO;
import com.client.bootcampclient.repositories.ClientRepository;
import com.client.bootcampclient.services.exception.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllClients(PageRequest pageRequest){
		Page<Client> clients = repository.findAll(pageRequest);
		return clients.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado na base de dados."));
		return new ClientDTO(entity);
	}
	
}