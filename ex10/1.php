<!DOCTYPE html>
<html>
<head>
    <title>Temperature Converter</title>
</head>
<body>

<h2>Temperature Converter</h2>

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
    Temperature: <input type="text" name="temperature" required><br><br>
    From:
    <input type="radio" name="from_unit" value="celsius" checked>Celsius
    <input type="radio" name="from_unit" value="fahrenheit">Fahrenheit<br><br>
    <input type="submit" name="submit" value="Convert">
</form>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $temperature = $_POST['temperature'];
    $from_unit = $_POST['from_unit'];
    
    if ($from_unit == 'celsius') {
        $fahrenheit = ($temperature * 9/5) + 32;
        echo "<p>$temperature Celsius is $fahrenheit Fahrenheit</p>";
    } else {
        $celsius = ($temperature - 32) * 5/9;
        echo "<p>$temperature Fahrenheit is $celsius Celsius</p>";
    }
}
?>

</body>
</html>
