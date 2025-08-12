package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.LoginPage;
import runner.RunCucumber;
import support.printscreen;

public class LoginSteps extends RunCucumber {

    LoginPage loginPage = new LoginPage();
    private long startTime;
    private static final long TIMEOUT_MS = 30000; // 10 segundos

    // ----------------- Hooks -----------------
    @Before
    public void iniciarContagem(Scenario scenario) {
        startTime = System.currentTimeMillis();
        System.out.println("⏳ Iniciando cenário: " + scenario.getName());
    }

    @AfterStep
    public void verificarTempo(Scenario scenario) {
        long tempoPassado = System.currentTimeMillis() - startTime;
        if (tempoPassado > TIMEOUT_MS) {
            System.out.println("⚠ Timeout global atingido (" + (tempoPassado / 3000.0) + "s).");
            Assert.fail("Teste encerrado por ultrapassar o tempo limite de " + (TIMEOUT_MS / 3000) + " segundos.");
        }
    }

    @After
    public void tirar_print_do_erro(Scenario scenario) {
        System.out.println("=====================");
        System.out.println("STATUS: " + scenario.getStatus());
        System.out.println("TESTE EXECUTADO: " + scenario.getName());
        System.out.println("TAG: " + scenario.getSourceTagNames());
        System.out.println("=====================");

        if (scenario.isFailed()) {
            printscreen.addPrintTelaErro(scenario);
        }
    }

    // ----------------- Steps -----------------
    @Dado("que estou na tela de login")
    public void Estou_na_tela_login() {
        loginPage.acessaAplicacao();
        loginPage.acessarTelaLogin();
    }

    @Quando("preencho login {string} e senha {string}")
    public void preencho_login_senha(String email, String senha) {
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
    }

    @Então("clico em Login")
    public void clico_em_login() {
        loginPage.clicarLogin();
    }

    @Então("vejo mensagem de login com sucesso")
    public void mensagem_login_sucesso() {
        loginPage.verificarLoginSucesso();
    }

    @Então("vejo mensagem {string} de campo nao preenchido")
    public void mensagem_campo_nao_preenchido(String mensage) {
        loginPage.verificaCampoVazio(mensage);
    }

    @Quando("acesso a tela de cadastro de usuario")
    public void tela_acesso_cadastro_usuario() {
        loginPage.acessarTelaCadastro();
    }

    @Dado("que estou logado na aplicacao com o user {string} e senha {string}")
    public void logado_na_aplicacao_com_user_e_senha(String email, String senha) {
        loginPage.acessaAplicacao();
        loginPage.acessarTelaLogin();
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
        loginPage.clicarLogin();
        loginPage.verificarLoginSucesso();
    }
}