package Controller;

public class Requisition {
  private String tipo;
  private double value;
  private Account cliente1;
  private Account cliente2;

  public Requisition(String tipo, double value, Account cliente1, Account cliente2) {
    this.tipo = tipo;
    this.value = value;
    this.cliente1 = cliente1;
    this.cliente2 = cliente2;
  }

  public String getTipo() {
    return this.tipo;
  }

  public double getValue() {
    return this.value;
  }

  public Account getCliente1() {
    return this.cliente1;
  }

  public Account getCliente2() {
    return this.cliente2;
  }
}
