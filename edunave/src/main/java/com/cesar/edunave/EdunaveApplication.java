package com.cesar.edunave;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cesar.edunave.eletiva.Eletiva;
import com.cesar.edunave.enums.Turma;
import com.cesar.edunave.usuario.Estudante;
import com.cesar.edunave.usuario.Professor;

@SpringBootApplication
public class EdunaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdunaveApplication.class, args);
		
		// Testando cadastro de gestor
		// String nome = "Paulo Cunha";
		// String email = "paulo.cunha1@cesar.school";
		// Gestor usuario = new Gestor(nome, email);
		// usuario.cadastrarUsuario(nome, email, TipoAcesso.Gestor);

		// Cadastro de uma professora
		// String nomeProfessor = "Ana Silva";
		// String emailProfessor = "ana.silva@cesar.school";
		// Professor professor = new Professor(nomeProfessor, emailProfessor);
		// usuario.cadastrarUsuario(nomeProfessor, emailProfessor, TipoAcesso.Professor);

		// Testando o cadastro de estudantes na eletiva
		Professor professor = new Professor("Ana Silva", "ana.silva@cesar.school");
		List<String> bibliografia = new ArrayList<>();
		bibliografia.add("Livro A");
		bibliografia.add("Livro B");
		Turma turma = Turma.PrimeiroAno;
		List<Estudante> estudantesCadastrados = new ArrayList<>();
		int limiteVagas = 2;

		// Criando a eletiva
		Eletiva eletiva = new Eletiva(1, "Matemática Avançada", "Estudo avançado de matemática", professor, bibliografia, turma, estudantesCadastrados, limiteVagas);

		// Criando estudantes
		Estudante estudante1 = new Estudante("João Silva", "joao.silva@cesar.school", Turma.PrimeiroAno);
		Estudante estudante2 = new Estudante("Maria Souza", "maria.souza@cesar.school", Turma.PrimeiroAno);
		Estudante estudante3 = new Estudante("Pedro Santos", "pedro.santos@cesar.school", Turma.PrimeiroAno);

		// Testando o cadastro de estudantes na eletiva
		System.out.println("Inscrição de João: " + eletiva.cadastrarEstudante(estudante1));
		System.out.println("Inscrição de Maria: " + eletiva.cadastrarEstudante(estudante2));
		System.out.println("Inscrição de Pedro: " + eletiva.cadastrarEstudante(estudante3));
		// Por termos setado o limite de vagas pra 2, Pedro não poderá se inscrever.

		// Testando o método de visualizar estudantes cadastrados 
		List<Estudante> estudantesCadastradosNaELetiva = professor.visualizarEstudantesCadastradosEletiva(eletiva);
		System.out.println("Estudantes cadastrados na eletiva:");
		for (Estudante estudante : estudantesCadastradosNaELetiva) {
				System.out.println("Nome: " + estudante.getNome() + ", Email: " + estudante.getEmail());
		}

		// Verificando o estado da eletiva
		System.out.println("Vagas disponíveis: " + eletiva.verificarVagasDisponiveis());
		System.out.println("Eletiva bloqueada: " + eletiva.isBloqueada());
		// Deve retornar 0 e true. 0 por não ter mais vagas e bloqueada pelo mesmo motivo.
	}
}
