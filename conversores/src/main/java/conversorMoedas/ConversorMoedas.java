package conversorMoedas;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class ConversorMoedas extends ConversorMoedasForm{



    private BigDecimal toBigDecimal(String valor) {
        try {
            return new BigDecimal(valor).setScale(4, RoundingMode.HALF_EVEN);
        } catch (Exception ex) {
            return BigDecimal.ZERO;
        }
    }

    @Override
    protected void btnConverterClick(ActionEvent ev) {

        String convertFrom = (Objects.requireNonNull(cbxMoeda1.getSelectedItem()).toString());

        switch (convertFrom){
            case "Real":
                convertFrom = "BRL";
                break;
            case "Dólar americano":
                convertFrom = "USD";
                break;
            case "Euro":
                convertFrom = "EUR";
                break;
            case "Libra Esterlina":
                convertFrom = "GBP";
                break;
            case "Peso Chileno":
                convertFrom = "CLP";
                break;
            case "Peso Argentino":
                convertFrom = "ARS";
                break;
        }


        String convertTo = (Objects.requireNonNull(cbxMoeda2.getSelectedItem()).toString());




        switch (convertTo){
            case "Real":
                convertTo = "BRL";
                break;
            case "Dólar americano":
                convertTo = "USD";
                break;
            case "Euro":
                convertTo = "EUR";
                break;
            case "Libra Esterlina":
                convertTo = "GBP";
                break;
            case "Peso Chileno":
                convertTo = "CLP";
                break;
            case "Peso Argentino":
                convertTo = "ARS";
                break;
        }

        BigDecimal amount = toBigDecimal(txtMontantePConverter.getText());


        String urlString = "https://api.exchangerate.host/convert?" + "from=" + convertFrom + "&to=" + convertTo +"&amount=" + amount;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(urlString)
                .get()
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            String stringResponse = Objects.requireNonNull(response.body()).string();
            JSONObject jsonObject = new JSONObject(stringResponse);
            txtMontanteConvertido.setText(jsonObject.getBigDecimal("result").setScale(2, RoundingMode.HALF_EVEN).toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void btnLimparClick(ActionEvent ev) {
        txtMontantePConverter.setText("");
        txtMontanteConvertido.setText("");

    }

    @Override
    protected void btnFecharClick(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
    }
}
