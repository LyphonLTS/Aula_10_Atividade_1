package Controller;

public class Account {
  private double saldo;
  private int numeroConta;

  public Account(double saldo, int numeroConta) {
    this.saldo = saldo;
    this.numeroConta = numeroConta;
  }

  public double getSaldo() {
    return this.saldo;
  }

  public int getNumeroConta() {
    return numeroConta;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
}
