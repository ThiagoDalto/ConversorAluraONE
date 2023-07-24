package telaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProgramaForm extends JFrame {
    protected JPanel pnlUp;
    protected JPanel pnlDown;

    protected JMenuBar menuBar;

    protected JMenu menu;

    protected JMenuItem opcao1;
    protected JMenuItem opcao2;
    protected JMenuItem opcao3;
    protected JMenuItem opcao4;

    protected JButton btnFechar;

    public ProgramaForm() {
        this.inicializar();
        this.eventos();
    }

    private void inicializar() {
        this.setVisible(true);
        this.setTitle("Conversor Turma 5");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setSize(800, 600);

        this.getContentPane().add(getPnlUp());
        this.getContentPane().add(getPnlDown());



    }

    private JMenuBar criarMenu() {
        if(menuBar == null) {
            menuBar = new JMenuBar();
            menu = new JMenu("Escolha um App");
            opcao1 = new JMenuItem("Conversor de moedas");
            opcao2 = new JMenuItem("Conversor de Distância");
            opcao3 = new JMenuItem("Conversor de Temperatura");
            opcao4 = new JMenuItem("Conversor de Peso");

            menuBar.setSize(300, 20);
            menuBar.setBackground(new Color(150, 255,100));

            menu.add(opcao1);
            menu.add(opcao2);
            menu.add(opcao3);
            menu.add(opcao4);

            menuBar.add(menu);
        }
        return menuBar;
    }

    public JPanel getPnlUp() {
        if(pnlUp == null) {
            pnlUp = new JPanel();
            pnlUp.add(criarMenu());
            pnlUp.setSize(800, 50);
            pnlUp.setBackground(Color.red);

        }
        return pnlUp;
    }

    public JPanel getPnlDown() {
        if(pnlDown == null) {
            pnlDown = new JPanel();
            pnlDown.setBackground(Color.pink);
            pnlDown.setSize(800, 550);



        }
        return pnlDown;
    }


    protected void menuOpcao1Click(ActionEvent ev) {

    }

    private void eventos(){
        opcao1.addActionListener(this::menuOpcao1Click);
    }
}
