<!DOCTYPE html>
<html>
<head>
    <title>Liked Profiles</title>
</head>
<body>
    <h1>Liked Profiles</h1>
    <ul>
        <c:forEach items="${likedProfiles}" var="profile">
            <li>
                <img src="${profile.photoUrl}" alt="${profile.name} photo">
                <h2>${profile.name}</h2>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
