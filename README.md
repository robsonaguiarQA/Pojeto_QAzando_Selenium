Projeto QAzando - Automação Selenium WebDriver
Descrição:
Este projeto é uma automação de testes utilizando Selenium WebDriver com Java e Maven, desenvolvido para validar funcionalidades web de forma confiável e eficiente. O objetivo é garantir a qualidade
das aplicações através de testes automatizados integrados a uma pipeline CI/CD no GitHub Actions.

Tecnologias Utilizadas
Java 11
Selenium WebDriver
Maven
Cucumber (se aplicável no seu projeto)
GitHub Actions (CI/CD)
ChromeDriver

Como Rodar os Testes Localmente
Clone o repositório:
git clone https://github.com/robsonaguiarQA/Pojeto_QAzando_Selenium.git
Entre na pasta do projeto:
cd Pojeto_QAzando_Selenium
Execute os testes usando Maven:
mvn clean test -Dtest=RunCucumber -Dbrowser=chrome
Obs: Certifique-se de ter o Java 11 instalado e o ChromeDriver compatível configurado no seu PATH.

Integração Contínua com GitHub Actions
O projeto utiliza um workflow no GitHub Actions para rodar os testes automaticamente em pull requests para a branch main.
O pipeline inclui:
Setup do Java 11
Instalação do Google Chrome
Configuração do ChromeDriver automaticamente
Execução dos testes Maven

Próximos Passos e Melhorias

Adicionar mais cenários de testes e validações
Integrar relatórios de teste mais detalhados (ex: Allure Reports)
Expandir automação para testes de API (Rest Assured) e frontend (Cypress)
