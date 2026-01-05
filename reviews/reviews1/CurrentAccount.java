package reviews.reviews1;
class CurrentAccount extends Account {
    private static final double INTEREST_RATE = 0.02;

    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}