<!DOCTYPE html>
<html>
<head>
    <title>User Profiles</title>
</head>
<body>
    <h1>User Profiles</h1>
    <ul>
        <c:forEach items="${profiles}" var="profile">
            <li>
                <img src="${profile.photoUrl}" alt="${profile.name} photo">
                <h2>${profile.name}</h2>
                <form action="/users" method="post">
                    <input type="hidden" name="profileId" value="${profile.id}">
                    <button type="submit" name="choice" value="yes">Yes</button>
                    <button type="submit" name="choice" value="no">No</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
