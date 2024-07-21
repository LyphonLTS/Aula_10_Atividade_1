package Controller;

import Interface.TransactionHandler;

public class TransferHandler implements TransactionHandler {
  private TransactionHandler next = null;

  public void setNext(Requisition req, TransactionHandler next) {
    if (next == null) {
      this.next = next;
    } else {
      next.setNext(req, next);
    }
  }

  public void canHandle(Requisition req) {
    if (req.getTipo().toLowerCase().equals("transferencia")) {
      this.transaction(req.getCliente1(), req.getCliente2(), req.getValue());
    } else if (this.next != null) {
      this.next.canHandle(req);
    } else {
      throw new Error("Can't handle with the requisition");
    }
  }

  private void transaction(Account conta1, Account conta2, double value) {
    if (value <= 0) {
      System.out.println("Valor inserido inválido! R$" + value);
    } else if ((conta1.getSaldo() - value) <= 0) {
      System.out.println("Valor para transferência inválido! R$" + value);
    } else {
      conta1.setSaldo(conta1.getSaldo() - value);

      conta2.setSaldo(conta2.getSaldo() + value);

      System.out.println("\nTransferência realizada com sucesso!");
      System.out.println("Saldo conta 1: " + conta1.getSaldo());
      System.out.println("Saldo conta 2: " + conta2.getSaldo());
    }
  }
}
