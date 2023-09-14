<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="/login" method="post">
        <input type="text" name="username" placeholder="Username">
        <button type="submit">Login</button>
    </form>
    <p>${error}</p>
</body>
</html>
