package tests.steps;

import io.cucumber.java.pt.*;
import tests.pages.homePage;

public class comprandoProdutoSteps {

    homePage pageHome;
    @Dado("que acesso o site de compras")
    public void que_acesso_o_site_de_compras() {
        pageHome = new homePage();
    }
    @Quando("seleciono o produto")
    public void seleciono_o_produto() {

    }
    @Quando("Adiciono ao carrinho")
    public void adiciono_ao_carrinho() {

    }
    @Quando("faço a verificação do carrinho")
    public void faco_a_verificacao_do_carrinho() {

    }
    @Quando("seleciono o metodo de pagamento")
    public void seleciono_o_metodo_de_pagamento() {

    }
    @Quando("faco a revisão do pedido")
    public void faco_a_revisao_do_pedido() {

    }
    @Entao("finalizo o pedido")
    public void finalizo_o_pedido() {

    }
    @Entao("faco a verificacao pos-compra")
    public void faco_a_verificacao_pos_compra() {

    }
}
