import Controller.Account;
import Controller.DepositHandler;
import Controller.Requisition;

class Main {
  public static void main(String[] args) {
    Account cliente1 = new Account(0.0, 1);
    Account cliente2 = new Account(100.0, 2);

    Requisition req1 = new Requisition("deposito", 200, cliente1, null);
    Requisition req2 = new Requisition("saque", 20, cliente2, null);
    Requisition req3 = new Requisition("transferencia", 50, cliente2, cliente1);
    Requisition req4 = new Requisition("abrir_conta", 50, cliente2, null);

    DepositHandler depositHandler = new DepositHandler();

    try {
      depositHandler.canHandle(req1);
      depositHandler.canHandle(req2);
      depositHandler.canHandle(req3);
      depositHandler.canHandle(req4);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}