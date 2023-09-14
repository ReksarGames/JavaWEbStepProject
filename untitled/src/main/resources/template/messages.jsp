<!DOCTYPE html>
<html>
<head>
    <title>Chat with User</title>
</head>
<body>
    <h1>Chat</h1>
    <ul>
        <c:forEach items="${messages}" var="message">
            <li>
                <strong>${message.senderName}:</strong> ${message.content}
            </li>
        </c:forEach>
    </ul>
    <form action="/messages/1" method="post"> <!-- Замените 1 на id получателя -->
        <input type="text" name="content" placeholder="Type your message">
        <button type="submit">Send</button>
    </form>
</body>
</html>
