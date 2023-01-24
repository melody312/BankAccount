fun main(args: Array<String>) {
    val bankAccount = BankAccount("Max Mustermann", 100.0, mutableListOf())
    bankAccount.deposit(50.0)
    bankAccount.withdraw(100.0)
    bankAccount.deposit(75.0)
    println("${bankAccount.accountName}'s current balance: ${bankAccount.balance} EUR")
    println("Transactions: ${bankAccount.transactions}")

}

class BankAccount(val accountName: String, var balance: Double, var transactions: MutableList<Any>) {

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            transactions.add("+$amount")
            println("Deposit of $amount EUR was successful. New balance is $balance EUR")
        } else {
            println("Invalid deposit.")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0) {
            if (balance >= amount) {
                transactions.add(-amount)
                balance -= amount
                println("Withdraw of $amount EUR was successful. New balance is $balance EUR")
            } else {
                println("There is not enough balance to proceed the withdraw.")
            }
        } else {
            println("Invalid deposit.")
        }
    }
}
