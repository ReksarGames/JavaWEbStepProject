<html>
<body>
<p>
    Users:
    <#if users??>
        <#list users as user>
            <p> ${user}
        </#list>
    </#if>

</p>
</body>
</html>