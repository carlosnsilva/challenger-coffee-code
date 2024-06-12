# language: pt
# enconding: UTF-8
# Autor: Carlos Nunes


Funcionalidade: Comprando um produto

  Cenário: Casaco com sucesso
    Dado que acesso o site de compras
    Quando seleciono o produto
    E Adiciono ao carrinho
    E faco a verificacao do carrinho
    E seleciono o metodo de pagamento
    E faco a revisao do pedido
    Entao finalizo o pedido
    E faco a verificacao pos-compra