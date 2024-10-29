package br.com.fiap.semaforo_sql.steps;

import br.com.fiap.semaforo_sql.service.CadastroUsuarioService;
import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.json.JSONException;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CadastroUsuarioSteps {

    CadastroUsuarioService cadastroUsuarioService = new CadastroUsuarioService();

    @Dado("que eu tenha os seguintes dados de usuário:")
    public void queEuTenhaOsSeguintesDadosDeUsuário(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            cadastroUsuarioService.setFieldsUsuario(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de usuário")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeUsuário(String endPoint) {
        cadastroUsuarioService.createUsuario(endPoint);
    }

    @Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroUsuarioService.response.getStatusCode());
    }

    @E("o corpo de resposta de erro de nome da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDeNomeDaApiDeveRetornarAMensagem(String errorMessage) {
        Map<?, ?> errorMap = cadastroUsuarioService.gson.fromJson(
                cadastroUsuarioService.response.jsonPath().prettify(), Map.class);
        Assert.assertEquals(errorMessage, errorMap.get("nome"));
    }

    @E("o corpo de resposta de erro de e-mail da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDeEMailDaApiDeveRetornarAMensagem(String errorMessage) {
        Map<?, ?> errorMap = cadastroUsuarioService.gson.fromJson(
                cadastroUsuarioService.response.jsonPath().prettify(), Map.class);
        Assert.assertEquals(errorMessage, errorMap.get("email"));
    }

    @E("o corpo de resposta de erro de senha da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDeSenhaDaApiDeveRetornarAMensagem(String errorMessage) {
        Map<?, ?> errorMap = cadastroUsuarioService.gson.fromJson(
                cadastroUsuarioService.response.jsonPath().prettify(), Map.class);
        Assert.assertEquals(errorMessage, errorMap.get("senha"));
    }


    @E("o corpo de resposta de erro de role da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDeRoleDaApiDeveRetornarAMensagem(String errorMessage) {
        Map<?, ?> errorMap = cadastroUsuarioService.gson.fromJson(
                cadastroUsuarioService.response.jsonPath().prettify(), Map.class);
        Assert.assertEquals(errorMessage, errorMap.get("role"));
    }

    @E("que o arquivo de contrato esperado é o {string}")
    public void queOArquivoDeContratoEsperadoÉO(String contract) throws IOException, JSONException {
        cadastroUsuarioService.setContract(contract);
    }

    @Então("a resposta da requisição deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisiçãoDeveEstarEmConformidadeComOContratoSelecionado() throws IOException, JSONException {
        Set<ValidationMessage> validateResponse = cadastroUsuarioService.validateResponseAgainstSchema();
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }

    @Dado("que eu possua os dados de usuário iguais ao criado no contexto")
    public void queEuPossuaOsDadosDeUsuárioIguaisAoCriadoNoContexto() {
        cadastroUsuarioService.copyUsuario();
    }

    @E("o corpo de resposta de erro de conflito da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDeConflitoDaApiDeveRetornarAMensagem(String errorMessage) {
        Map<?, ?> errorMap = cadastroUsuarioService.gson.fromJson(
                cadastroUsuarioService.response.jsonPath().prettify(), Map.class);
        Assert.assertEquals(errorMessage, errorMap.get("erro"));
    }
}
