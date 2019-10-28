package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.TarefaModel;
import com.api.repository.TarefaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST TODO LIST")
@CrossOrigin(origins = "*")
public class TarefaController {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@GetMapping("/todo/list")
	@ApiOperation(value = "Retorna a Lista de Tarefas.")
	public List<TarefaModel> todoList(){
		return tarefaRepository.findAll();
	}
	
	@GetMapping("/todo/{id}")
	@ApiOperation(value = "Retorna uma Tarefas por id.")
	public TarefaModel todoId(@PathVariable(value="id") long id){
		return tarefaRepository.findById(id);
	}
	
	@DeleteMapping("/todo")
	@ApiOperation(value = "Deleta uma Tarefas.")
	public void deleteTodo(@RequestBody TarefaModel tarefa){
		tarefaRepository.delete(tarefa);
	}

        @DeleteMapping("/todo/{id}")
	@ApiOperation(value = "Deleta uma Tarefas por id.")
	public void deleteTodo(@PathVariable(value="id") long id){
		tarefaRepository.deleteById(id);
	}
	
	@PostMapping("/todo")
	@ApiOperation(value = "Salva uma Tarefas.")
	public TarefaModel save(@RequestBody TarefaModel tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	@PutMapping("/todo")
	@ApiOperation(value = "Atualiza uma Tarefas.")
	public TarefaModel update(@RequestBody TarefaModel tarefa) {
		return tarefaRepository.save(tarefa);
	}	
	
}
