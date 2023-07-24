package conversorMoedas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public abstract class ConversorMoedasForm extends JFrame {



    private static final int TAMANHO_TXT =10;
    protected JPanel pnlForm;

    protected JPanel pnlRodape;

    protected JButton btnConverter;
    protected JButton btnLimpar;
    protected JButton btnFechar;

    protected JLabel lblMoeda1;

    protected JComboBox<String> cbxMoeda1;

    protected JLabel lblMoeda2;

    protected JComboBox<String> cbxMoeda2;

    protected JLabel lblMontantePConverter;
    protected JTextField txtMontantePConverter;

    protected JLabel lblMontanteConvertido;
    protected JTextField txtMontanteConvertido;

    public ConversorMoedasForm() {
        this.inicializar();
        this.eventos();
    }

    private void inicializar() {
        this.setTitle("Conversor de moedas");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getPnlForm();
        this.getPnlRodape();
        this.setSize(600, 600);
        this.setVisible(true);

        this.getContentPane().setBackground(new Color(123, 50, 250));
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
    }

    protected abstract void btnConverterClick(ActionEvent ev);
    protected abstract void btnLimparClick(ActionEvent ev);
    protected abstract void btnFecharClick(ActionEvent ev);

    private void eventos() {
        btnConverter.addActionListener(this::btnConverterClick);
        btnLimpar.addActionListener(this::btnLimparClick);
        btnFechar.addActionListener(this::btnFecharClick);
    }

    public JPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new JPanel(new GridLayout(4, 2, 5, 5));
            pnlForm.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            String[] moedas = {"Real", "Dólar americano", "Euro", "Libra Esterlina", "Peso Argentino", "Peso Chileno"};
            HashMap<String, String> moedaISO = new HashMap<String, String>();

            moedaISO.put("Real", "BRL");
            moedaISO.put("Peso Argentino", "ARS");
            moedaISO.put("Peso Chileno", "CLP");
            moedaISO.put("Libra Esterlina", "GBP");
            moedaISO.put("Dólar americano", "USD");
            moedaISO.put("Euro", "EUR");

            lblMoeda1 = new JLabel("Moeda de origem");
            cbxMoeda1 = new JComboBox<String>(moedas);

            lblMoeda2 = new JLabel("Moeda desejada");
            cbxMoeda2 = new JComboBox<String>(moedas);

            lblMontantePConverter = new JLabel("Valor a ser convertido");
            txtMontantePConverter = new JTextField(TAMANHO_TXT);

            lblMontanteConvertido = new JLabel("Valor convertido");
            txtMontanteConvertido = new JTextField(TAMANHO_TXT);
            txtMontanteConvertido.setEditable(false);

            pnlForm.add(lblMoeda1);
            pnlForm.add(cbxMoeda1);

            pnlForm.add(lblMoeda2);
            pnlForm.add(cbxMoeda2);

            pnlForm.add(lblMontantePConverter);
            pnlForm.add(txtMontantePConverter);

            pnlForm.add(lblMontanteConvertido);
            pnlForm.add(txtMontanteConvertido);

        }

        return pnlForm;
    }

    public JPanel getPnlRodape() {
        if (pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnConverter = new JButton("Converter");
            btnLimpar = new JButton("Limpar");
            btnFechar = new JButton("Fechar");

            pnlRodape.add(btnConverter);
            pnlRodape.add(btnLimpar);
            pnlRodape.add(btnFechar);
        }
        return pnlRodape;
    }
}
