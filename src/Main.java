import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcao = 0;
        Usuario[] usuarios = new Usuario[100];
        int contador = 0;

        do {
            
                String entrada = JOptionPane.showInputDialog(null, "1: Cadastrar \n2: Listar \n3: Buscar \n4: Sair");
                if(entrada == null){
                    JOptionPane.showMessageDialog(null, "Programa Encerrado");
                    break;
                }
               try{ 
                opcao = Integer.parseInt(entrada);

                if (opcao == 1) {
                    String cadastro;
                    int escolha;

                    do {
                        if(contador >= usuarios.length){
                        JOptionPane.showMessageDialog(null, "Limite de usuários atingido.");
                        break;
                        }
                        cadastro = JOptionPane.showInputDialog(null, "1: Novo Cadastro: \n2: Voltar");
                        if(cadastro == null){
                            break;
                        }
                        escolha = Integer.parseInt(cadastro);
                        if (escolha == 1) {
                            String nome = JOptionPane.showInputDialog(null, "Digite seu nome: ");
                            if (nome == null) break;
                            String idadeStr = JOptionPane.showInputDialog(null, "Digite sua idade: ");
                            if (idadeStr == null) break;
                            int idade = Integer.parseInt(idadeStr);
                            String email = JOptionPane.showInputDialog(null, "Digite seu email: ");
                            if (email == null) break;
                            usuarios[contador] = new Usuario(nome, idade, email);
                            contador++;
                            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!!");
                        } else if (escolha == 2) {
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Numero Inválido.");
                        }
                        escolha = 0;
                    } while (escolha != 2);
                }

               else if (opcao == 2) {

                    if (contador == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
                    } else {
                        String lista = "";
                        for (int i = 0; i < contador; i++) {

                            lista += usuarios[i].toString() + "\n\n";
                        }
                        JOptionPane.showMessageDialog(null, lista);
                    }
                }
              else if (opcao == 3) {
                    if (contador == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
                    } else {
                        String busca = JOptionPane.showInputDialog(null, "Digite o nome para buscar: ");
                        if (busca == null) break;
                        boolean encontrado = false;
                        for (int i = 0; i < contador; i++) {
                            if (usuarios[i].nome.equalsIgnoreCase(busca)) {
                                JOptionPane.showMessageDialog(null, usuarios[i]);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                        }
                    }

                }
              else if (opcao == 4) {
                    JOptionPane.showMessageDialog(null, "Sistema Encerrado.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas numeros.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }
        } while (opcao != 4);

    }

}