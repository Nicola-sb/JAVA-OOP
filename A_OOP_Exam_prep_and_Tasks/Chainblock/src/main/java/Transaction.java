public interface Transaction {
    int getId();

    TransactionStatus getStatus();

    void setStatus(TransactionStatus newStatus);

    String  getFrom();
    String getTo();
    double getAmount();
}
