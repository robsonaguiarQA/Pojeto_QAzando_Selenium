package pages;

import org.openqa.selenium.By;
import runner.RunCucumber;

import static support.commands.checarMensagem;
import static support.commands.clickElement;

public class CadastroUsuarioPage extends RunCucumber {

    // Elementos
    private By campoNome = By.id("user");
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("password");
    private By botaoFazerCadastro = By.id("btnRegister");

    // AÇÕES/ FUNÇÕES/ MÉTODOS
    public void preencherNome(String nome) {
        getDriver().findElement(campoNome).clear();
        getDriver().findElement(campoNome).sendKeys(nome);
    }

    public void preencherEmail(String email) {
        getDriver().findElement(campoEmail).clear();
        getDriver().findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha) {
        getDriver().findElement(campoSenha).clear();
        getDriver().findElement(campoSenha).sendKeys(senha);
    }

    public void cadastrarUsuario() {
        clickElement(botaoFazerCadastro);
    }

    public void verificaCadastroSucesso() {
        checarMensagem(By.id("swal2-title"), "Cadastro realizado!");
    }
}