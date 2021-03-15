package com.apicadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apicadastro.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
