<html>
<body>
<p>
    Countries:
    <#if countries??>
        <#list countries as country>
            <p> ${country.countryName} </p>
        </#list>
    </#if>

</p>
</body>
</html>