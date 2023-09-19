
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pedro Krieser Bock
 */
public class main {
 public static void main(String[] args) {
    // Crie uma instância da tela de cadastroVIEW
    cadastroVIEW telaCadastro = new cadastroVIEW();

    // Defina a operação padrão de fechamento para encerrar o aplicativo quando a janela for fechada
    telaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Torne a tela de cadastroVIEW visível
    telaCadastro.setVisible(true);
}   
}
