package com.microservicio.app.test.backend.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.microservicio.app.test.backend.entity.Candidato;
import com.microservicio.app.test.backend.entity.CandidatoExperiencia;
import com.microservicio.app.test.backend.entity.Educacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.microservicio.app.test.backend.dto.CandidatoExperienciaCrearDto;
import com.microservicio.app.test.backend.dto.CandidatoExperienciaDto;
import com.microservicio.app.test.backend.repository.CandidatoExperienciaRepository;

@Service
public class CandidatoExperienciaServiceImple implements CandidatoExperienciaService {

	@Autowired
	private CandidatoExperienciaRepository repo;


	@Override
	public CandidatoExperienciaDto addCandidatoExperiencia(CandidatoExperienciaCrearDto crearCandidatoExperiencia) {
				 
		if (repo.exists(Example.of(crearCandidatoExperiencia.toCandidato())))
		{
			throw new DuplicateKeyException("La experiencia del candidato " + crearCandidatoExperiencia.getCandidato().getNombre() + " ya existe");
		}

		return new CandidatoExperienciaDto(repo.save(crearCandidatoExperiencia.toCandidato()));
	}


	@Override
	public List<CandidatoExperienciaDto> findAll() {

		List<CandidatoExperiencia> candidatoExperiencias = repo.findAll();

		return candidatoExperiencias.stream().map(c -> new CandidatoExperienciaDto(c.getId(),
				c.getCandidato(), c.getFechaDesde(), c.getFechaHasta(), c.getEmpresa(), c.getCargo(),
				c.getDireccion())).collect(Collectors.toList());
		
	}

	@Override
	public CandidatoExperienciaDto updateCandidatoExperiencia(Long id, CandidatoExperienciaCrearDto crearExperiencia) {
		
		if(!repo.findById(id).isPresent())
		{
			throw new NoSuchElementException("No existe candidato experiencia con el id: " + id);
		}
		
		crearExperiencia.setId(id);
		
		return new CandidatoExperienciaDto(repo.save(crearExperiencia.toCandidato()));
	}

	@Override
	public void deleteCandidatoExperiencia(Long id) {
		
		if(!repo.findById(id).isPresent())
		{
			throw new NoSuchElementException("No existe candidato experiencia con el id: " + id);
		}
		
		repo.deleteById(id);
		
	}

	@Override
	public void deleteCandidato(Candidato candidato) {

		List<CandidatoExperiencia> listaCandidato = repo.findByCandidato(candidato);
		repo.deleteAll(listaCandidato);
	}


}
