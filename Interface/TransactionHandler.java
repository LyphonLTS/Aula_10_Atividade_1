package Interface;

import Controller.Requisition;

public interface TransactionHandler {
  public void setNext(Requisition req, TransactionHandler next);

  public void canHandle(Requisition req);
}
