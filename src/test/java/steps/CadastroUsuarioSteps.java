package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import pages.CadastroUsuarioPage;
import pages.LoginPage;
import runner.RunCucumber;

public class CadastroUsuarioSteps extends RunCucumber {

    LoginPage loginPage = new LoginPage();
    CadastroUsuarioPage cadastroUsuarioPage = new CadastroUsuarioPage();

    @Dado("que estou na tela de cadastro de usuario")
    public void que_estou_na_tela_cadastro() {
        loginPage.acessaAplicacao();
        loginPage.acessarTelaCadastro();
    }

    @Dado("preencho todos os campos obrigatorios")
    public void preenche_campos_obrigatorios() {
        cadastroUsuarioPage.preencherNome("robson");
        cadastroUsuarioPage.preencherEmail("robson@gmail.com");
        cadastroUsuarioPage.preencherSenha("123456");
    }

    @Quando("clico em cadastrar")
    public void clico_em_cadastrar() {
        cadastroUsuarioPage.cadastrarUsuario();
    }

    @Quando("vejo mensagem de cadastro realizado com sucesso")
    public void vejo_mensagem_cadastro_realizado_sucesso() {
        cadastroUsuarioPage.verificaCadastroSucesso();
    }
}