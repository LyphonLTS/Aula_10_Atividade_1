package Controller;

import Interface.TransactionHandler;

public class DepositHandler implements TransactionHandler {
  private TransactionHandler next = new WithdrawHandler();

  public void setNext(Requisition req, TransactionHandler next) {
    if (next == null) {
      this.next = next;
    } else {
      next.setNext(req, next);
    }
  }

  public void canHandle(Requisition req) {
    if (req.getTipo().toLowerCase().equals("deposito")) {
      this.transaction(req.getCliente1(), null, req.getValue());
    } else if (this.next != null) {
      this.next.canHandle(req);
    } else {
      throw new Error("Can't handle with the requisition");
    }
  }

  private void transaction(Account conta1, Account conta2, double value) {
    if (value <= 0) {
      System.out.println("Valor para depósito inválido! R$" + value);
    } else {
      conta1.setSaldo(conta1.getSaldo() + value);

      System.out.println("\nDepósito realizado com sucesso! R$" + conta1.getSaldo());
    }
  }
}
