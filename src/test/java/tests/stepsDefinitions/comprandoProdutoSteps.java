package tests.stepsDefinitions;

import io.cucumber.java.pt.*;
import tests.pages.*;

public class comprandoProdutoSteps {

    homePage pageHome;
    cartPage pageCart;
    checkoutPage pageCheckout;
    confirmPage pageConfirm;
    detailsOrderPage pageDetailsOrder;

    @Dado("que acesso o site de compras")
    public void que_acesso_o_site_de_compras() {
        pageHome = new homePage();

    }
    @Quando("seleciono o produto")
    public void seleciono_o_produto() {
        pageHome.searchProduct();


    }
    @Quando("adiciono ao carrinho")
    public void adiciono_ao_carrinho() {
        pageCart = pageHome.selectProduct();

    }
    @Quando("faco a verificacao do carrinho")
    public void faco_a_verificacao_do_carrinho() {
        pageCheckout = pageCart.reviewCart();
        pageCheckout.completeForm();
    }
    @Quando("seleciono o metodo de pagamento")
    public void seleciono_o_metodo_de_pagamento() {
        pageCheckout.selectPaymentMethod();
    }
    @Quando("faco a revisao do pedido")
    public void faco_a_revisao_do_pedido() {
        pageCheckout.validateInformation();
    }
    @Entao("finalizo o pedido")
    public void finalizo_o_pedido() {
        pageConfirm = pageCheckout.finallyOrder();
    }
    @Entao("faco a verificacao pos-compra")
    public void faco_a_verificacao_pos_compra() {
        pageDetailsOrder = pageConfirm.validateOrder();
        pageDetailsOrder.viewDetailsOrder();
    }
}
