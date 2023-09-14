<!DOCTYPE html>
<html>
<head>
    <title>Users Profile</title>
    <!-- Ваши стили и скрипты -->
</head>
<body>
    <h1>Users Profile</h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Photo URL</th>
        </tr>
        <#list profiles as profile>
            <tr>
                <td>${profile.id}</td>
                <td>${profile.name}</td>
                <td><img src="${profile.photoUrl}" alt="${profile.name}'s Photo"></td>
            </tr>
        </#list>
    </table>

    <!-- Ваши данные и контент страницы -->
</body>
</html>
