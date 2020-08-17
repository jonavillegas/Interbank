Feature: Historia de carrito de compras
  Como cliente
  necesito realizar seleccionar mis productos
  para realizar una compra

  Scenario: Compra con datos de tarjeta valido
    Given validar que la web este disponible
    When generar tarjeta valida
    And obtener los datos de la tarjeta
    And seleccionar la catidad "5"
    And comprar el producto
    And ingresar los datos de la tarjeta
    And pagar el producto
