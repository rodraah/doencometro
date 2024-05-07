package doencometro.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    private JTextField loginField; // Campo de texto para o nome
    private JTextField senhaField; // Campo de texto para o email
    private JButton proximoButton; // Botão para avançar para a próxima tela

    public TelaLogin() {

        setTitle("Login do Usuário"); // Define o título da janela
        setSize(400, 200); // Define o tamanho da janela para 700x800
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a operação padrão de fechamento da janela
        setLocationRelativeTo(null); // Define a posição da janela centralizada na tela
        setResizable(false);

        JPanel cadastroPanel = new JPanel(); // Cria um novo painel sem layout específico
        cadastroPanel.setLayout(new BoxLayout(cadastroPanel, BoxLayout.Y_AXIS)); // Define o layout do painel como BoxLayout com orientação vertical
        cadastroPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Define a borda do painel

        JLabel loginLabel = new JLabel("Login:"); // Cria um novo rótulo para o campo de texto do login
        loginField = new JTextField(); // Cria um novo campo de texto para o login
        JLabel senhaLabel = new JLabel("Senha:"); // Cria um novo rótulo para o campo de texto de Senha
        senhaField = new JTextField(); // Cria um novo campo de texto para a Senha

        // Adiciona os componentes ao painel de cadastro
        cadastroPanel.add(loginLabel); // Adiciona o rótulo do login ao painel
        cadastroPanel.add(loginField); // Adiciona o campo de texto do login ao painel
        cadastroPanel.add(senhaLabel); // Adiciona o rótulo da senha ao painel
        cadastroPanel.add(senhaField); // Adiciona o campo de texto da senha ao painel

        // Definindo o tamanho das caixas de texto
        Dimension textFieldDimension = new Dimension(200, 25); // Nova dimensão para as caixas de texto
        loginField.setPreferredSize(textFieldDimension); // Define a nova dimensão para o campo de nome
        senhaField.setPreferredSize(textFieldDimension); // Define a nova dimensão para o campo de email

        // Cria um botão para avançar para a próxima tela
        proximoButton = new JButton("Próximo"); // Cria um novo botão com o texto "Próximo"

        // Adiciona um ActionListener ao botão "Próximo"
        proximoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém os dados do formulário
                String login = loginField.getText(); // Obtém o texto inserido no campo de texto do login
                String senha = senhaField.getText(); // Obtém o texto inserido no campo de texto da Senha
                
                if(login.equals("admin") && senha.equals("123")){
                        InserirDados.chamarInterface();
                } 

                // Fecha a tela atual
                dispose(); // Fecha a janela atual
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Cria um novo painel com layout de fluxo à direita
        buttonPanel.add(proximoButton); // Adiciona o botão "Próximo" ao painel de botões

        add(cadastroPanel, BorderLayout.CENTER); // Adiciona o painel de cadastro ao centro da janela
        add(buttonPanel, BorderLayout.SOUTH); // Adiciona o painel de botões ao final da janela
    }

   public static void chamarInterface(){
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaCadastroUsuario = new TelaLogin();
            telaCadastroUsuario.setVisible(true);
        });
   }
}

