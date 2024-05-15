package doencometro.Interface;

import javax.swing.*;

import doencometro.Autenticacao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    private JTextField usuarioField; 
    private JTextField senhaField; 
    private JButton proximoButton; 

    public TelaLogin() {

        setTitle("Login do Usuário"); 
        setSize(400, 200); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); // Define a posição da janela centralizada na tela
        setResizable(false);

        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new BoxLayout(cadastroPanel, BoxLayout.Y_AXIS));
        cadastroPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usuarioLabel = new JLabel("Login:");
        usuarioField = new JTextField();
        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField();

        cadastroPanel.add(usuarioLabel);
        cadastroPanel.add(usuarioField);
        cadastroPanel.add(senhaLabel);
        cadastroPanel.add(senhaField);

        Dimension textFieldDimension = new Dimension(200, 25);
        usuarioField.setPreferredSize(textFieldDimension);
        senhaField.setPreferredSize(textFieldDimension);

        proximoButton = new JButton("Próximo");

        proximoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = usuarioField.getText();
                String senha = senhaField.getText();
                
                String resultado = Autenticacao.logar(login, senha);
                switch (resultado) {
                    case "admin":
                        InserirDados.desenharInterface(true);
                        dispose();
                        break;
                    case "upa":
                        InserirDados.desenharInterface(false);
                        dispose();
                        break;
                    case "dba":
                        Graficos.desenharInterface();
                        dispose();
                        break;
                    default:
                        JOptionPane.showMessageDialog(cadastroPanel, "Usuário e/ou senha inválido(s)!");
                        break;
                }
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(proximoButton);

        add(cadastroPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

   public static void chamarInterface(){
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaCadastroUsuario = new TelaLogin();
            telaCadastroUsuario.setVisible(true);
        });
   }
}

