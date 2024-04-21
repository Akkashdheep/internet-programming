<!DOCTYPE html>
<html>
<head>
    <title>Bank Account Operations</title>
</head>
<body>

<h2>Bank Account Operations</h2>

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
    Customer Name: <input type="text" name="customer_name" required><br><br>
    Initial Balance: <input type="number" name="initial_balance" value="0" required><br><br>
    Deposit Amount: <input type="number" name="deposit_amount" value="0"><br><br>
    Withdraw Amount: <input type="number" name="withdraw_amount" value="0"><br><br>
    <input type="submit" name="submit" value="Perform Operations">
</form>

<?php
class BankAccount {
    private $balance;
    
    public function __construct($initialBalance = 0) {
        $this->balance = $initialBalance;
    }
    
    public function deposit($amount) {
        if ($amount > 0) {
            $this->balance += $amount;
            return true;
        } else {
            return false; // Deposit amount must be greater than 0
        }
    }
    
    public function withdraw($amount) {
        if ($amount > 0 && $this->balance >= $amount) {
            $this->balance -= $amount;
            return true;
        } else {
            return false; // Withdrawal amount must be greater than 0 and less than or equal to balance
        }
    }
    
    public function checkBalance() {
        return $this->balance;
    }
}

class Customer {
    private $name;
    private $bankAccount;
    
    public function __construct($name, $initialBalance = 0) {
        $this->name = $name;
        $this->bankAccount = new BankAccount($initialBalance);
    }
    
    public function deposit($amount) {
        return $this->bankAccount->deposit($amount);
    }
    
    public function withdraw($amount) {
        return $this->bankAccount->withdraw($amount);
    }
    
    public function checkBalance() {
        return $this->bankAccount->checkBalance();
    }
    
    public function getName() {
        return $this->name;
    }
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $customer_name = $_POST['customer_name'];
    $initial_balance = $_POST['initial_balance'];
    $deposit_amount = $_POST['deposit_amount'];
    $withdraw_amount = $_POST['withdraw_amount'];
    
    $customer = new Customer($customer_name, $initial_balance);
    
    echo "<p>Customer Name: " . $customer->getName() . "</p>";
    echo "<p>Initial Balance: $" . $customer->checkBalance() . "</p>";
    
    if ($deposit_amount > 0) {
        $customer->deposit($deposit_amount);
        echo "<p>After depositing $" . $deposit_amount . ", balance: $" . $customer->checkBalance() . "</p>";
    }
    
    if ($withdraw_amount > 0) {
        $result = $customer->withdraw($withdraw_amount);
        if ($result) {
            echo "<p>After withdrawing $" . $withdraw_amount . ", balance: $" . $customer->checkBalance() . "</p>";
        } else {
            echo "<p>Withdrawal failed: Insufficient balance.</p>";
        }
    }
}
?>

</body>
</html>
