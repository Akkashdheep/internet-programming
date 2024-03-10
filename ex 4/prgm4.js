<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sort Letters in Alphabetical Order</title>
    <script>
        function sortString(str) {
            return str.split('').sort().join('');
        }

        const inputString = 'javascript';
        const sortedString = sortString(inputString);
        document.write(`Original String: ${inputString} <br>`);
        document.write(`String with letters in alphabetical order: ${sortedString}`);
    </script>
</head>
<body>

</body>
</html>