<!DOCTYPE html>
<html>
<head>
    <title>Submit Form</title>
</head>
<body>
    <h1>Submit your Information</h1>
    <form action="/submitForm" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required/><br/><br/>
		
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required/><br/><br/>
		
        <button type="submit">Submit</button>
    </form>
</body>
</html> 