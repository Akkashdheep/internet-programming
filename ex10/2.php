<!DOCTYPE html>
<html>
<head>
    <title>Factorial Calculator</title>
</head>
<body>

<h2>Factorial Calculator</h2>

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
    Enter a number: <input type="number" name="number" required><br><br>
    <input type="submit" name="submit" value="Calculate Factorial">
</form>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $number = $_POST['number'];
    
    if ($number < 0) {
        echo "<p>Factorial is not defined for negative numbers.</p>";
    } elseif ($number == 0) {
        echo "<p>Factorial of 0 is 1.</p>";
    } else {
        $factorial = 1;
        for ($i = 1; $i <= $number; $i++) {
            $factorial *= $i;
        }
        echo "<p>Factorial of $number is $factorial.</p>";
    }
}
?>

</body>
</html>

