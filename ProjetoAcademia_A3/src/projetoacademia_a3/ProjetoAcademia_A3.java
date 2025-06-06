package projetoacademia_a3;

import alunosDAO.alunosDAO;
import alunos.alunos;
import treinosDAO.treinosDAO;
import treinos.treinos;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProjetoAcademia_A3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        alunosDAO alunoDAO = new alunosDAO();
        treinosDAO treinoDAO = new treinosDAO();

        boolean executando = true;

        while (executando) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Listar alunos");
            System.out.println("3. Editar aluno");
            System.out.println("4. Excluir aluno");
            System.out.println("5. Cadastrar treino para aluno");
            System.out.println("6. Listar treinos de aluno");
            System.out.println("7. Excluir treino");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();            

            try {
                switch (opcao) {
                    case 1:
                        alunos novo = new alunos();
                        System.out.print("Nome: ");
                        novo.setNome(scanner.nextLine());
                        System.out.print("CPF: ");
                        novo.setCpf(scanner.nextLine());
                        System.out.print("Data de nascimento (yyyy-mm-dd): ");
                        novo.setData_nascimento(Date.valueOf(scanner.nextLine()));
                        System.out.print("Telefone: ");
                        novo.setTelefone(scanner.nextLine());
                        System.out.print("Email: ");
                        novo.setEmail(scanner.nextLine());
                        alunoDAO.cadastrarAluno(novo);
                        System.out.println("Aluno cadastrado com sucesso!");
                    case 2:
                        {
                            List<alunos> alunos = alunoDAO.listarAlunos();
                            for (alunos a : alunos) {
                                System.out.println("ID do aluno(a): " + a.getId() + "\nNome: " + a.getNome() + "\nEmail: " + a.getEmail());
                            }   break;
                        }
                    case 3:
                        System.out.print("ID do aluno a editar: ");
                        int idEditar = scanner.nextInt();
                        scanner.nextLine();
                        alunos editar = new alunos();
                        editar.setId(idEditar);
                        System.out.print("Novo nome: ");
                        editar.setNome(scanner.nextLine());
                        System.out.print("Novo CPF: ");
                        editar.setCpf(scanner.nextLine());
                        System.out.print("Nova data de nascimento (yyyy-mm-dd): ");
                        editar.setData_nascimento(Date.valueOf(scanner.nextLine()));
                        System.out.print("Novo telefone: ");
                        editar.setTelefone(scanner.nextLine());
                        System.out.print("Novo email: ");
                        editar.setEmail(scanner.nextLine());
                        alunoDAO.editarAluno(editar);
                        System.out.println("Aluno atualizado!");
                        break;         
                    case 4:
                        System.out.print("ID do aluno a excluir: ");
                        int idExcluir = scanner.nextInt();
                        alunoDAO.excluirAluno(idExcluir);
                        System.out.println("Aluno excluído!");
                            break;                       
                    case 5:
                        treinos treino = new treinos();
                        System.out.print("ID do aluno: ");
                        treino.setAluno_id(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Tipo de treino: ");
                        treino.setTipo_treino(scanner.nextLine());
                        System.out.print("Descrição: ");
                        treino.setDescricao(scanner.nextLine());
                        System.out.print("Duração (minutos): ");
                        treino.setDuracao_minutos(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Data de início (yyyy-mm-dd): ");
                        treino.setData_inicio(Date.valueOf(scanner.nextLine()));
                        treinoDAO.cadastrarTreino(treino);
                        System.out.println("Treino cadastrado!");
                        break;
                    case 6:
                        {
                            System.out.print("ID do aluno para ver os treinos: ");
                            int alunoId = scanner.nextInt();
                            List<treinos> treinos = treinoDAO.listarTreinosPorAluno(alunoId);
                            for (treinos t : treinos) {
                                 System.out.println("ID do treino: " + t.getId() + "\nTipo: " + t.getTipo_treino() + "\nDescricao: " + t.getDescricao() + "\nDuracao: " + t.getDuracao_minutos() + "min" + "\nData de inicio: " + t.getData_inicio());
                                }   break;                            
                        }
                    case 7:
                        System.out.print("ID do treino para excluir: ");
                        int treinoId = scanner.nextInt();
                        treinoDAO.excluirTreino(treinoId);
                        System.out.println("Treino excluído!");
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Erro de banco de dados: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
