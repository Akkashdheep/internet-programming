<style>
    .error {
        color: red;
    }
</style>
<?php
$adderr = $cityerr = $stateerr = "";
$add = $state = $city = "";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (empty($_POST["t1"])) {
        $adderr = "Enter Address";
    } 
    if (empty($_POST["t2"])) {
        $cityerr = "Enter City";
    } 
    if \(empty($_POST["t3"])) {
        $stateerr = "Enter State";
    } 
}
?
<form action="<?php $_SERVER["PHP_SELF"]; ?>" method="post">
    <label>Address :</label>
    <input type="text" name="t1">
    <span class="error">*<?php echo $adderr; ?></span><br>
    <label>City :</label>
    <input type="text" name="t2">
    <span class="error">*<?php echo $cityerr; ?></span><br>
    <label>State :</label>
    <input type="text" name="t3">
    <span class="error">*<?php echo $stateerr; ?></span><br>
    <input type="submit" name="submit" value="Submit">
</form>
<?php
$host = 'localhost';
$user = 'root';
$pass = '1234';
$db = 'tets';
$conn = new mysqli($host,$user,$pass,$db);
$ad=$_POST["t1"];
$ci=$_POST["t2"];
$st=$_POST["t3"];
$sql = "insert into addresses values('$ad','$ci','$st')";
if($conn->query($sql))
echo 'Row Inserted';
else
echo 'Not Inserted';
$conn->close();
?>
