package pages;

import org.openqa.selenium.By;
import runner.RunCucumber;

import static support.commands.*;

public class LoginPage extends RunCucumber {

    // Elementos
    private static final String URL = "http://automationpratice.com.br/";
    private By btnAcessarLogin = By.cssSelector(".right_list_fix > li > a > .fa-user");
    private By campoEmail = By.id("user");
    private By campoSenha = By.id("password");
    private By botaoFazerLogin = By.id("btnLogin");
    private By btnAcessarCadastro = By.cssSelector(".right_list_fix > li > a > .fa-lock");

    // AÇÕES/ FUNÇÕES/ MÉTODOS
    public void acessaAplicacao() {
        // Ideal abrir o driver antes em RunBase e aqui só navegar
        getDriver().get(URL);
    }

    public void acessarTelaLogin() {
        clickElement(btnAcessarLogin);
    }

    public void preencherEmail(String email) {
        preencherCampo(campoEmail, email);
    }

    public void preencherSenha(String senha) {
        preencherCampo(campoSenha, senha);
    }

    public void clicarLogin() {
        clickElement(botaoFazerLogin);
    }

    public void verificarLoginSucesso() {
        checarMensagem(By.id("swal2-title"), "Login realizado");
    }

    public void verificaCampoVazio(String mensagem) {
        checarMensagem(By.className("invalid_input"), mensagem);
    }

    public void acessarTelaCadastro() {
        clickElement(btnAcessarCadastro);
    }
}