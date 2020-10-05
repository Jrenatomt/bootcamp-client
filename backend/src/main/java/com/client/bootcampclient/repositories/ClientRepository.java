package com.client.bootcampclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.client.bootcampclient.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
