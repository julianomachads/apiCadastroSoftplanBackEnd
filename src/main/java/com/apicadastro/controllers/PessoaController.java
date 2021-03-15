package com.apicadastro.controllers;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicadastro.models.Pessoa;
import com.apicadastro.repository.PessoaRepository;


@RestController
@RequestMapping("cadastrarPessoa/")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public PessoaRepository getPessoaRepository() {
		return pessoaRepository;
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@CrossOrigin(origins = "http://localhost:3000/menu/listarPessoas")
	@GetMapping("listarPessoas")
	public List<Pessoa> form() {
		
		return getPessoaRepository().findAll();
		
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@CrossOrigin(origins = "http://localhost:3000/menu/cadastrarPessoas")
	@PostMapping("salvarPessoa")
	public String form(@RequestBody String pessoa) throws ParseException{
		
		/*ObjectMapper mapper = new ObjectMapper();
		// ... seus profiles poulados
		String jsonDataString = mapper.writeValueAsString(pessoa);
		Pessoa novapessoa = mapper.readValue(jsonDataString, Pessoa.class);
		
		Pessoa newpessoa = new Pessoa(novapessoa);
		getPessoaRepository().save(newpessoa);*/
		
		JSONObject obj;
		JSONParser parser = new JSONParser();
		
		String nome;
		String cpf;
		String sexo;
		String email;
		String nacionalidade;
		String naturalidade;
		String datanasc;
		
		obj = (JSONObject) parser.parse(pessoa);
		
		nome = (String) obj.get("nome");
		cpf = (String) obj.get("cpf");
		sexo = (String) obj.get("sexo");
		email = (String) obj.get("email");
		nacionalidade = (String) obj.get("nacionalidade");
		naturalidade = (String) obj.get("naturalidade");
		datanasc = (String) obj.get("datanasc");
		
		Pessoa p = new Pessoa();
		
		p.setNome(nome);
		p.setCpf(cpf);
		p.setSexo(sexo);
		p.setEmail(email);
		p.setNacionalidade(nacionalidade);
		p.setNaturalidade(naturalidade);
		p.setDatanasc(datanasc);
		
		getPessoaRepository().save(p);
		
		return "Pessoa salva com sucesso!";
		
		//return "Isso foi oque retornou: "+pessoa;
		
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@CrossOrigin(origins = "http://localhost:3000/menu/alterarPessoas")
	@GetMapping("getPessoa/{id}")
	public Pessoa getPessoa(@PathVariable Long id) throws ParseException {

			Optional<Pessoa> opPessoa = getPessoaRepository().findById(id);
			if(opPessoa.isPresent()) {
				
				return opPessoa.get();
				
			}else{
				return new Pessoa(id, "", "", "", "", "", "", "");
			}
		
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@CrossOrigin(origins = "http://localhost:3000/menu/alterarPessoas")
	@PutMapping("updatePessoa")
	public String updatePessoa(@RequestBody Pessoa pessoa) {
		
		getPessoaRepository().save(pessoa);
		return "Pessoa atualizada com sucesso!";
		
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@CrossOrigin(origins = "http://localhost:3000/menu/excluirPessoas")
	@DeleteMapping("excluirPessoa/{id}")
	public String deletePessoa(@PathVariable Long id) {
		
		Optional<Pessoa> opPessoa = getPessoaRepository().findById(id);
		if(opPessoa.isPresent()) {
			getPessoaRepository().delete(opPessoa.get());
			return "Pessoa deletada com sucesso!";
			
		}else{
			return "Pessoa não encontrada para exclusão!";
		}
		
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@CrossOrigin(origins = "http://localhost:3000/menu/alterarPessoas")
	@GetMapping("getLengthPessoas")
	public Long getLengthPessoas() {
		
		Long count = getPessoaRepository().count();
		
		return count;
		
	}
}
